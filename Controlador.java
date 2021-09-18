import java.util.ArrayList;
import java.io.IOException;

public class Controlador{
	
	public static void MetodoGeneral(){
		
		Vista.MensajeBienvenida();
		
		boolean salir = true;
		
		while (salir){
			
			int opcion = Vista.PedirOpcionAEjecutar();
			
			if (opcion==1){
				try{
					ArrayList<String> DatosNuevoUsuario = Vista.PedirDatosCuenta();
					Cuenta.AgregarDatosNuevoUsuario(DatosNuevoUsuario);
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
				
			}else if(opcion==2){
				
				
				
			}else if(opcion==3){
				
				Vista.MensajeDespedida();
				salir = false;
				
			}
			
		}
		
	}
	
}