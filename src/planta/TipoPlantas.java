package planta;

import java.util.ArrayList;

public class TipoPlantas {
	public String nombre;
	public int vitalidad;
	public int consumo;
	public int vida;
	public ArrayList<ArrayList<Object>> estados;


public void setNombre(String pnombre) {
	this.nombre = pnombre;
}

public void setVitalidad(int pvitalidad) {
	this.vitalidad = pvitalidad;
}

public void setConsumo(int pconsumo) {
	this.consumo = pconsumo;
}

public void setVida(int pvida) {
	this.vida = pvida;
}

public void setEstados(ArrayList<ArrayList<Object>> pestados) {
	this.estados = pestados;
}
public String getNombre() {
	return this.nombre;
}

public int getVitalidad() {
	return this.vitalidad;
}

public int getConsumo() {
	return this.consumo;
}

public int getVida() {
	return this.vida;
}

public ArrayList<ArrayList<Object>> getEstados() {
	return  this.estados;
}

}