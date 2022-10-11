package planta;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.*;
import java.util.ArrayList;


public class plantaJS{
	
	ArrayList<TipoPlantas> arrayPlantas = new ArrayList<TipoPlantas>();

	public plantaJS() throws Exception{
		
		JSONParser parser = new JSONParser();
	    FileReader reader = new FileReader("C:\\Users\\Nuevo Usuario\\Documents\\Planta.json");
	    Object obj = parser.parse(reader);
	    JSONObject pJsonObj = (JSONObject)obj;
	    JSONArray array = (JSONArray)pJsonObj.get("Planta");
		
		for(int i = 0; i < array.size() ; i++){
			JSONObject Planta = (JSONObject)array.get(i);
			TipoPlantas ScannedPlanta = new TipoPlantas();
			ScannedPlanta.setNombre((String) Planta.get("nombre"));
			ScannedPlanta.setVitalidad(Integer.parseInt((String) Planta.get("vitalidad")));
			ScannedPlanta.setConsumo(Integer.parseInt((String) Planta.get("consumo")));
			ScannedPlanta.setVida(Integer.parseInt((String) Planta.get("vida"))); 
            JSONArray array2 = (JSONArray)Planta.get("estados");
            ArrayList<ArrayList<Object>> estados = new ArrayList<ArrayList<Object>>();
            
            for(int j = 0; j < array2.size(); j++){
            	JSONObject Estado = (JSONObject)array2.get(j);
            	ArrayList<Object> estadoPlanta = new ArrayList<Object>();
            	estadoPlanta.add((String) Estado.get("nivel"));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("indice")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("minAgua")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("maxAgua")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("minAbono")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("maxAbono")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("minEdad")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("maxEdad")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("aguaPositivo")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("aguaNegativo")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("abonoPositivo")));
            	estadoPlanta.add(Integer.parseInt((String) Estado.get("abonoNegativo")));
            	estadoPlanta.add((String) Estado.get("imagen"));
            	estados.add(estadoPlanta);
            	
            }
            ScannedPlanta.setEstados(estados);
            arrayPlantas.add(ScannedPlanta);
		}
		
	}
	
	public ArrayList<TipoPlantas> devolverPlantas(){
		return arrayPlantas;
	}
}	

