package planta;

import java.util.ArrayList;
import simulation.SimulatorReport;
import simulation.Constants;

public class planta extends TipoPlantas implements Constants{
	
	
	ArrayList<TipoPlantas> plants;	
	public int indx;
	public String nivel;
	public int indice;
	public int nextnivel;
	public int age;
	public int minAgua;
	public int maxAgua;
	public int agua;
	public int minAbono;
	public int maxAbono;
	public int abono;
	public int minEdad;
	public int maxEdad;
	public String imagen;
	private int agPos;
	private int abPos;
	private int agNeg;
	private int abNeg;
	
	public planta(int index) throws Exception {	
		super();
		ArrayList<TipoPlantas> plants;	
		plantaJS planta = new plantaJS();
		this.indx= index;
		this.plants = planta.devolverPlantas();
		setNombre(this.plants.get(index).getNombre());
		setVitalidad(this.plants.get(index).getVitalidad());
		setConsumo(this.plants.get(index).getConsumo());
		setVida(this.plants.get(index).getVida());
		setEstados(this.plants.get(index).getEstados());
		setnivel(this.plants.get(index).getEstados().get(0).get(0));
		setindice(this.plants.get(index).getEstados().get(0).get(1));
		setnextnivel(this.plants.get(index).getEstados().get(1).get(1));
		setminAgua(this.plants.get(index).getEstados().get(0).get(2));
		setmaxAgua(this.plants.get(index).getEstados().get(0).get(3));
		setAgua(getmaxAgua());
		setminAbono(this.plants.get(index).getEstados().get(0).get(4));
		setmaxAbono(this.plants.get(index).getEstados().get(0).get(5));
		setAbono(getmaxAbono());
		setminEdad(this.plants.get(index).getEstados().get(0).get(6));
		setmaxEdad(this.plants.get(index).getEstados().get(0).get(7));
		setagPos(this.plants.get(index).getEstados().get(0).get(8));
		setagNeg(this.plants.get(index).getEstados().get(0).get(9));
		setabPos(this.plants.get(index).getEstados().get(0).get(10));
		setabNeg(this.plants.get(index).getEstados().get(0).get(11));
		setImagen(this.plants.get(index).getEstados().get(0).get(12));
	}
	
	private void setindice(Object pindice) {
		this.indice= (int) pindice;
	}

	private void setagPos(Object pagPos) {
		this.agPos= (int) pagPos;
		
	}
	
	private int getagPos() {
		return this.agPos;
		
	}

	private void setagNeg(Object pagNeg) {
		this.agNeg= (int) pagNeg;
	}
	
	private int getagNeg() {
		return this.agNeg;
		
	}

	private void setabPos(Object pagNeg) {
		this.abPos = (int) pagNeg;
		
	}
	private int getabPos() {
		return this.abPos;
		
	}

	private void setabNeg(Object pabNeg) {
		this.abNeg = (int)pabNeg;
		
	}
	private int getabNeg() {
		return this.abNeg;
		
	}

	public void setnivel(Object pnivel) {
		this.nivel = (String) pnivel;
	}
	
	public void setnextnivel(Object pnextnivel) {
		this.nextnivel = (int) pnextnivel;
	}
	
	public void setage(int page) {
		this.age = (int) page;
	}
	
	public int getage() {
		return this.age;
	}
	
	
	public void setAgua(int pAgua) {
		this.agua = pAgua;
	}
	
	public void setminAgua(Object pminAgua) {
		this.minAgua = (int) pminAgua;
		System.out.println(this.minAgua);
	}
	
	public void setmaxAgua(Object pmaxAgua) {
		this.maxAgua = (int) pmaxAgua;
		
	}
	
	public int getAgua() {
		return this.agua;
	}
	
	public int getminAgua() {
		return this.minAgua;
	}
	
	public int getmaxAgua() {
		return this.maxAgua;
	}
	
	public void setAbono(int pAbono) {
		this.abono = pAbono;
		
	}
	
	public int getAbono() {
		return this.abono;
	}
	
	public void setminAbono(Object pminAbono) {
		this.minAbono = (int) pminAbono;
		
	}
	
