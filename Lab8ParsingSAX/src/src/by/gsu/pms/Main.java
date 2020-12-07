package src.by.gsu.pms;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bTitle = false;
                boolean bLink = false;
                boolean bDescription = false;
                boolean bLanguage = false;
                boolean bImage = false;
                boolean bUrl = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("title")) {
                        bTitle = true;
                    }

                    if (qName.equalsIgnoreCase("link")) {
                        bLink = true;
                    }

                    if (qName.equalsIgnoreCase("description")) {
                        bDescription = true;
                    }

                    if (qName.equalsIgnoreCase("language")) {
                        bLanguage = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bTitle) {
                        System.out.println("Title : " + new String(ch, start, length));
                        bTitle = false;
                    }

                    if (bLink) {
                        System.out.println("Link : " + new String(ch, start, length));
                        bLink = false;
                    }

                    if (bDescription) {
                        System.out.println("Description : " + new String(ch, start, length));
                        bDescription = false;
                    }

                    if (bLanguage) {
                        System.out.println("Language : " + new String(ch, start, length));
                        bLanguage = false;
                    }

                    if (bImage) {
                        System.out.println("Image : " + new String(ch, start, length));
                        bImage = false;
                    }

                }

            };

            saxParser.parse("file.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}