package Daos;

import Beans.BHumanos;
import Beans.BSupervivientes;
import Beans.BVariante;
import Beans.BZombies;

import java.sql.*;
import java.util.ArrayList;
public class ZombiesDao extends DaosBase{
    public ArrayList<BZombies> ObtenerZombies(){
        ArrayList<BZombies> obtenerlistasZombies = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', CONCAT(h.nombre,' ',h.apellido) AS 'Nombre completo', h.sexo AS 'Sexo',\n" +
                    "TIMESTAMPDIFF(HOUR,z.fechaInfeccion,NOW()) AS 'Tiempo infectado (Horas)',\n" +
                    "va.nombre AS 'Variante de virus', z.victimas AS 'Número de víctimas', t.nombre AS 'Tipo de zombie'\n" +
                    "FROM zombies z, humanos h, variante va, tipo t\n" +
                    "WHERE z.idHumanos = h.idHumanos AND z.idVariante = va.idVariante AND z.idTipo = t.idTipo;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String idhumano = rs.getString(1);
                String nombre = rs.getString(2);
                String sexo = rs.getString(3);
                String tiempo_infeccion = rs.getString(4);
                int idVariante = rs.getInt(5);
                int victimas = rs.getInt(6);
                String nombre_tipo = rs.getString(7);
                obtenerlistasZombies.add(new BZombies(idhumano,nombre,sexo,tiempo_infeccion,idVariante,victimas,nombre_tipo));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return obtenerlistasZombies;
    }
    public BHumanos obtenerID(BHumanos id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT h.idHumanos AS 'ID' FROM humanos h;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            pstmt.setString(1, id.getIdHumanos());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    id.setIdHumanos(rs.getString(1));
                    System.out.println(rs.getString(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return id;
    }
    public void ingresarNuevoZombie(String idhumanos,String nombre, String apellido, String sexo, int estado, String fecha_inf, int id_Variante, int idTipo, int victimas) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "INSERT INTO Humanos (idHumanos,nombre,apellido,sexo,estado)\n" +
                    "VALUES (?,?,?,?,1);\n" +
                    "INSERT INTO Zombies (idHumanos,fechaInfeccion,idVariante,idTipo,victimas)\n" +
                    "VALUES (?,?,?,?,0);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idhumanos);
                pstmt.setString(2, nombre);
                pstmt.setString(3, apellido);
                pstmt.setString(4, sexo);
                pstmt.setString(5, idhumanos);
                pstmt.setInt(6, estado);
                pstmt.setString(7, fecha_inf);
                pstmt.setInt(8, id_Variante);
                pstmt.setInt(9, idTipo);
                pstmt.setInt(10, victimas);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public BVariante obtenerVarianteMasComun(BVariante variante_comun) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT h.idHumanos AS 'ID' FROM humanos h;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            pstmt.setString(1, variante_comun.getNombreVariante());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    variante_comun.setNombreVariante(rs.getString(1));
                    System.out.println(rs.getString(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return variante_comun;
    }
}
