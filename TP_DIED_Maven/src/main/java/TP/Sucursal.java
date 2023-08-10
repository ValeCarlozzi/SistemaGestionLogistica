package TP;

import java.util.Objects;

public class Sucursal {
  	private Integer id;
  	private String nombre;
  	private String horarioapertura;
  	private String horariocierre;
  	private TipoEstadoSucursal estado;
  	
  	public Sucursal(Integer id , String nombre ,String horarioA,
			   String horarioC, TipoEstadoSucursal estado) {
	
	this.id = id;
	this.nombre = nombre;
	this.horarioapertura = horarioA;
	this.horariocierre = horarioC;
	this.estado = estado;
}
  	
  	public void modificarSucursal (Integer id , String nombre ,String horarioApertura,
  			   String horarioCierre, TipoEstadoSucursal estado,
  			   String direccion) {
  		this.id = id;
  		this.nombre = nombre;
  		this.horarioapertura = horarioApertura;
  		this.horariocierre = horarioCierre;
  		this.estado = estado;
  	}
 
  	



	public String getNombre () {
  		return this.nombre ;
  	}
  	public String getHorarioApertura() {
  		return horarioapertura;
  	}
  	public String getHorarioCierre() {
  		return horariocierre;
  	}
  	/*
  	public String getDireccion() {
  		return direccion;
  	}
  	*/
  	public String estadoToString() {
  		if (this.estado.equals(TipoEstadoSucursal.OPERATIVA)) return "Operativa";
  		else return "No Operativa";
  	}
  	public Integer id() {
  		return this.id;
  	}
  	
  	public TipoEstadoSucursal getEstado() {
  		return estado;
  	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setHorarioapertura(String horarioapertura) {
		this.horarioapertura = horarioapertura;
	}


	public void setHorariocierre(String horariocierre) {
		this.horariocierre = horariocierre;
	}


	public void setEstado(TipoEstadoSucursal estado) {
		this.estado = estado;
	}
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sucursal)) return false;
        Sucursal other = (Sucursal) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
  	
  }
