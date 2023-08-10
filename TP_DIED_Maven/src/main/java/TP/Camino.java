package TP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Camino {
	private Integer id;
	private Integer origen;
	private Integer destino;
	private Integer capMaxima;
	private TipoEstadoSucursal estado;
	private Integer tiempodeTransito;
	
	public Camino() {};
	public Camino(Integer id,Integer origen,Integer destino,Integer capMaxima,
			      TipoEstadoSucursal estado, Integer  tiempo) {
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
	public Integer getOrigen() {
		return this.origen;
	}
	public Integer getDestino() {
		return this.destino;
	}
	public String estadoToString() {
		if (this.estado.equals(TipoEstadoSucursal.OPERATIVA)) return "Operativo";
		return "No Operativo";
	}
	//separar en multiples
	public void modificar(Integer id,Integer origen,Integer destino,Integer capMaxima,
		      TipoEstadoSucursal estado, Integer  tiempo) {
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
		var.add(this.getOrigen().toString());
		var.add(this.getDestino().toString());
		var.add(this.capMaxima.toString());
		var.add(this.estadoToString());
		var.add((this.tiempodeTransito).toString());
		return var;
	}
	
	public Integer getID() {
		
		return id;
		
	}
	
	public Integer getTiempoTransito() {
		return tiempodeTransito;
	}
	public TipoEstadoSucursal getEstado() {
		return estado;
	}
	public void setEstado(TipoEstadoSucursal estado) {
		this.estado = estado;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setOrigen(Integer origen) {
		this.origen = origen;
	}
	public void setDestino(Integer destino) {
		this.destino = destino;
	}
	public void setCapMaxima(Integer capMaxima) {
		this.capMaxima = capMaxima;
	}
	public void setTiempodeTransito(Integer tiempodeTransito) {
		this.tiempodeTransito = tiempodeTransito;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camino)) return false;
        Camino other = (Camino) o;
        return Objects.equals(origen, other.origen) &&
               Objects.equals(destino, other.destino) &&
               Integer.compare(capMaxima, other.capMaxima) == 0;
    }
    
	
}
