package TP;
//importo el paquete de excepciones entero

//metodos para setear stock van en sucursal
//metodo check stock tbn en sucursal? (stock.length = productos.length)
public class Stock {

	Integer idSucursal;
	String nombre;
	Integer stockProducto;
	
	//para alta
	//ver que exception se lanza
	public Stock(Integer id, String pr, Integer stock) {
		
		this.idSucursal = id;
		this.nombre = pr;
		this.stockProducto = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	

}
