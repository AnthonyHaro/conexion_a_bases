import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class conexionBDD{
    String servidor;
    String usuario;
    String password;
    String mensaje;
    public conexionBDD(String servidor, String usuario, String password) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.password = password;
    }
    public conexionBDD(){

    }
    public void conexionLocal(String servidor, String usuario, String password){
        try (Connection connection = DriverManager.getConnection(servidor, usuario, password)){
        if (connection!=null) {
            System.out.println("Conexion Correcta");
        }}catch(SQLException ex){
            System.out.println(ex.getMessage());
        }


    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
