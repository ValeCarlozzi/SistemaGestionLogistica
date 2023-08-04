package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String args[]) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "test123";
		
		Connection conn = null;
		try {
		conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {	
		e.printStackTrace();
		}
		
		
		PreparedStatement pstm = conn.prepareStatement("INSERT INTO sucursal (ID, nombre, estado, apertura, cierre, direccion) VALUES (?,?,?,?,?,?)");
				pstm.setInt(1, 2);
				pstm.setString(2,"nombreTest");
				pstm.setBoolean(3, true);
				pstm.setString(4,"6am");
				pstm.setString(5,"8pm");
				pstm.setString(6,"direccion");
				int cantidad = pstm.executeUpdate();
		System.out.println(cantidad);
		
	}
	
}
