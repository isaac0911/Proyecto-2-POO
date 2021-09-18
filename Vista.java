import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;


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
		
		System.out.println("\n-----------------------------------------------------------------------------------\nQue desea hacer?\n1.\tCrear una cuenta\n2.\tIniciar sesion\n3.\tSalir\n");
		
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
	
	public static ArrayList<String> PedirDatosCuenta () throws IOException{
		
		try{
			String NombreUsuario = "";
			String Contrasena = "";
			String Nombre = "";
			String Sexo = "";
			int edad = 0;
			
			//Pedir nombre
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("\n-----------------------------------------------------------------------------------\nIngrese su nombre:");
			
			Nombre = scan.nextLine();
		
			//Pedir sexo
			
			int NumSexo = 0;
			boolean validacion = false;
			
			System.out.println("\nIngrese el numero que corresponda con su sexo\n1.\tMasculino\n2.\tFemenino");
			
			String SexoPreliminar = scan.nextLine();
			
			validacion = comprobarNumero(SexoPreliminar);
			
			if (validacion){
				NumSexo = Integer.parseInt(SexoPreliminar);
			}
		
			while (validacion = false || NumSexo<1 || NumSexo>2){
				System.out.println("\nERROR!! Ingrese un numero entre 1 y 2\n");
				SexoPreliminar = scan.nextLine();
				validacion = comprobarNumero(SexoPreliminar);
				if (validacion){
					NumSexo = Integer.parseInt(SexoPreliminar);
				}
			}
			
			if (NumSexo == 1){
				Sexo = "Masculino";
			}else{
				Sexo = "Femenino";
			}
			
			//Pedir edad
			
			edad = 0;
			validacion = false;
			
			System.out.println("\nIngrese su edad");
			
			String EdadPreliminar = scan.nextLine();
			
			validacion = comprobarNumero(EdadPreliminar);
			
			if (validacion){
				edad = Integer.parseInt(EdadPreliminar);
			}
			
			while (validacion = false || edad<18){
				System.out.println("\nERROR!! Ingrese un numero mayor o igual a 18\n");
				EdadPreliminar = scan.nextLine();
				validacion = comprobarNumero(EdadPreliminar);
				if (validacion){
					edad = Integer.parseInt(EdadPreliminar);
				}
			}
		
			//Pedir NombreUsuario
			
			System.out.println("\nIngrese un nombre de usuario");
			
			NombreUsuario = scan.nextLine();
			
			ArrayList<ArrayList<String>> DatosCuentas = Cuenta.LeerCSVDatosCuentas();
			
			boolean ExisteNombreUsuario = Cuenta.ComprobarQueNoExisteOtroNombreUsuario(NombreUsuario, DatosCuentas);
			
			while (ExisteNombreUsuario){
				
				System.out.println("\nError!! El nombre de usuario que ingreso ya existe. Intente de nuevo.");
				NombreUsuario = scan.nextLine();
				ExisteNombreUsuario = Cuenta.ComprobarQueNoExisteOtroNombreUsuario(NombreUsuario, DatosCuentas);
				
			}
		
			//PedirContraseña
			
			System.out.println("\nIngrese su contrasena");
			
			Contrasena = scan.nextLine();
			
			//Crear fila de retorno
			
			ArrayList<String> DatosNuevoUsuario = new ArrayList<String>();
			
			DatosNuevoUsuario.add(NombreUsuario);
			DatosNuevoUsuario.add(Contrasena);
			DatosNuevoUsuario.add(Nombre);
			DatosNuevoUsuario.add(Sexo);
			DatosNuevoUsuario.add(Integer.toString(edad));
		
			return (DatosNuevoUsuario);
		}
		catch(IOException e){
			String s = e.getMessage();
			throw new IOException(s);
		}
		
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