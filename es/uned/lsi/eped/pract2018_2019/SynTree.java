package es.uned.lsi.eped.pract2018_2019;

import java.util.StringTokenizer;

import es.uned.lsi.eped.DataStructures.BTree;

public class SynTree {

	private BTree<Node> syntree;
	private StringTokenizer tokenizer;
	
	/* Constructor: recibe una cadena con la expresi�n en notaci�n prefija */
	public SynTree(String s) {
		tokenizer = new StringTokenizer(s);
		syntree = createSynTree();
	}
	
	/* Getter que devuelve el �rbol */
	public BTree<Node> getSynTree() {
		return syntree;
	}
	
	/* M�todo llamado por el constructor para crear el �rbol recursivamente */
	private BTree<Node> createSynTree() {
		String token = tokenizer.nextToken();
		Node node;
		switch (token) {
		case "+":
			node = new Operator(Operator.OperatorType.ADD);
			break;
		case "-":
			node = new Operator(Operator.OperatorType.SUB);
			break;
		case "*":
			node = new Operator(Operator.OperatorType.MULT);
			break;
		default:
			node = new Operand(token);
		}
		BTree<Node> tree = new BTree<Node>();
		tree.setRoot(node);
		if ( node.getNodeType() == Node.NodeType.OPERATOR ) {
			tree.setLeftChild(createSynTree());
			tree.setRightChild(createSynTree());
		}
		return tree;
	}
}
