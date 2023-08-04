package TP;
import java.sql.Date;
import java.util.HashMap;

public class OrdenDeProvision {

	Integer id;
	Date fechaOrden;
	Integer sucursalDestino;
	Integer horasMaximo;
	HashMap<String,Integer> listaProductos;
	EstadoOrdenDeProvision estado;

	public OrdenDeProvision(Date fecha, Integer destino, Integer horas, String estado) {
		this.fechaOrden = fecha;
		this.sucursalDestino = destino;
		this.horasMaximo = horas;
		this.listaProductos = new HashMap<String,Integer>();
		
		if(estado == "PENDIENTE"){
			this.estado = EstadoOrdenDeProvision.PENDIENTE;
		}else {
			this.estado = EstadoOrdenDeProvision.EN_PROCESO;
		}
		
		
	}
	
	
	public OrdenDeProvision(Date fecha, Integer destino, Integer horas) {
		this.fechaOrden = fecha;
		this.sucursalDestino = destino;
		this.horasMaximo = horas;
		this.listaProductos = new HashMap<String,Integer>();
		this.estado = EstadoOrdenDeProvision.PENDIENTE;
	}
	
	//agregar producto con cantidad
	public void agregarProducto(String nombre_producto, Integer cantidad) {
		
		listaProductos.put(nombre_producto,cantidad);
		
		return;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void establecerEnProceso() {
		this.estado = EstadoOrdenDeProvision.EN_PROCESO;
	}
	
	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Integer getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Integer sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Integer getHorasMaximo() {
		return horasMaximo;
	}

	public void setHorasMaximo(Integer horasMaximo) {
		this.horasMaximo = horasMaximo;
	}

	public HashMap<String, Integer> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(HashMap<String, Integer> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public EstadoOrdenDeProvision getEstado() {
		return estado;
	}

	public String getEstadoString() {
		if(estado == EstadoOrdenDeProvision.PENDIENTE){
			return "PENDIENTE";
		}
		else {
			return "EN PROCESO";
		}
	}
	
	public void setEstado(EstadoOrdenDeProvision estado) {
		this.estado = estado;
	}
	

}
