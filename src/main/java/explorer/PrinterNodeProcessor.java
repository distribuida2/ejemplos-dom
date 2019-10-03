package explorer;

import org.w3c.dom.Node;

/**
 * Created by Juan Lagostena on 04/09/16
 * jplagostena@gmail.com
 * .
 */
public class PrinterNodeProcessor implements NodeProcessor {

    public void processNode(Node node) {
        switch (node.getNodeType()) {
            case Node.COMMENT_NODE:
                this.printNodeValue("Comment", node);
                break;
            case Node.ELEMENT_NODE:
                this.printNodeName("Elemento: ", node);
                break;
            case Node.TEXT_NODE:
                this.printNodeValue("Text", node);
                break;
            case Node.ATTRIBUTE_NODE:
                this.printNodeValue("Attr", node);
                break;
            default:
                this.printNodeName("No reconocido", node);
        };
    }


    private void printNodeName(String title, Node node) {
        System.out.println(title + ": " + node.getNodeName());
    }

    private void printNodeValue(String title, Node node) {
        System.out.println(title + ": " + node.getNodeValue());
    }

}
