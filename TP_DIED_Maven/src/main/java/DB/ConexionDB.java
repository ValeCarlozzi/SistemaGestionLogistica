package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import TP.Camino;
import TP.OrdenDeProvision;
import TP.Producto;
import TP.Stock;
import TP.Sucursal;
import TP.TipoEstadoSucursal;
import UI.VentanaConfirmacion;


public class ConexionDB {
	// DATOS DE LA BASE DE DATOS A LA QUE NOS CONECTAMOS
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USR = "postgres";
	private static final String PAS = "test123";
	private static final String DRIVER = "org.postgresql.Driver";

	// SENTENCIAS EN POSGRESQL
	// SUCURSAL
	private static final String insert_sucursal = "INSERT INTO sucursal (ID, nombre, estado, apertura, cierre) VALUES (?,?,?,?,?)";
	private static final String update_sucursal = "UPDATE sucursal SET nombre = ?,estado = ?,apertura = ?,cierre = ? WHERE id = ?";
	private static final String delete_sucursal = "DELETE FROM sucursal WHERE id=?";
	private static final String search_sucursal = "SELECT * FROM public.sucursal ("
			+ "id,nombre,hapertura,hcierre,estado,direccion)" + "WHERE id= ?";
	private static final String ver_sucursales = "SELECT * FROM sucursal";
	private static final String stock_sucursal = "SELECT * FROM stock WHERE idsucursal = ?";
	
	// PRODUCTO
	private static final String insert_producto = "INSERT INTO producto (nombre, descripcion, precio, peso) VALUES (?,?,?,?)";
	private static final String update_producto = "UPDATE producto SET descripcion = ?,precio = ?,peso = ? WHERE nombre = ?";
	private static final String delete_producto = "DELETE FROM producto WHERE nombre=?";
	private static final String search_producto_id = "SELECT * FROM public.producto ("
			+ "id,nombre,descripcion,precio,peso)" + "WHERE id= ?";
	private static final String ver_productos = "SELECT * FROM producto";


	// CAMINO
	private static final String ver_caminos = "SELECT * FROM camino";
	private static final String insert_camino = "INSERT INTO camino (id, origen, destino, capacidad, estado, tiempotransito) VALUES (?,?,?,?,?,?)";
	private static final String update_camino = "UPDATE camino SET origen=?,destino=?,capacidad=?,estado=?,tiempotransito=? WHERE id=?";
	private static final String delete_camino = "DELETE FROM camino WHERE id=?";

	// ORDEN DE PROVISION
	private static final String insert_ordenProvision = "INSERT INTO ordenprovision (fecha,id_sucursal_destino,horas,estado) VALUES (?,?,?,?)";
	private static final String insert_productos_orden = "INSERT INTO productosorden VALUES (?,?,?)";
	private static final String ver_ordenes = "SELECT * FROM ordenprovision WHERE id_sucursal_destino = ?";
	private static final String ver_productos_orden = "SELECT * FROM productosorden WHERE idorden= ?";
	
	// STOCK
	private static final String insert_stock = "INSERT INTO stock VALUES (?,?,?)";
	private static final String update_stock = "UPDATE stock SET stock =? WHERE idsucursal=? AND nombreproducto=?";
	private static final String delete_stock = "DELETE FROM stock WHERE idsucursal=? AND nombreproducto=?";
	private static final String ver_stock = "SELECT * FROM stock";


	// LISTA DE PRODUCTOS
	private static final String insert_lista = "INSERT INTO public.lista (" + "id_orden,id_producto,cantidad)"
			+ "VALUES (?,?,?)";

	/*
	 * Integer id,Integer origen,Integer destino,Integer capMaxima,
	 * TipoEstadoSucursal estado, String tiempo)
	 */

