import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class solicitudHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User arg0, ISFSObject arg1) {
		int maxscore=0;
		String user="";

		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/videojuego","root","");//donde bd es el nombre de mi base de datos
			Statement s = con.createStatement(); 
			ResultSet rs = s.executeQuery("SELECT max(score) as maxscore from maxscore");
			rs.next(); 
            //user=rs.getString("username");
			maxscore=rs.getInt("maxscore");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ISFSObject respuesta = SFSObject.newInstance();
		respuesta.putInt("maxscore",maxscore);
		send("otraSolicitud", respuesta, arg0);
		miExtension e=(miExtension)getParentExtension();
		/*List l=e.getParentZone().getRoomByName("TEC").getUserList();
		respuesta.putInt("maxscore",maxscore);
        //respuesta.putUtfString("user", user);
		send("otraSolicitud", respuesta, l);*/
	}
}
