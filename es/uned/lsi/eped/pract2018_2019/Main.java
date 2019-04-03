package es.uned.lsi.eped.pract2018_2019;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	private static void printUsage() {
		System.err.println("Error en los par�metros de entrada:");
		System.err.println("-Primer par�metro: INT para enteros Java / SEQ para enteros con secuencias");
		System.err.println("-Segundo par�metro: nombre del fichero con las expresiones a evaluar");
	}
	
	public static void main(String [] args) throws IOException{
		if ( args.length != 2 ) {
			/* Se necesitan, exactamente, dos par�metros */
			printUsage();
		} else {
			/* Primer par�metro: clase de valores a utilizar (int/seq) */
			String value = args[0];
			switch (value.toLowerCase()) {
			case "int":
				Value.valueClass = Value.ValueClass.INT; // Se usar�n valores de la clase ValueInt
				break;
			case "seq":
				Value.valueClass = Value.ValueClass.SEQ; // Se usar�n valores de la clase ValueSeq
				break;
			default:
				/* Error en el primer par�metro */
				printUsage();
				System.exit(1);
			}
			/* Segundo par�metro: fichero de expresiones a evaluar */
			String expressions = args[1];
			StackMachine sm = new StackMachine();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new 
						FileInputStream(expressions), "UTF-8"));
				String exp;
				while((exp = in.readLine())!=null) {
					/* Imprimimos el resultado de ejecutar la m�quina pila *
					 * sobre el �rbol sint�ctico construido en base a la   *
					 * expresi�n le�da                                     */
					if ( !exp.equals("") ) {
						if ( !exp.startsWith("#") ) {
							System.out.println(sm.execute(new SynTree(exp)).toString());
						} else {
							System.out.println(exp);
						}
					}
				}
				in.close();
			} catch (IOException ex) {
				/* Error en el segundo par�metro */
				System.err.println("No se puede abrir el fichero de expresiones para su lectura.");
			}
		}
	}
}
