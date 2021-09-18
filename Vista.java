import java.util.Scanner;

public class Vista{
	
	public static void MensajeBienvenida(){
		
		System.out.println("\n-------------------------------------------------------------------------------\nBIENVENIDO A VIAJETRIP\nEl lugar donde puede organizar sus viajes de la mejor manera");
		
	}
	
	public static void MensajeDespedida(){
		
		System.out.println("\n-------------------------------------------------------------------------------\nTenga un feliz dia.");
		
	}
	
	public static int PedirOpcionAEjecutar(){
		
		int numero = 0;
		boolean validacion = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n-----------------------------------------------------------------------------------\n¿Que desea hacer?\n1.\tCrear una cuenta\n2.\tIniciar sesion\n3.\tSalir\n");
		
		String dato = scan.nextLine();
		
		validacion = comprobarNumero(dato);
		
		if (validacion){
			numero = Integer.parseInt(dato);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("\nERROR!! Ingrese un numero entre 1 y 3\n");
			dato = scan.nextLine();
			validacion = comprobarNumero(dato);
			if (validacion){
				numero = Integer.parseInt(dato);
			}
		}
		
		return (numero);
		
	}
	
	public static ArrayList<String> PedirDatosCuenta(){
		
		
		
	}
	
	private static boolean comprobarNumero(String conjuntoCaracteres){
		try{
			Integer.parseInt(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
}