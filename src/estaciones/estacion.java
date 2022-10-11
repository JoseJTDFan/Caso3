package estaciones;

import java.util.ArrayList;


public class estacion extends TipoEstacion{
	
	public String condition;
	public int water;
	public int abono;
	ArrayList<TipoEstacion> seasons;

	
	public estacion(int n) throws Exception {	
		super();
		//ArrayList<TipoEstacion> seasons;	
		estacionJS estacion = new estacionJS();
		this.seasons = estacion.devolverEstacion();
		setEstacion(seasons.get(n).getEstacion());
		setIndex(seasons.get(n).getIndex());
		setStart(seasons.get(n).getStart());
		setEnd(seasons.get(n).getEnd());
		setEstados(seasons.get(n).getEstados());
		setCondition(seasons.get(n).getEstados().get(0).get(0));
		setWater(seasons.get(n).getEstados().get(0).get(1));
		setAbono(seasons.get(n).getEstados().get(0).get(2));
		setTemperatura(seasons.get(n).getEstados().get(0).get(3));
	}

	public void setCondition(Object pcondition) {
		this.condition = (String) pcondition;
	}

	public void setWater(Object pwater) {
		this.water = (int) pwater;
	}

	public void setAbono(Object pabono) {
		this.abono = (int) pabono;
	}
	public void setTemperatura(Object ptemperatura) {
		this.abono = (int) ptemperatura;
	}
	
	public void changeSeason(int g){
		if (g==4) {
			g=0;
		}
		setEstacion(seasons.get(g).getEstacion());
		setIndex(seasons.get(g).getIndex());
		setStart(seasons.get(g).getStart());
		setEnd(seasons.get(g).getEnd());
		setEstados(seasons.get(g).getEstados());
		setCondition(seasons.get(g).getEstados().get(0).get(0));
		setWater(seasons.get(g).getEstados().get(0).get(1));
		setAbono(seasons.get(g).getEstados().get(0).get(2));
		setTemperatura(seasons.get(g).getEstados().get(0).get(3));
	}
}
