package excepciones;

public class E_ContraseniaInvalida extends Exception {

	// ATRIBUTOS
	private int cantIntentos;
	
	// CONSTRUCTOR
	public E_ContraseniaInvalida(String message, int cantIntentos) {
		
		super(message);
		this.cantIntentos = cantIntentos;
	}
	
	//GETTERS
	public int getCantIntentos() {  return cantIntentos;  }
	
}
