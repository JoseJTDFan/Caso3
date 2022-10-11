package estaciones;

import java.util.ArrayList;

public class TipoEstacion {
		public String estacion;
		public int index;
		public int start;
		public int end;
		public ArrayList<ArrayList<Object>> estados;


	public void setEstacion(String pestacion) {
		this.estacion = pestacion;
	}

	public void setIndex(int pindex) {
		this.index = pindex;
	}
	
	public void setStart(int pstart) {
		this.start = pstart;
	}

	public void setEnd(int pend) {
		this.end = pend;
	}

	public void setEstados(ArrayList<ArrayList<Object>> pestados) {
		this.estados = pestados;
	}
	public String getEstacion() {
		return this.estacion;
	}
	
	public int getIndex() {
		System.out.println(this.index);
		return this.index;
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}

	public ArrayList<ArrayList<Object>> getEstados() {
		return  this.estados;
	}

}

