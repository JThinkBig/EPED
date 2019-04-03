package es.uned.lsi.eped.pract2018_2019;

public class ValueInt extends Value {

	/* Atributo que guarda el valor num�rico */
	private int value;
	
	/* Constructor: recibe un String con el valor num�rico */
	public ValueInt(String s) {
		this.value = Integer.parseInt(s);
	}
	
	/* M�todo que transforma el valor num�rico en un String */
	public String toString() {
		return Integer.toString(this.value);
	}
	
	/* M�todo que modifica el valor num�rico llamante, sum�ndole el valor num�rico par�metro */
	public void addValue(Value n) {
		this.value += ((ValueInt) n).value;
	}
	
	/* M�todo que modifica el valor num�rico llamante, rest�ndole el valor num�rico par�metro */
	public void subValue(Value n) {
		this.value -= ((ValueInt) n).value;
	}
	
	/* M�todo que modifica el valor num�rico llamante, rest�ndolo del valor num�rico par�metro */
	public void subFromValue(Value n) {
		this.value = ((ValueInt) n).value - this.value;
	}
	
	/* M�todo que modifica el valor num�rico llamante, multiplic�ndolo por el valor num�rico par�metro */
	public void multValue(Value n) {
		this.value *= ((ValueInt) n).value;
	}
	
	/* M�todo que indica si el valor num�rico llamante es mayor que el valor num�rico par�metro */
	public boolean greater(Value n) {
		return this.value > ((ValueInt) n).value;
	}

	/* M�todo que indica si el valor num�rico llamante es cero */
	public boolean isZero() {
		return this.value == 0;
	}
}
