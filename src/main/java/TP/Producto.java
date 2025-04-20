package TP;

public class Producto {
	private String nombre;
	private String descripcion;
	private Double precioUnitario;
	private Double peso;

	public Producto() {};
	public Producto(String nombre,String descripcion,Double precio,Double peso) {
		this();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precio;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public String descripcion() {
		return descripcion;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public Double getPeso() {
		return peso;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
