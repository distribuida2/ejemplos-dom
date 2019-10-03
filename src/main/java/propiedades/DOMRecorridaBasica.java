package propiedades;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by Juan Lagostena on 04/09/16
 * jplagostena@gmail.com
 * .
 */
public class DOMRecorridaBasica {


    public static void main(String [] args) throws Exception {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        ClassLoader classLoader = DOMRecorridaBasica.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("propiedades_original.xml");
        // Procesamos el fichero XML
        Document doc = builder.parse(new InputSource(inputStream));

        Element root = doc.getDocumentElement();
        // Iteramos sobre sus children
        NodeList children = root.getChildNodes();

        for(int i=0;i<children.getLength();i++){
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(node.getNodeName());
            }
        }

    }

}
