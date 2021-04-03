package TestTools;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadFiles {

    public ReadFiles(){}

    public String ReadConfigFile(String property) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("src\\test\\resources\\testConfig.xml");
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        NodeList nodes = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeName().equals(property)){
                return nodes.item(i).getTextContent();
            }
        }
        return "";
    }
}
