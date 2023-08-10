package TP;

import DB.ConexionDB;

public class GestorCaminos {

public void altaCamino(Integer id, Integer origen, Integer destino, Integer capacidad ,Boolean estado, Integer tiempo) throws Exception {
 	
		TipoEstadoSucursal est;
		
		if(estado == true) {
			est = TipoEstadoSucursal.OPERATIVA;
		}
		else {
			est = TipoEstadoSucursal.NO_OPERATIVA;
		}
		
		Camino camino = new Camino(id,origen,destino,capacidad,est,tiempo);
		
		try {
			new ConexionDB().crearCamino(camino);
		} catch (Exception e) {
			throw e;
		}
		
		
		
	}
	
public void modificarCamino(Integer id, Integer origen, Integer destino, Integer capacidad ,Boolean estado, Integer tiempo) throws Exception {
	
	TipoEstadoSucursal est;
	
	if(estado == true) {
		est = TipoEstadoSucursal.OPERATIVA;
	}
	else {
		est = TipoEstadoSucursal.NO_OPERATIVA;
	}
	
	Camino camino = new Camino(id,origen,destino,capacidad,est,tiempo);
	
	try {
		new ConexionDB().modificarCamino(camino);
	} catch (Exception e) {
		throw e;
	}
	
	
}

public void bajaCamino(Camino camino) throws Exception {
	
	try {
		new ConexionDB().borrarCamino(camino);
	} catch (Exception e) {
		throw e;
	}
	
}
	
}
