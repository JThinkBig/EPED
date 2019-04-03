package es.uned.lsi.eped.pract2018_2019;

public abstract class Value {
	public enum ValueClass {
		INT, SEQ
	}
	
	protected static ValueClass valueClass;

	public static Value construct(String s) {
	    Value value = null;
		switch ( valueClass ) {
		case INT :
			value = new ValueInt(s);
			break;
		case SEQ:
			value = new ValueSeq(s);
			break;
		}
		return value;
	}
	
	/* M�todo que transforma el valor num�rico en un String */
	public abstract String toString();
	
	/* M�todo que modifica el valor num�rico llamante, sum�ndole el valor num�rico par�metro */
	public abstract void addValue(Value n);

	/* M�todo que modifica el valor num�rico llamante, rest�ndole el valor num�rico par�metro */
	public abstract void subValue(Value n);

	/* M�todo que modifica el valor num�rico llamante, rest�ndolo del valor num�rico par�metro */
	public abstract void subFromValue(Value n);

	/* M�todo que modifica el valor num�rico llamante, multiplic�ndolo por el valor num�rico par�metro */
	public abstract void multValue(Value n);

	/* M�todo que indica si el valor num�rico llamante es mayor que el valor num�rico par�metro */
	public abstract boolean greater(Value n);
	
	/* M�todo que indica si el valor num�rico llamante es cero */
	public abstract boolean isZero();
}
