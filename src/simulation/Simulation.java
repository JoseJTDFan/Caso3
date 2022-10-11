package simulation;

import java.util.ArrayList;
import java.util.Random;
import Managers.Observable;
import estaciones.estacion;
import Managers.PlantManager;

public class Simulation extends Observable implements Constants{
	public int totaldays;
	public int years=1;
	public boolean running = true;
	public ArrayList<Object> estadoDia;
	private PlantManager plantManager;
	
	public Simulation(PlantManager pManager) {
		this.plantManager = pManager;
	}
	
	public void run() throws Exception {
		estacion ActiveSeason = new estacion(0);
		
		
		while (running) {
			totaldays++;
			
			if (totaldays>ActiveSeason.getEnd()) {
				ActiveSeason.changeSeason(ActiveSeason.getIndex()+1);
			}
			if (totaldays>DAYS_IN_YEARS) {
				totaldays=0;
				years++;
			}
			
			
			SimulatorReport reporte = new SimulatorReport();
			estadoDia = ActiveSeason.getEstados().get(new Random().nextInt(ActiveSeason.getEstados().size()));
			reporte.days= totaldays;
			reporte.rain= (int) estadoDia.get(1);
			reporte.abono= (int) estadoDia.get(2);
			reporte.temperatura= (int) estadoDia.get(3);
			Random randomGenerator = new Random();
			boolean randomabonar = randomGenerator.nextBoolean();
			boolean randomregar = randomGenerator.nextBoolean();
			reporte.abonar= randomabonar;
			reporte.regar= randomregar;
			
			System.out.println("-----------------------------------------------------");
			System.out.println("Days: "+totaldays+"    Years: "+years+"    "+estadoDia.get(0)+"   Regar:"+reporte.regar+"   Abonar:"+reporte.abonar);
			
			/*
			System.out.println(estadoDia.get(1));
			System.out.println(estadoDia.get(2));
			System.out.println("Days: "+totaldays+"    Years: "+years+"    "+estadoDia.get(0)+random);
			System.out.println(ActiveSeason.getEstacion());
			*/
			this.notifyObservers(reporte);
			
			Thread.sleep(DAY_IN_MILLIS);
			
			//SimulatorReport report = new SimulatorReport();
			//SimulatorReport days;
			
		}
		
	}
	
	public void updateWeather() {
		
	}

}
