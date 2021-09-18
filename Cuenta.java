import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.opencsv.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Cuenta{
	
	public static ArrayList<ArrayList<String>> LeerCSVDatosCuentas() throws IOException{
		
		String nombreArchivo = "DatosCuentas.csv";
		String Directorio = "C:\\ArchivosCSV\\DatosCuentas.csv";
		try{
			ArrayList<ArrayList<String>> DatosCuentas = new ArrayList<ArrayList<String>>();
			Path filePath = Paths.get(Directorio);
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosLinea = linea.split(",");
				ArrayList<String> datosTemporal = new ArrayList<String>();
				for (String dato : datosLinea){
					datosTemporal.add(dato);
				}
				DatosCuentas.add(datosTemporal);
			}
			
			ArrayList<String> DatosPrograma1 = DatosCuentas.get(0);
			
			if (DatosPrograma1.size() == 1){
				
				DatosCuentas.clear();
				Path filePathAux = Paths.get(Directorio);
				BufferedReader brd = Files.newBufferedReader(filePathAux);
				while ((linea = brd.readLine()) != null) {
					String[] datosLinea = linea.split(";");
					ArrayList<String> datosTemporal = new ArrayList<String>();
					for (String dato : datosLinea){
						datosTemporal.add(dato);
					}
					DatosCuentas.add(datosTemporal);
				}
				
			}
			
			return (DatosCuentas);
		
		}catch(IOException e){
			e.printStackTrace();
			String s = "\n-----------------------------------------------------------------------------------\nError. No se puede crear una cuenta. Compruebe que existe un archivo llamado " + nombreArchivo + " en la siguiente ubicacion: " + Directorio + "\n-----------------------------------------------------------------------------------\n";
			throw new IOException(s);
		}
		
	}
	
	public static boolean ComprobarQueNoExisteOtroNombreUsuario(String NombreUsuario, ArrayList<ArrayList<String>> DatosCuentas){
		
		ArrayList<String> NombresDeUsuarios = new ArrayList<String>();
		
		for (int i=0; i<DatosCuentas.size(); i++){
			
			ArrayList<String> DatosUsuario = DatosCuentas.get(i);
			
			NombresDeUsuarios.add(DatosUsuario.get(0));
			
		}
		
		boolean ExisteNombreUsuario = false;
		
		for (int i=0; i<NombresDeUsuarios.size(); i++){
			
			if (NombreUsuario.equals(NombresDeUsuarios.get(i))){
				
				ExisteNombreUsuario = true;
				
			}
			
		}
		
		return ExisteNombreUsuario;
		
	}
	
	public static void AgregarDatosNuevoUsuario (ArrayList<String> DatosNuevoUsuario){
		
		CSVWriter csvWriter;
		csvWriter = new CSVWriter(new FileWriter("C:\\ArchivosCSV\\DatosCuentas.csv", true)); 
		csvWriter.writeNext(DatosNuevoUsuario);
		csvWriter.close();
	}
	
}