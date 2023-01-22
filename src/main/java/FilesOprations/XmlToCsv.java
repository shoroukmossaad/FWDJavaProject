package FilesOprations;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* This class convert xml files to csv*/

public class XmlToCsv extends TxtToCsv {

    public static void main(String[] args) {
        final XmlToCsv m = new XmlToCsv();

        m.doCsvFormat("files\\coursedata.xml", "files\\coursedata.csv.txt");


    }


    protected void doCsvFormat(String p1, String p2) {
        BufferedWriter bw = null;

        try {
            bw = Files.newBufferedWriter(getPaths(p2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(p1));

            // Normalize the xml structure
            document.getDocumentElement().normalize();

            // Get all the element by the tag name
            NodeList rowList = document.getElementsByTagName("row");
            bw.write("id,Course Name,Instructor,Course duration,Course time,Location");
            bw.newLine();
            for (int i = 0; i < rowList.getLength(); i++) {
                Node row = rowList.item(i);
                if (row.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList studentInfo = row.getChildNodes();
                    for (int j = 0; j < studentInfo.getLength(); j++) {
                        Node detail = studentInfo.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;

                            if (detailElement.getTagName() == "Location") {
                                bw.write(detailElement.getTextContent());
                                bw.newLine();
                            } else {
                                bw.write(detailElement.getTextContent() + ",");

                            }
                        }

                    }

                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

