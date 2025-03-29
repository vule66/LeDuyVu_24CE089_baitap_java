import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "src/BOOK.xml";
    static List<Book> BookList = new ArrayList<>();
    public static void main(String[] args) {
        int choose;
        Scanner scanner = new Scanner(System.in);
        do{
            menu();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose){
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    System.out.println("Nhập Mã sách muốn xóa: ");
                    String N = scanner.nextLine();
                    deleteBook(N);
                    System.out.println("đã xóa!!");
                    break;
                case 4:
                    showBook();
                    break;
                case 5:
                    System.out.println("Bye bye!!!");
                    break;
                default:
                    System.out.println("Error!! mời chọn lại.");
                    break;
            }
        }while (choose!=5);
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sách muốn thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.addBook();
            BookList.add(book);
        }

        try {
            File xmlFile = new File(FILE_NAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

            if (xmlFile.exists()) {
                doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("books");
                doc.appendChild(rootElement);
            }

            for (Book B : BookList) {
                Element Bookss = doc.createElement("book");

                Element nameElement = doc.createElement("title");
                nameElement.appendChild(doc.createTextNode(B.getTenSach()));
                Bookss.appendChild(nameElement);

                Element tacgiaElement = doc.createElement("author");
                tacgiaElement.appendChild(doc.createTextNode(String.valueOf(B.getTacGia())));
                Bookss.appendChild(tacgiaElement);

                Element yearElement = doc.createElement("year");
                yearElement.appendChild(doc.createTextNode(B.getNamXuatBan()));
                Bookss.appendChild(yearElement);

                Element publisherElement = doc.createElement("publisher");
                publisherElement.appendChild(doc.createTextNode(B.getNhaXuatBan()));
                Bookss.appendChild(publisherElement);

                Element pagesElement = doc.createElement("pages");
                pagesElement.appendChild(doc.createTextNode(B.getSoTrang()));
                Bookss.appendChild(pagesElement);

                Element genreElement = doc.createElement("genre");
                genreElement.appendChild(doc.createTextNode(B.getTheLoai()));
                Bookss.appendChild(genreElement);

                Element priceElement = doc.createElement("price");
                priceElement.appendChild(doc.createTextNode(B.getGiaTien()));
                Bookss.appendChild(priceElement);

                Element isbnElement = doc.createElement("isbn");
                isbnElement.appendChild(doc.createTextNode(B.getIDsach()));
                Bookss.appendChild(isbnElement);

                doc.getDocumentElement().appendChild(Bookss);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);

            System.out.println("Dữ liệu đã được thêm vào file " + FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã sách muốn sửa: ");
        String n = sc.nextLine();
        System.out.println("Tên sách mới: ");
        String tenSach=sc.nextLine();
        System.out.println("Tên tác giả mới: ");
        String tacGia=sc.nextLine();
        System.out.println("Năm xuất bản mới: ");
        String namXuatBan=sc.nextLine();
        System.out.println("Nhà xuất bản mới: ");
        String nhaXuatBan=sc.nextLine();
        System.out.println("Số trang: ");
        String soTrang=sc.nextLine();
        System.out.println("Thể loại: ");
        String theLoai=sc.nextLine();
        System.out.println("Giá: ");
        String giaTien=sc.nextLine();

            File xml = new File(FILE_NAME);
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xml);

                NodeList bookList = doc.getElementsByTagName("book");

                for (int i = 0; i < bookList.getLength(); i++) {
                    Element book = (Element) bookList.item(i);
                    if (book.getElementsByTagName("isbn").item(0).getTextContent().equals(n)) {
                        book.getElementsByTagName("title").item(0).setTextContent(tenSach);
                        book.getElementsByTagName("author").item(0).setTextContent(tacGia);
                        book.getElementsByTagName("year").item(0).setTextContent(namXuatBan);
                        book.getElementsByTagName("publisher").item(0).setTextContent(nhaXuatBan);
                        book.getElementsByTagName("pages").item(0).setTextContent(soTrang);
                        book.getElementsByTagName("genre").item(0).setTextContent(theLoai);
                        book.getElementsByTagName("price").item(0).setTextContent(giaTien);
                        System.out.println("Đã cập nhật thành công!");

                        break;
                    }
                }


                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(xml);
                transformer.transform(source, result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    private static void deleteBook(String N) {
        File xml = new File(FILE_NAME);
        try{

            DocumentBuilderFactory factorya = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factorya.newDocumentBuilder();
            Document doc = builder.parse(xml);
            NodeList booklists = doc.getElementsByTagName("book");
            for (int i = 0; i < booklists.getLength(); i++) {
                Element booK = (Element) booklists.item(i);
                if(booK.getElementsByTagName("isbn").item(0).getTextContent().equals(N)){
                    booK.getParentNode().removeChild(booK);
                    break;
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xml);
            transformer.transform(source,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void showBook() {
        try{
            File xml = new File(FILE_NAME);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xml);
            document.getDocumentElement().normalize();
            NodeList booklists = document.getElementsByTagName("book");
            for (int i = 0; i < booklists.getLength(); i++) {
                Node node = booklists.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookK = (Element) node;
                    String tenSach = bookK.getElementsByTagName("title").item(0).getTextContent();
                    String tenTac = bookK.getElementsByTagName("author").item(0).getTextContent();
                    String namXuatban = bookK.getElementsByTagName("year").item(0).getTextContent();
                    String nhaXuatban = bookK.getElementsByTagName("publisher").item(0).getTextContent();
                    String soTrang = bookK.getElementsByTagName("pages").item(0).getTextContent();
                    String theloai = bookK.getElementsByTagName("genre").item(0).getTextContent();
                    String gia = bookK.getElementsByTagName("price").item(0).getTextContent();
                    String maSach = bookK.getElementsByTagName("isbn").item(0).getTextContent();

                    System.out.println("******************************");
                    System.out.println("Tên sách: " + tenSach);
                    System.out.println("Tác giả: " + tenTac);
                    System.out.println("Năm xuất bản: " + namXuatban);
                    System.out.println("Nhà xuất bản: " + nhaXuatban);
                    System.out.println("Số Trang: " + soTrang);
                    System.out.println("Thể loại: " + theloai);
                    System.out.println("Giá : " + gia);
                    System.out.println("Mã sách: " + maSach);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    static void menu(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("1.Thêm sách.");
        System.out.println("2.sửa thông tin sách.");
        System.out.println("3.xóa.");
        System.out.println("4.hiển thị toàn bộ sách.");
        System.out.println("5.Exit.");
        System.out.println("Nhập lựa chọn: ");
    }
}