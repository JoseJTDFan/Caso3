package Managers;

import simulation.Constants;
import simulation.SimulatorReport;
import java.util.ArrayList;
import planta.planta;

public class PlantManager implements Constants, Observer{
	
	private ArrayList<planta> garden;
	
	public PlantManager(int index) throws Exception{
		garden = new ArrayList<planta>();
		garden.add(new planta(index));
	}
	
	public void evaluate(SimulatorReport simReport) {
		for(planta currentPlant : garden) {
			currentPlant.evaluate(simReport);
		}		
	}
	
	public void updateTemperature(int cantDays, int temperature) {
		System.out.println("actualizando temp");
	}

	public void updateWater(int cantDays, int agua) {
		System.out.println("actualizando lluvia");
	}

	public void updateAbono(int cantDays, int abono) {
	}
	

	@Override
	public void update(Observable o, Object arg) {
		SimulatorReport simReport = (SimulatorReport)arg;
		evaluate(simReport);
		/*
		 * 
		if (simReport.action.compareTo(UPDATE_DAYS)==0) {
			
		}
		
		if (simReport.action.compareTo(UPDATE_WEATHER)==0) {
			updateTemperature(simReport.days, simReport.temperature);
			updateWater(simReport.days, simReport.rain);
		}
		*/
		
	}
}
