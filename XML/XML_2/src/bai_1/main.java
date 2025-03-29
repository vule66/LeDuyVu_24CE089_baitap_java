package bai_1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static final String FILE_NAME = "src/bai_1/Sinhvien.xml";

    public static void main(String[] args) {
        List<sinhVien> sinhViens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            sinhVien sinhVien = new sinhVien();
            sinhVien.input();
            sinhViens.add(sinhVien);
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
                Element rootElement = doc.createElement("students");
                doc.appendChild(rootElement);
            }

            for (sinhVien sv : sinhViens) {
                Element student = doc.createElement("student");
                student.setAttribute("id", sv.getId());

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(sv.getName()));
                student.appendChild(nameElement);

                Element ageElement = doc.createElement("age");
                ageElement.appendChild(doc.createTextNode(String.valueOf(sv.getAge())));
                student.appendChild(ageElement);

                Element majorElement = doc.createElement("major");
                majorElement.appendChild(doc.createTextNode(sv.getMajor()));
                student.appendChild(majorElement);

                doc.getDocumentElement().appendChild(student);
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
}
