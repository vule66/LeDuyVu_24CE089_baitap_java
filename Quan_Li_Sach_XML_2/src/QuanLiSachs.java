import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class QuanLiSachs implements Initializable {
    private static final String FILE_NAME = "src/BOOK.xml";
    @FXML
    private Button Them;

    @FXML
    private TableView<Book> bangThongTinSach;

    @FXML
    private TableColumn<Book, String> cotTacGia;

    @FXML
    private TableColumn<Book, String> cotTenSach;
    @FXML
    private TableColumn<Book, String> CotGiaTien;

    @FXML
    private TableColumn<Book, String> CotNXB;

    @FXML
    private TableColumn<Book, String> CotNhaXB;

    @FXML
    private TableColumn<Book, String> CotSoTrang;

    @FXML
    private TableColumn<Book, String> CotTheLoai;

    @FXML
    private TableColumn<Book, String> CotmaSach;

    @FXML
    private Button sua;

    @FXML
    private Button thoat;

    @FXML
    private Button xoa;
    @FXML
    private TextField nhapGiaTien;

    @FXML
    private TextField nhapMaSach;

    @FXML
    private TextField nhapNXB;

    @FXML
    private TextField nhapNhaXB;

    @FXML
    private TextField nhapSoTrang;

    @FXML
    private TextField nhapTenSach;

    @FXML
    private TextField nhapTenTacGia;

    @FXML
    private TextField nhapTheLoai;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBooksFromXML();
        cotTenSach.setCellValueFactory(new PropertyValueFactory<Book , String>("tenSach"));
        cotTacGia.setCellValueFactory(new  PropertyValueFactory<Book , String>("tacGia"));
        CotNXB.setCellValueFactory(new PropertyValueFactory<Book , String>("namXuatBan"));
        CotNhaXB.setCellValueFactory(new PropertyValueFactory<Book , String>("nhaXuatBan"));
        CotSoTrang.setCellValueFactory(new PropertyValueFactory<Book , String>("soTrang"));
        CotTheLoai.setCellValueFactory(new  PropertyValueFactory<Book , String>("theLoai"));
        CotGiaTien.setCellValueFactory(new PropertyValueFactory<Book , String>("giaTien"));
        CotmaSach.setCellValueFactory(new PropertyValueFactory<Book , String>("IDsach"));

    }
    public void loadBooksFromXML() {
        try {
            File xmlFile = new File(FILE_NAME);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("book");
            ObservableList<Book> books = bangThongTinSach.getItems();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Book book = new Book(
                            element.getElementsByTagName("title").item(0).getTextContent(),
                            element.getElementsByTagName("author").item(0).getTextContent(),
                            element.getElementsByTagName("year").item(0).getTextContent(),
                            element.getElementsByTagName("publisher").item(0).getTextContent(),
                            element.getElementsByTagName("pages").item(0).getTextContent(),
                            element.getElementsByTagName("genre").item(0).getTextContent(),
                            element.getElementsByTagName("price").item(0).getTextContent(),
                            element.getElementsByTagName("isbn").item(0).getTextContent()
                    );
                    books.add(book);
                }
            }
            bangThongTinSach.setItems(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveBooksToXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("books");
            document.appendChild(rootElement);

            for (Book book : bangThongTinSach.getItems()) {
                Element bookElement = document.createElement("book");

                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(book.getTenSach()));
                bookElement.appendChild(title);

                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(book.getTacGia()));
                bookElement.appendChild(author);

                Element year = document.createElement("year");
                year.appendChild(document.createTextNode(book.getNamXuatBan()));
                bookElement.appendChild(year);

                Element publisher = document.createElement("publisher");
                publisher.appendChild(document.createTextNode(book.getNhaXuatBan()));
                bookElement.appendChild(publisher);

                Element pages = document.createElement("pages");
                pages.appendChild(document.createTextNode(book.getSoTrang()));
                bookElement.appendChild(pages);

                Element genre = document.createElement("genre");
                genre.appendChild(document.createTextNode(book.getTheLoai()));
                bookElement.appendChild(genre);

                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(book.getGiaTien()));
                bookElement.appendChild(price);

                Element isbn = document.createElement("isbn");
                isbn.appendChild(document.createTextNode(book.getIDsach()));
                bookElement.appendChild(isbn);

                rootElement.appendChild(bookElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);
            try (FileOutputStream output = new FileOutputStream(FILE_NAME)) {
                StreamResult result = new StreamResult(output);
                transformer.transform(source, result);
            }

            System.out.println("Dữ liệu đã được lưu thành công vào BOOK.xml!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void Them(ActionEvent event) {
        Book themsach = new Book(nhapTenSach.getText(), nhapTenTacGia.getText(),
                nhapNXB.getText(), nhapNhaXB.getText(), nhapSoTrang.getText(),
                nhapTheLoai.getText(), nhapGiaTien.getText(), nhapMaSach.getText());
        ObservableList<Book> books = bangThongTinSach.getItems();
        books.add(themsach);

        saveBooksToXML();
    }

    @FXML
    void Xoa(ActionEvent event) {
        int selectedIDsach = bangThongTinSach.getSelectionModel().getSelectedIndex();
        bangThongTinSach.getItems().remove(selectedIDsach);
      saveBooksToXML();

    }

    @FXML
    void Sua(ActionEvent event) {
        int selectedIDsach = bangThongTinSach.getSelectionModel().getSelectedIndex();
        if (selectedIDsach >= 0) {
            Book sachDaChon = bangThongTinSach.getItems().get(selectedIDsach);
            sachDaChon.setTenSach(nhapTenSach.getText());
            sachDaChon.setTacGia(nhapTenTacGia.getText());
            sachDaChon.setNamXuatBan(nhapNXB.getText());
            sachDaChon.setNhaXuatBan(nhapNhaXB.getText());
            sachDaChon.setSoTrang(nhapSoTrang.getText());
            sachDaChon.setTheLoai(nhapTheLoai.getText());
            sachDaChon.setGiaTien(nhapGiaTien.getText());
            sachDaChon.setIDsach(nhapMaSach.getText());

            bangThongTinSach.refresh();

            saveBooksToXML();
        }
    }
    @FXML
    void thoat(ActionEvent event) {
        System.exit(0);
    }
}
