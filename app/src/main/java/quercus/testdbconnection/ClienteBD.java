package quercus.testdbconnection;

import android.os.StrictMode;
import android.util.Log;

import java.sql.*;

/**
 * Created by victor on 23/12/16.
 */

public class ClienteBD {
    private Connection connection = null;
    private Statement stmt=null;
    private final String TAG="db";

    public boolean conectar() {
        try {
            /*Necesario para acceder a Interner*/
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            // Creación de la conexión a la BD
            Class.forName("org.mariadb.jdbc.Driver");
            //String serverName = "10.0.2.2"; // Direccion IP for AVD
            String serverNamePublic="192.168.1.36";
            String portNumber = "3306";  // Puerto
            String dbName = "victor"; // Identificador del servicio o instancia
            String url = "jdbc:mariadb://" + serverNamePublic + ":" + portNumber +
                    "/" + dbName;
            String username = "victorAndroid"; // usuario de la BD
            String password = "12345678"; // contraseña
            connection = DriverManager.getConnection(url, username, password);
            //Log.d(TAG, "Conexion realizada. " + connection);

            //Execute a query
            Log.d(TAG, "Creating statement...");
            stmt = connection.createStatement();
            String sql;
            sql = "SELECT id FROM prueba;";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                //Display values
                Log.d(TAG, "ID: " + id);
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            connection.close();
            return true;
        } catch(ClassNotFoundException c){
            Log.d(TAG, "ClassNotFound:"+c.getMessage());
            return false;
        }
        catch (SQLException e) {
            // Error. No se ha podido conectar a la BD
            Log.d(TAG, "error en la conexion: " + e.toString());
            return false;
        }
    }
}
