import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class miHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User arg0, ISFSObject arg1) {
		int maxF = arg1.getInt("maxscoreF");

		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/videojuego","root","");//donde bd es el nombre de mi base de datos
			Statement s = con.createStatement(); 
			s.executeUpdate("INSERT INTO maxscore (score) VALUES ('"+maxF+"')");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("vpy a morir: ");

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Exception caught: ");
            System.out.println(e.getMessage());
		}
		ISFSObject respuesta = SFSObject.newInstance();
		respuesta.putInt("respuesta",1);
		send("otraSolicitud", respuesta, arg0);


	}
}