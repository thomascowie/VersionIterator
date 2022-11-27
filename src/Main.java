import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;

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

            System.out.println(node.getTextContent());

        } catch(Exception e) {
            e.printStackTrace();

        }

    }
}