	public void setmaxAbono(Object pmaxAbono) {
		this.maxAbono = (int) pmaxAbono;
		
	}
	
	public int getminAbono() {
		return this.minAbono;
	}
	
	public int getmaxAbono() {
		return this.maxAbono;
	}
	
	public void setminEdad(Object pminEdad) {
		this.minEdad = (int) pminEdad;
	}

	public void setmaxEdad(Object pmaxEdad) {
		this.maxEdad = (int) pmaxEdad;
		
	}
	
	public int getminEdad() {
		return this.minEdad;
	}
	
	public int getmaxEdad() {
		return this.maxEdad;
	}
	
	public void setImagen(Object pimagen) {
		this.imagen = (String) pimagen;
	}

	public void mostrarEstados() {
		System.out.println(nombre);
		for(int i = 0; i < estados.size() ; i++) {
			System.out.println(estados.get(i));
		}
	}
	
	public void updateStatus(SimulatorReport simReport) {
		setage(this.age+1);
		setAgua(this.agua-this.consumo);
		setAbono(this.abono-this.consumo);
		if (simReport.regar) {
			setAgua(getAgua()+REGAR);
		}
		if (simReport.abonar) {
			setAbono(getAbono()+ABONAR);
		}
		setAgua(getAgua()+simReport.rain);
		if (getAgua()>=getmaxAgua() || getAgua()<=getminAgua()) {
			setVitalidad(this.vitalidad+getagNeg());
			System.out.println("******Revise sus niveles de agua");
		}
		
		else {
			if (getVitalidad()+getagPos()>100) {
				setVitalidad(this.vitalidad+(getVitalidad()-100));
			}
			else {
				setVitalidad(this.vitalidad+getagPos());
			}
			
		}
		
		if (getAbono()>=getmaxAbono() || getAbono()<=getminAbono()) {
			setVitalidad(this.vitalidad+getabNeg());
			System.out.println("******Revise sus niveles de abono");
		}
		
		else {
			if (getVitalidad()+getabPos()>100) {
				setVitalidad(this.vitalidad+(getVitalidad()-100));
			}
			else {
				setVitalidad(this.vitalidad+getabPos());
			}
			
		}
		System.out.println("Nombre: "+this.nombre+" - Estado: "+this.nivel+" - Vida: "+this.vitalidad);
		System.out.println("Nivel de Agua: "+this.agua+" - Nivel de abono: "+this.abono);
	}
	
	public void changeStatus(){	
		setnivel(this.plants.get(indx).getEstados().get(this.indice).get(0));
		if (this.indice+1<4) {
			setnextnivel(plants.get(indx).getEstados().get(this.indice+1).get(1));
		}
		setminAgua(this.plants.get(indx).getEstados().get(this.indice).get(2));
		setmaxAgua(this.plants.get(indx).getEstados().get(this.indice).get(3));
		setAgua(getmaxAgua());
		setminAbono(this.plants.get(indx).getEstados().get(this.indice).get(4));
		setmaxAbono(this.plants.get(indx).getEstados().get(this.indice).get(5));
		setAbono(getmaxAbono());
		setminEdad(this.plants.get(indx).getEstados().get(this.indice).get(6));
		setmaxEdad(this.plants.get(indx).getEstados().get(this.indice).get(7));
		setagPos(this.plants.get(indx).getEstados().get(this.indice).get(8));
		setagNeg(this.plants.get(indx).getEstados().get(this.indice).get(9));
		setabPos(this.plants.get(indx).getEstados().get(this.indice).get(10));
		setabNeg(this.plants.get(indx).getEstados().get(this.indice).get(11));
		setImagen(this.plants.get(indx).getEstados().get(this.indice).get(12));
		setindice(this.plants.get(indx).getEstados().get(this.indice).get(1));
	}
	
	public void evaluate(SimulatorReport simReport) {
		updateStatus(simReport);
		
		if (getVitalidad()<=0) {
			this.indice=3;
			changeStatus();
		}
		System.out.println(this.indice);
		if (getminEdad()<=getage() && getmaxEdad()>=getage()) {
			this.indice=indice+1;
			changeStatus();
		}
		
	}
	
}