	/*
	 * private static final String update_producto = "UPDATE public.producto (" +
	 * "id,nombre,descripcion,precio,peso)" +
	 * "SET nombre=?,descripcion=?,precio=?,peso=?" + "WHERE id=?"; private static
	 * final String delete_producto = "DELETE FROM public.producto (" +
	 * "id,nombre,descripcion,precio,peso)" + "WHERE id=?"; private static final
	 * String search_producto_id = "SELECT * FROM public.producto ("+
	 * "id,nombre,descripcion,precio,peso)" +"WHERE id= ?";
	 */

	public void crearSucursal(Sucursal s) throws SQLException{

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USR, PAS);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement pstm;

		try {
			pstm = conn.prepareStatement(insert_sucursal);
			pstm.setInt(1, s.id());
			pstm.setString(2, s.getNombre());

			Boolean est;
			if (s.estadoToString() == "Operativa") {
				est = true;
			} else {
				est = false;
			}
			pstm.setBoolean(3, est);
			pstm.setString(4, s.getHorarioApertura());
			pstm.setString(5, s.getHorarioCierre());
			int cantidad = pstm.executeUpdate();
			if (cantidad > 0) {
				new VentanaConfirmacion("Alta confirmada","Alta");
			}

			if (pstm != null) {
				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e;	
			}
			e.printStackTrace();
			throw e;
		}

	}

	public void modificarSucursal(Sucursal s) throws SQLException,ClassNotFoundException {
		//"UPDATE sucursal (id,nombre,hapertura,hcierre,estado,direccion) SET nombre = ?,estado = ?,apertura = ?,cierre = ? WHERE id = ?";
		
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(update_sucursal);
			// nombre=?,hapertura=?,hcierre=?,estado=?,direccion=?" + "WHERE id=?
			pstm.setString(1, s.getNombre());
			if (s.estadoToString() == "Operativa") {
				pstm.setBoolean(2, true);
			} else {
				pstm.setBoolean(2, false);
			}
			pstm.setString(3, s.getHorarioApertura());
			pstm.setString(4, s.getHorarioCierre());
			pstm.setInt(5, s.id());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Edicion confirmada","Edicion");
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					throw e;
				}
		}
	}

	public void borrarSucursal(Sucursal s) throws SQLException,ClassNotFoundException  {
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(delete_sucursal);
			// id=?
			pstm.setInt(1, s.id());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Sucursal eliminada","Baja");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public Sucursal buscarSucursalporId(Integer id) {
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(search_sucursal);
			// nombre=?,hapertura=?,hcierre=?,estado=?,direccion=?" + "WHERE id=?
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Sucursal suc = new Sucursal();
				suc.setId(rs.getInt(1));
				suc.setNombre(rs.getString(2));
				suc.setHorarioApertura(rs.getString(3));
				suc.setHorarioCierre(rs.getString(4));
				suc.setEstado(rs.getInt(5));
				suc.setString(rs.getString(6));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return suc;
		}
	}

	public ArrayList<Sucursal> crearListadeSucursales() throws SQLException,ClassNotFoundException{
		
		ArrayList<Sucursal> listaSuc = new ArrayList<>();

	
			try {
				
				Class.forName(DRIVER);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw e;
			}

			try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
					Statement statement = conn.createStatement()) {

				String selectQuery = ver_sucursales;
				boolean hasResultSet = statement.execute(selectQuery);

				if (hasResultSet) {
					ResultSet rs = statement.getResultSet();
					while (rs.next()) {

						Integer id = rs.getInt(1);
						String nombre = rs.getString(2);

						TipoEstadoSucursal estado;
						if (rs.getBoolean(3) == true) {
							estado = TipoEstadoSucursal.OPERATIVA;
						} else {
							estado = TipoEstadoSucursal.NO_OPERATIVA;
						}

						String apertura = rs.getString(4);
						String cierre = rs.getString(5);
						Sucursal suc = new Sucursal(id, nombre, apertura, cierre, estado);
						listaSuc.add(suc);
					}
					rs.close();
				}
				
				try {
					conn.close();
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}


		return listaSuc;
		
		
		
	}

	public void crearProducto(Producto p) throws SQLException{
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USR, PAS);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		PreparedStatement pstm;

		try {
			pstm = conn.prepareStatement(insert_producto);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.descripcion());
			pstm.setDouble(3, p.getPrecioUnitario());
			pstm.setDouble(4, p.getPeso());
			int cantidad = pstm.executeUpdate();
			if (cantidad > 0) {
				new VentanaConfirmacion("Alta confirmada","Alta");

			}

			if (pstm != null) {
				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw e;
			}
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<Producto> crearListadeProductos() throws SQLException,ClassNotFoundException{
		
		ArrayList<Producto> listaProd = new ArrayList<>();

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {;
			e.printStackTrace();
			throw e;
		}

		try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
				Statement statement = conn.createStatement()) {

			String selectQuery = ver_productos;
			boolean hasResultSet = statement.execute(selectQuery);

			if (hasResultSet) {
				ResultSet rs = statement.getResultSet();
				while (rs.next()) {
					Producto prod = new Producto();
					prod.setNombre(rs.getString(1));
					prod.setDescripcion(rs.getString(2));
					prod.setPrecioUnitario(rs.getDouble(3));
					prod.setPeso(rs.getDouble(4));
					listaProd.add(prod);
				}
				rs.close();
			}

			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return listaProd;
		
	}
	
	public void modificarProducto(Producto p) throws SQLException,ClassNotFoundException {
		//UPDATE producto SET descripcion = ?,precio = ?,peso = ? WHERE nombre = ?
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(update_producto);
			// nombre=?,descripcion=?,precio=?,peso=?" + "WHERE id=
			pstm.setString(1, p.descripcion());
			pstm.setDouble(2, p.getPrecioUnitario());
			pstm.setDouble(3, p.getPeso());
			pstm.setString(4, p.getNombre());
			int cantidad = pstm.executeUpdate();
			if(cantidad>0) {
				new VentanaConfirmacion("Edicion confirmada","Edicion");
			}
			
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					throw e;
				}
		}
	}

	public void borrarProducto(Producto p) throws SQLException,ClassNotFoundException {
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(delete_producto);
			// "WHERE id=?";
			pstm.setString(1, p.getNombre());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Producto eliminado","Baja");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public void crearCamino(Camino c) throws SQLException,ClassNotFoundException{

		Connection conx = null;
		PreparedStatement pstm = null;
		try {
// cargar el driver 
			Class.forName(DRIVER);
// obtenemos una coneccion  
			conx = DriverManager.getConnection(URL, USR, PAS);
// preparamos el comando sql 
			pstm = conx.prepareStatement(insert_camino);
// id,nombre,descripcion,precio,peso
			pstm.setInt(1, c.getID());
			pstm.setInt(2, c.getOrigen());
			pstm.setInt(3, c.getDestino());
			pstm.setInt(4, c.getCapMaxima());
			if(c.estadoToString() == "Operativo") {
				pstm.setBoolean(5, true);
			}
			else {
				pstm.setBoolean(5, false);
			}
			pstm.setInt(6, c.getTiempoTransito());
			int cantidad = pstm.executeUpdate();
			if (cantidad > 0) {
			 	   new VentanaConfirmacion("Alta confirmada","Alta");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public void modificarCamino(Camino c) throws SQLException,ClassNotFoundException {
		//"UPDATE camino SET origen=?,destino=?,capacidad=?,estado=?,tiempotransito=? WHERE id=?";
		
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);
			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);
			// preparamos el comando sql
			pstm = conx.prepareStatement(update_camino);
			// nombre=?,hapertura=?,hcierre=?,estado=?,direccion=?" + "WHERE id=?
			pstm.setInt(1, c.getOrigen());
			pstm.setInt(2, c.getDestino());
			pstm.setInt(3, c.getCapMaxima());
			if (c.estadoToString() == "Operativo") {
				pstm.setBoolean(4, true);
			} else {
				pstm.setBoolean(4, false);
			}
			pstm.setInt(5, c.getTiempoTransito());
			pstm.setInt(6, c.getID());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Edicion confirmada","Edicion");
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					throw e;
				}
		}
	}

	public void borrarCamino(Camino c) throws SQLException,ClassNotFoundException {

		Connection conx = null;
		PreparedStatement pstm = null;
		try {
// cargar el driver 
			Class.forName(DRIVER);
// obtenemos una coneccion  
			conx = DriverManager.getConnection(URL, USR, PAS);
// preparamos el comando sql 
			pstm = conx.prepareStatement(delete_camino);
// id,origen,destino,capMaxima,estado,tiempo) where id=?

			pstm.setInt(1, c.getID());
// ejecutamos la sentencia 
			int cantidad = pstm.executeUpdate();
			if(cantidad>0) {
				new VentanaConfirmacion("Camino eliminado","Baja");
			}
		} // capturamos las ecepciones , si las hay
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public ArrayList<Camino> crearListadeCaminos() throws SQLException,ClassNotFoundException {
		
		ArrayList<Camino> listaCam = new ArrayList<>();

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
				Statement statement = conn.createStatement()) {

			String selectQuery = ver_caminos;
			boolean hasResultSet = statement.execute(selectQuery);

			if (hasResultSet) {
				ResultSet rs = statement.getResultSet();
				while (rs.next()) {
					Camino cam = new Camino();
					cam.setId(rs.getInt(1));
					cam.setOrigen(rs.getInt(2));
					cam.setDestino(rs.getInt(3));
					cam.setCapMaxima(rs.getInt(4));

					if (rs.getBoolean(5) == true) {
						cam.setEstado(TipoEstadoSucursal.OPERATIVA);
					} else {
						cam.setEstado(TipoEstadoSucursal.NO_OPERATIVA);
					}
					cam.setTiempodeTransito(rs.getInt(6));
					listaCam.add(cam);
				}
				rs.close();
			}

			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return listaCam;
		
	}

	public void crearStock(Stock s) throws SQLException,ClassNotFoundException {
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
// cargar el driver 
			Class.forName(DRIVER);
// obtenemos una coneccion  
			conx = DriverManager.getConnection(URL, USR, PAS);
// preparamos el comando sql 
			pstm = conx.prepareStatement(insert_stock);
// id_sucursal,id_producto,stock
			pstm.setInt(1, s.getIdSucursal());
			pstm.setString(2, s.getNombre());
			pstm.setInt(3, s.getStockProducto());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Alta confirmada","Alta");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public void modificarStock(Stock s) throws SQLException,ClassNotFoundException{
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
// cargar el driver 
			Class.forName(DRIVER);
// obtenemos una coneccion  
			conx = DriverManager.getConnection(URL, USR, PAS);
// preparamos el comando sql 
			pstm = conx.prepareStatement(update_stock);
// SET  id_producto =?, stock =?" + "WHERE id=?
			pstm.setInt(1, s.getStockProducto());
			pstm.setInt(2, s.getIdSucursal());
			pstm.setString(3, s.getNombre());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Edicion confirmada","Edicion");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public void borrarStock(Stock s) throws SQLException,ClassNotFoundException{
		Connection conx = null;
		PreparedStatement pstm = null;
		try {
// cargar el driver 
			Class.forName(DRIVER);
// obtenemos una coneccion  
			conx = DriverManager.getConnection(URL, USR, PAS);
// preparamos el comando sql 
			pstm = conx.prepareStatement(delete_stock);
//  id_sucursal=? id_producto=?
			pstm.setInt(1, s.getIdSucursal());
			pstm.setString(2, s.getNombre());
			int cantidad = pstm.executeUpdate();
			if(cantidad > 0) {
				new VentanaConfirmacion("Camino eliminado","Baja");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
		}
	}

	public ArrayList<Stock> crearListaStock() throws SQLException,ClassNotFoundException{
		
		ArrayList<Stock> listaStock = new ArrayList<>();

		
		try {
			
			Class.forName(DRIVER);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
				Statement statement = conn.createStatement()) {

			String selectQuery = ver_stock;
			boolean hasResultSet = statement.execute(selectQuery);

			if (hasResultSet) {
				ResultSet rs = statement.getResultSet();
				while (rs.next()) {

					
					Integer id = rs.getInt(1);
					String nombr = rs.getString(2);
					Integer cant = rs.getInt(3);
					
					Stock sto = new Stock(id, nombr, cant);
					listaStock.add(sto);
				}
				rs.close();
			}
			
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}


	return listaStock;
		
	}
	
public ArrayList<Stock> crearListaStockSucursal(Sucursal s) throws SQLException,ClassNotFoundException{
		
		ArrayList<Stock> listaStock = new ArrayList<>();

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
				PreparedStatement statement = conn.prepareStatement(stock_sucursal)) {
			
			statement.setInt(1, s.id());
			ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					Stock stock = new Stock(s.id(),rs.getString(2),rs.getInt(3));

					listaStock.add(stock);
				}

			try {
				statement.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return listaStock;
		
	}
	
	public void crearOrdenProvision(OrdenDeProvision op) throws SQLException,ClassNotFoundException {
		Connection conx = null;
		PreparedStatement pstm = null;
		Integer idGenerado = null;
		try {
			// cargar el driver
			Class.forName(DRIVER);

			// obtenemos una coneccion
			conx = DriverManager.getConnection(URL, USR, PAS);

			// preparamos el comando sql
			pstm = conx.prepareStatement(insert_ordenProvision, Statement.RETURN_GENERATED_KEYS);

			// fechaOrden,idSucursalDestino,horasMaximo,estado
			pstm.setDate(1, op.getFechaOrden());
			pstm.setInt(2, op.getSucursalDestino());
			pstm.setInt(3, op.getHorasMaximo());
			pstm.setString(4, op.getEstadoString());
			int cantidad = pstm.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				ResultSet generatedKeys = pstm.getGeneratedKeys();
				pstm = conx.prepareStatement(insert_productos_orden);
				if (generatedKeys.next()) {
					idGenerado = generatedKeys.getInt(1);
					
						for(String nombre : op.getListaProductos().keySet()) {
							pstm.setInt(1, idGenerado);
							pstm.setString(2, nombre);
							pstm.setInt(3, op.getListaProductos().get(nombre));
							int cantidad = pstm.executeUpdate();
						}
				}
				
				new VentanaConfirmacion("Nueva orden confirmada","Orden");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
			if (pstm != null)
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			if (conx != null)
				try {
					conx.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			/*
			op.setId(idGenerado);
			crearLista(op);
			*/
		}

	}
	
	public ArrayList<OrdenDeProvision> crearListaOrdenes(Integer idsucursal) throws SQLException,ClassNotFoundException {
	
		ArrayList<OrdenDeProvision> listaOrden = new ArrayList<OrdenDeProvision>();

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		try (Connection conn = DriverManager.getConnection(URL, USR, PAS);
			PreparedStatement statement = conn.prepareStatement(ver_ordenes)) {
			
			statement.setInt(1, idsucursal);
			ResultSet rs = statement.executeQuery();

			PreparedStatement stmnt = conn.prepareStatement(ver_productos_orden);
			ResultSet res;
			HashMap<String,Integer> listaProducto;
			
				while (rs.next()) {
					
					OrdenDeProvision orden = new OrdenDeProvision(rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
					
					listaProducto = new HashMap<String, Integer>();
					
					stmnt.setInt(1, rs.getInt(1));
					res = stmnt.executeQuery();
					
					while (res.next()) {
						
						listaProducto.put(res.getString(2), res.getInt(3));
						
					}
						
					orden.setListaProductos(listaProducto);
				
					listaOrden.add(orden);
					
					try {
						res.close();
					} catch (SQLException e) {
						throw e;
					}
					
				}

			try {
				statement.close();
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return listaOrden;
		
		
	}
}
