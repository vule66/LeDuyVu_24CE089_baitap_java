package bai_4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên muốn sửa: ");
        String N = sc.nextLine();
        File xml = new File("src/bai_4/sinhvien.xml");
        String Ten,Msv,lop,nganh,email;
        System.out.println("Nhập tên: ");
        Ten = sc.nextLine();
        System.out.println("Nhập MSV: ");
        Msv = sc.nextLine();
        System.out.println("Nhập lớp: ");
        lop = sc.nextLine();
        System.out.println("Nhập Ngành: ");
        nganh =sc.nextLine();
        System.out.println("Nhập email: ");
        email =sc.nextLine();
        try{
            DocumentBuilderFactory factorya = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factorya.newDocumentBuilder();
            Document doc = builder.parse(xml);
            NodeList sinhvienList = doc.getElementsByTagName("student");
            for (int i = 0; i < sinhvienList.getLength(); i++) {
                Element sv = (Element) sinhvienList.item(i);
                if(sv.getAttribute("id").equals(N)){
                sv.getElementsByTagName("name").item(0).setTextContent(Ten);
                sv.getElementsByTagName("msv").item(0).setTextContent(Msv);
                sv.getElementsByTagName("class").item(0).setTextContent(lop);
                sv.getElementsByTagName("major").item(0).setTextContent(nganh);
                sv.getElementsByTagName("email").item(0).setTextContent(email);
                    System.out.println("đã cập nhật");
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
}

