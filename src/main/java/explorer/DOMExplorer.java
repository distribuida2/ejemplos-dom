package explorer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.List;

/**
 * Created by Juan Lagostena on 04/09/16
 * jplagostena@gmail.com
 * .
 */
public class DOMExplorer {

    private Element root;

    public DOMExplorer(Document document) {
        this.root = document.getDocumentElement();
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node root) {
        processNode(root, new PrinterNodeProcessor());
        List<Node> nodes = XmlUtil.asList(root.getChildNodes());
        nodes.forEach(this::traversePreOrder);
    }

    private void processNode(Node node, NodeProcessor task) {
        task.processNode(node);
    }
}
