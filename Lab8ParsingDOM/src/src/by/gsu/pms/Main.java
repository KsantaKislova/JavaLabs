package src.by.gsu.pms;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main {

    public static void main(String[] args) {

        try {
            File inputFile = new File("file.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputFile);
            doc.getDocumentElement().normalize(); // merges adjacent text() nodes and removes empty ones in the whole document.
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("channel");
            System.out.print("--------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
                    System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("Language : " + eElement.getElementsByTagName("language").item(0).getTextContent());
                    System.out.println("Image : " + eElement.getElementsByTagName("image").item(0).getTextContent());
                }
            }

            NodeList itemsNList = doc.getElementsByTagName("item");
            System.out.print("--------------------------");
            for (int temp = 0; temp < itemsNList.getLength(); temp++) {
                Node nNode = itemsNList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
                    System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("pubDate : " + eElement.getElementsByTagName("pubDate").item(0).getTextContent());
                    System.out.println("Category : " + eElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("Guid : " + eElement.getElementsByTagName("guid").item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
