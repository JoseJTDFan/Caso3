package estaciones;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.*;
import java.util.ArrayList;


public class estacionJS{
	
	ArrayList<TipoEstacion> arrayEstacion = new ArrayList<TipoEstacion>();

	public estacionJS() throws Exception{
		
		JSONParser parser = new JSONParser();
	    FileReader reader = new FileReader("C:\\Users\\Nuevo Usuario\\Documents\\Estaciones.json");
	    Object obj = parser.parse(reader);
	    JSONObject pJsonObj = (JSONObject)obj;
	    JSONArray array = (JSONArray)pJsonObj.get("estaciones");
		
		for(int i = 0; i < array.size() ; i++){
			JSONObject Estacion = (JSONObject)array.get(i);
			TipoEstacion ScannedEstacion = new TipoEstacion();
			ScannedEstacion.setEstacion((String) Estacion.get("estacion"));
			ScannedEstacion.setIndex(Integer.parseInt((String) Estacion.get("index")));
			ScannedEstacion.setStart(Integer.parseInt((String) Estacion.get("start")));
			ScannedEstacion.setEnd(Integer.parseInt((String) Estacion.get("end")));
            JSONArray array2 = (JSONArray)Estacion.get("estado");
            ArrayList<ArrayList<Object>> estados = new ArrayList<ArrayList<Object>>();
            
            for(int j = 0; j < array2.size(); j++){
            	JSONObject Estado = (JSONObject)array2.get(j);
            	ArrayList<Object> estadoEstacion = new ArrayList<Object>();
            	estadoEstacion.add((String) Estado.get("condition"));
            	estadoEstacion.add(Integer.parseInt((String) Estado.get("water")));
            	estadoEstacion.add(Integer.parseInt((String) Estado.get("abono")));
            	estadoEstacion.add(Integer.parseInt((String) Estado.get("temperatura")));
            	estados.add(estadoEstacion);
            	
            }
            ScannedEstacion.setEstados(estados);
            arrayEstacion.add(ScannedEstacion);
		}
		
	}
	
	public ArrayList<TipoEstacion> devolverEstacion(){
		return arrayEstacion;
	}
}	