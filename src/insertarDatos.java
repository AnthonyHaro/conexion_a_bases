import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertarDatos {
    String nombre;
    String cadula;
    int calif1;
    int calif2;
    public insertarDatos(String nombre, String cadula, int calif1, int calif2) {
        this.nombre = nombre;
        this.cadula = cadula;
        this.calif1 = calif1;
        this.calif2 = calif2;
    }

    public insertarDatos() {
    }
    public void ingresoDatos(String nombre,String cedula,int calif1,int calif2){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/estudiante","root","")) {
            String sql="INSERT INTO calificaciones(nombre,cedula,calificacion1,calificacion2)values(?,?,?,?)";
            try(PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
                preparedStatement.setString(1,nombre);
                preparedStatement.setString(2,cedula);
                preparedStatement.setInt(3,calif1);
                preparedStatement.setInt(4,calif2);
                int filasAfectadas= preparedStatement.executeUpdate();
                if(filasAfectadas>0){
                    System.out.println("inserccion existosa");
                }else{
                    System.out.println("inserccion fallida");
                }
            }
        }catch (Exception ex){

        }
    }
}
