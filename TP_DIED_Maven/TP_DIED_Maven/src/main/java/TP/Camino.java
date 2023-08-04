package TP;

import java.util.ArrayList;
import java.util.List;

public class Camino {
	private Integer id;
	private Integer origen;
	private Integer destino;
	private Integer capMaxima;
	private TipoEstadoSucursal estado;
	private String tiempodeTransito;
	
	public Camino() {};
	public Camino(Integer id,Integer origen,Integer destino,Integer capMaxima,
			      TipoEstadoSucursal estado, String  tiempo) {
		this();
		this.id = id ;
		this.origen = origen;
		this.destino = destino;
		this.capMaxima = capMaxima;
		this.estado = estado;	
		this.tiempodeTransito = tiempo;
	}
	
	public Integer getCapMaxima() {
        return capMaxima;
    }
	
	public Boolean funciona() {
		return this.estado.equals(TipoEstadoSucursal.OPERATIVA);
	}
	public Integer origen() {
		return this.origen;
	}
	public Integer destino() {
		return this.destino;
	}
	public String estadoToString() {
		if (this.estado.equals(TipoEstadoSucursal.OPERATIVA)) return "Operativo";
		return "No Operativo";
	}
	//separar en multiples
	public void modificar(Integer id,Integer origen,Integer destino,Integer capMaxima,
		      TipoEstadoSucursal estado, String  tiempo) {
		this.id = id ;
		this.origen = origen;
		this.destino = destino;
		this.capMaxima = capMaxima;
		this.estado = estado;	
		this.tiempodeTransito = tiempo;
	}
	public List<String> toListString(){
		List<String> var ;
		var = new ArrayList<>();
		var.add(this.id.toString());
		var.add(this.origen().toString());
		var.add(this.destino().toString());
		var.add(this.capMaxima.toString());
		var.add(this.estadoToString());
		var.add(this.tiempodeTransito);
		return var;
	}
}
