package TP;

import java.util.List;

public class Recorrido {

	Sucursal sucursalOrigen;
	Sucursal sucursalDestino;
	List<Camino> caminos;
	Integer tiempo;
	
	public Recorrido(Sucursal sucursalO, Sucursal sucursalD, List<Camino> list,Integer tiempo) {

		this.sucursalOrigen = sucursalO;
		this.sucursalDestino = sucursalD;
		this.caminos = list;
		this.tiempo = tiempo;
		
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public List<Camino> getCaminos() {
		return caminos;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}
	
	
}
