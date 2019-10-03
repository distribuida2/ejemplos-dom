package equipos;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class DomFiguraEquipo {

    public String dameFiguraDelPartido(String filename) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        ClassLoader classLoader = DomFiguraEquipo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        // Procesamos el fichero XML
        Document doc = builder.parse(new InputSource(inputStream));
        NodeList nodeList = doc.getElementsByTagName("figura");
        if (nodeList.getLength() == 0) {
            throw new SinFiguraException("No hay figuras en el xml " + filename);
        }
        return nodeList.item(0).getChildNodes().item(0).getNodeValue();
    }
}
