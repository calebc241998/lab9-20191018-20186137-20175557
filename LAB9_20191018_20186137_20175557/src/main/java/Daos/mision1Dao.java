package Daos;
import Beans.BHumanos;
import Beans.BSupervivientes;

import java.sql.*;
import java.util.ArrayList;

public class mision1Dao extends DaosBase {
    public ArrayList<BHumanos> ObtenerListaHumanos(){
        ArrayList<BHumanos> obtenerlistahumanos = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', CONCAT(h.nombre,' ',h.apellido) AS 'Nombre completo', h.sexo AS 'Sexo', \n" +
                    "CASE WHEN h.estado <> 0 THEN 'Humano' ELSE 'Zombie' END AS 'Estado' \n" +
                    "FROM humanos h;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String idhumano = rs.getString(1);
                String nombre = rs.getString(2);
                String sexo = rs.getString(3);
                String estado = rs.getString(4);

                System.out.println("probando");

                obtenerlistahumanos.add(new BHumanos(idhumano,nombre,sexo,estado));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return obtenerlistahumanos;
    }
}
