package jardin;
import simulation.Simulation;
import Managers.PlantManager;

public class start {

	public static void main(String args[]) throws Exception{
		
		
		PlantManager manager = new PlantManager(0);
		Simulation simulator = new Simulation(manager);
		
		simulator.addObserver(manager);
		simulator.run();
		
	}
}
