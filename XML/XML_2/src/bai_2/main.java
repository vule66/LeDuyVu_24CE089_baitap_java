package bai_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class main {
    public static void main(String[] args) {
       try{
           File xml = new File("src/bai_2/company.xml");
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = null;
           builder = factory.newDocumentBuilder();
           Document document = builder.parse(xml);
           document.getDocumentElement().normalize();
           NodeList employeeList = document.getElementsByTagName("employee");
           for (int i = 0; i < employeeList.getLength(); i++) {
               Node node = employeeList.item(i);

               if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element employee = (Element) node;
                   String id = employee.getAttribute("id");
                   String name = employee.getElementsByTagName("name").item(0).getTextContent();
                   String email = employee.getElementsByTagName("email").item(0).getTextContent();
                   String phone = employee.getElementsByTagName("phone").item(0).getTextContent();
                   String departmentName = employee.getElementsByTagName("department").item(0)
                           .getChildNodes().item(1).getTextContent();
                   String location = employee.getElementsByTagName("location").item(0).getTextContent();

                   System.out.println("Employee ID: " + id);
                   System.out.println("Name: " + name);
                   System.out.println("Email: " + email);
                   System.out.println("Phone: " + phone);
                   System.out.println("Department: " + departmentName);
                   System.out.println("Location: " + location);
               }
           }
        }catch (Exception e){
           e.printStackTrace();
       }
    }
}
