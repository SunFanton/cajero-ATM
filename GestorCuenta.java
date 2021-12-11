package cajeroAutomatico;

public class GestorCuenta {

	private static int SALDO = 50000;
	
	
	//Metodos------------------------------
	
	//Resetear saldo
	public static void resetearSaldo() {
		SALDO = 50000;
	}
	
	//Obtener saldo
	public static int obtenerSaldo() {
		
		return SALDO;
	}
	
	//Extraer y transferir dinero
	public static boolean restarDinero(int monto) {
		
		if((SALDO-monto)>0) {
			SALDO -= monto;
			return true;
		}
		else {
			return false;
		}
	}

	//Depositar dinero
	public static boolean sumarDinero(int monto) {
		
		if(monto<0 || monto>50000)
			return false;
		else {
			SALDO += monto;
			return true;
		}
	}
	
}
