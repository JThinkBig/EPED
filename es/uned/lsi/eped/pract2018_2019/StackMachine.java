package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.pract2018_2019.Node.NodeType;

public class StackMachine {

	public StackMachine() {
	}
	
	public Operand execute(SynTree syn) {
		//Recursively call itself
		
		Operand left = (Operand)syn.getSynTree().getLeftChild().getRoot();
		Operand right;
		Operator operator;

		if ( !syn.getSynTree().isEmpty() ) {
			if ( syn.getSynTree().getRightChild().getRoot().getNodeType() == NodeType.OPERATOR ) {
				operator = (Operator)syn.getSynTree().getRightChild().getRoot();
				right = execute( (SynTree)syn.getSynTree().getRightChild() );
			} else {
				return (Operand)syn.getSynTree().getRightChild();
			}
			switch ( operator.getOperatorType() ) {
				case ADD:
					left.add(right);
					break;
				case SUB:
					left.sub(right);
					break;
				case MULT:
					left.mult(right);
					break;
			}
			return left;
		}
		return new Operand("0");
	}
}