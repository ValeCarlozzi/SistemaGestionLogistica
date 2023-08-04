package TP;

public class Sucursal {
  	private Integer id;
  	private String nombre;
  	private String horarioapertura;
  	private String horariocierre;
  	private TipoEstadoSucursal estado;
  	private String direccion;

  	public Sucursal() {};

  	public Sucursal(Integer id , String nombre ,String horarioA,
  				   String horarioC, TipoEstadoSucursal estado,
  				   String direccion) {
  		this();
  		this.id = id;
  		this.nombre = nombre;
  		this.horarioapertura = horarioA;
  		this.horariocierre = horarioC;
  		this.estado = estado;
  		this.direccion = direccion;
  	}
  	public void modificarSucursal (Integer id , String nombre ,String horarioApertura,
  			   String horarioCierre, TipoEstadoSucursal estado,
  			   String direccion) {
  		this.id = id;
  		this.nombre = nombre;
  		this.horarioapertura = horarioApertura;
  		this.horariocierre = horarioCierre;
  		this.estado = estado;
  		this.direccion = direccion;
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
  	public String getDireccion() {
  		return direccion;
  	}
  	public String estadoToString() {
  		if (this.estado.equals(TipoEstadoSucursal.OPERATIVA)) return "Operativa";
  		else return "No Operativa";
  	}
  	public Integer id() {
  		return this.id;
  	}
  }
