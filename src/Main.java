import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("Test/pom.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.parse(file);

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("version");

            Node node = nodeList.item(0);
            System.out.println("\nNode Name :" + node.getNodeName());

            String versionStr = node.getTextContent();
            System.out.println(versionStr);

            System.out.println("Logans Test");

            Date currentYear = new Date();
            String yearStr = currentYear.toString();
            yearStr = yearStr.substring(yearStr.length() - 2);
            System.out.println(versionStr.indexOf(yearStr));

        } catch(Exception e) {
            e.printStackTrace();

        }

    }
}