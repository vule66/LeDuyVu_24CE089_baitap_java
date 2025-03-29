import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            // Tạo SAXParserFactory và SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            File xmlFile = new File("baitapVD_1+2/products.xml");

            // Tạo handler để xử lý sự kiện SAX
            DefaultHandler handler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            // Đọc tài liệu XML
            saxParser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
