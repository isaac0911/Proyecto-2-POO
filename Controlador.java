public class Controlador{
	
	public static void MetodoGeneral(){
		
		Vista.MensajeBienvenida();
		
		boolean salir = true;
		
		while (salir){
			
			int opcion = Vista.PedirOpcionAEjecutar();
			
			if (opcion==1){
				
				ArrayList<String> DatosCuenta = Vista.PedirDatosCuenta();
				
			}else if(opcion==2){
				
				
				
			}else if(opcion==3){
				
				Vista.MensajeDespedida();
				
			}
			
		}
		
	}
	
}