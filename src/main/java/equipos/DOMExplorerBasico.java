package equipos;

import explorer.DOMExplorer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Juan Lagostena on 04/09/16
 * jplagostena@gmail.com
 * .
 */
public class DOMExplorerBasico {


    public static void main(String [] args) throws ParserConfigurationException, IOException, SAXException {

        // Creamos el parser
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        ClassLoader classLoader = DOMExplorerBasico.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("quilmes_2012.xml");
        // Procesamos el fichero XML
        Document doc = builder.parse(new InputSource(inputStream));

        DOMExplorer domExplorer = new DOMExplorer(doc);
        domExplorer.traversePreOrder();

    }



}
