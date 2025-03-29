package bai_3;

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
        System.out.println("Nhập ID sinh viên muốn xóa: ");
        String N = sc.nextLine();
        File xml = new File("src/bai_3/sinhvien.xml");
        try{
            DocumentBuilderFactory factorya = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factorya.newDocumentBuilder();
            Document doc = builder.parse(xml);
            NodeList sinhvienList = doc.getElementsByTagName("student");
            for (int i = 0; i < sinhvienList.getLength(); i++) {
                Element sv = (Element) sinhvienList.item(i);
                if(sv.getAttribute("id").equals(N)){
                    sv.getParentNode().removeChild(sv);
                    System.out.println("đã xóa!!");
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
