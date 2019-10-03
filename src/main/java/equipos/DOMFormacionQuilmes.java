package equipos;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Juan Lagostena on 01/09/17
 * .
 */
public class DOMFormacionQuilmes {


    public static void main(String [] args) throws IOException, SAXException, ParserConfigurationException {
        //cargamos el XML en un input stream
        ClassLoader classLoader = DOMFormacionQuilmes.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("quilmes_2012.xml");
        // Creamos el parser y parseamos el input stream
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new InputSource(inputStream));

        NodeList nodeList = doc.getElementsByTagName("visitante");
        final Node visitante = nodeList.item(0);
        Node formacion = getUniqueNodeByName(visitante.getChildNodes(), "formacion");
        Collection<Node> quilmesPlayersNodes = getNodesByName(formacion.getChildNodes(), "jugador");
        for (Node player : quilmesPlayersNodes) {
            System.out.println(player.getFirstChild().getNodeValue());
        }
    }

    //hacerlo más fácil
    static Collection<Node> getNodesByName(NodeList nodeList, String name) {
        List<Node> nodeListToReturn = new ArrayList<>();
        for (int idx = 0 ; idx < nodeList.getLength(); idx++) {
            Node node = nodeList.item(idx);
            if (node.getNodeName().equals(name)) {
                nodeListToReturn.add(node);
            }
        }
        return nodeListToReturn;
    }

    static Node getUniqueNodeByName(NodeList nodeList, String name) {
        Collection<Node> nodesFound = getNodesByName(nodeList, name);
        if (!nodesFound.isEmpty() && nodesFound.size() > 1) {
            throw new IllegalStateException("Se encontró más de 1 nodo con ese nombre");
        }
        return nodesFound.iterator().next();
    }

}
