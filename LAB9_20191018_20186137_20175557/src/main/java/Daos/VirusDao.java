package Daos;
import Beans.BSupervivientes;
import Beans.BVirus;
import Beans.BVariante;

import java.sql.*;
import java.util.ArrayList;
public class VirusDao extends DaosBase{
    public ArrayList<BVirus> ObtenerlistaVirus(){
        ArrayList<BVirus> obtenerlistavirus = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT vi.idVirus AS 'ID Virus', vi.nombre AS 'Virus', va.idVariante AS 'ID Variante', va.nombre AS 'Variante',\n" +
                    "(SELECT COUNT(idHumanos) FROM Zombies z WHERE z.idVariante = va.idVariante) AS 'Casos encontrados'\n" +
                    "FROM virus vi, variante va \n" +
                    "WHERE va.idVirus = vi.idVirus;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int idVirus = rs.getInt(1);
                String nombreVirus = rs.getString(2);
                int idVariante = rs.getInt(3);
                String nombre_var = rs.getString(4);
                obtenerlistavirus.add(new BVirus(idVirus,nombreVirus,idVariante,nombre_var));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return obtenerlistavirus;
    }
    //AYUDAAAA
    /*

    public BVirus obtenerNumDeVirus(BVirus cantidad) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT COUNT(vi.idVirus) AS 'Virus activos' FROM virus vi;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    cantidad.setPeso(rs.getFloat(1));
                    System.out.println(rs.getFloat(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return cantidad;
    }
    */
    public BVirus obtenerNombreVirus(BVirus nombre) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT vi.nombre AS 'Virus' FROM virus vi;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            pstmt.setString(1, nombre.getNombreVirus());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    nombre.setNombreVirus(rs.getString(1));
                    System.out.println(rs.getString(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return nombre;
    }
    public void ingresarNuevoVirus(String nombreVariante,int idVirus) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "INSERT INTO Variante (nombre,idVirus) VALUES (?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombreVariante);
                pstmt.setInt(2, idVirus);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //ELIMINAR VARIANTE
    public void eliminarVariante(String idVariante) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM zombies z WHERE z.idVariante = ?;\n" +
                     "DELETE FROM variante va WHERE va.idVariante = ?;");) {

            pstmt.setString(1, idVariante);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void eliminarVirus(String idVirus) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM zombies z WHERE z.idVariante = ?;");) {

            pstmt.setString(1, idVirus);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //OBTENER CANTIDAD DE VARIANTES - AYUDAA
}
