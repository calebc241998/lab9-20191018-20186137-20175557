package Daos;
import Beans.BHumanos;
import Beans.BMochila;
import Beans.BObjetos;
import Beans.BSupervivientes;

import java.sql.*;
import java.util.ArrayList;
public class SupervivientesDao extends DaosBase {

    public BHumanos obtenerId(BHumanos idhumano) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT h.idHumanos AS 'ID' FROM humanos h;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            pstmt.setString(1, idhumano.getIdHumanos());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    idhumano.setIdHumanos(rs.getString(1));
                    System.out.println(rs.getString(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return idhumano;
    }
    public ArrayList<BSupervivientes> ObtenerListaSupervivientes(){
        ArrayList<BSupervivientes> obtenerlistasupervivientes = new ArrayList<>();

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', CONCAT(h.nombre,' ',h.apellido) AS 'Nombre completo', h.sexo AS 'Sexo',\n" +
                    "s.peso AS 'Peso (Kg)', s.fuerza AS 'Fuerza (N)', \n" +
                    "CASE WHEN (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) IS NULL THEN 'Soltero(a)'\n" +
                    "ELSE (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) END AS 'Pareja',\n" +
                    "(SELECT ROUND(SUM(o.peso*m.stock),2) FROM objetos o, mochila m WHERE o.idObjetos = m.idObjetos AND m.idHumanos = s.idHumanos GROUP BY m.idHumanos) AS 'Peso cargado (Kg)'\n" +
                    "FROM supervivientes s, humanos h, mochila m\n" +
                    "WHERE s.idHumanos = h.idHumanos AND m.idHumanos = s.idHumanos\n" +
                    "GROUP BY h.idHumanos;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String idhumano = rs.getString(1);
                String nombre = rs.getString(2);
                String sexo = rs.getString(3);
                Float peso = rs.getFloat(4);
                Float fuerza = rs.getFloat(5);
                String pareja = rs.getString(6);
                Float carga = rs.getFloat(7);

                obtenerlistasupervivientes.add(new BSupervivientes(idhumano,nombre,sexo,peso,fuerza,pareja,carga));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return obtenerlistasupervivientes;
    }

    public ArrayList<BSupervivientes> FiltrarSupervPorSexo(){
        ArrayList<BSupervivientes> filtrarSupervPorSexo = new ArrayList<>();


        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', CONCAT(h.nombre,' ',h.apellido) AS 'Nombre completo', h.sexo AS 'Sexo',\n" +
                    "s.peso AS 'Peso (Kg)', s.fuerza AS 'Fuerza (N)', \n" +
                    "CASE WHEN (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) IS NULL THEN 'Soltero(a)'\n" +
                    "ELSE (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) END AS 'Pareja',\n" +
                    "(SELECT ROUND(SUM(o.peso*m.stock),2) FROM objetos o, mochila m WHERE o.idObjetos = m.idObjetos AND m.idHumanos = s.idHumanos GROUP BY m.idHumanos) AS 'Peso cargado (Kg)'\n" +
                    "FROM supervivientes s, humanos h, mochila m\n" +
                    "WHERE s.idHumanos = h.idHumanos AND m.idHumanos = s.idHumanos AND h.sexo = ? \n" +
                    "GROUP BY h.idHumanos;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String idhumano = rs.getString(1);
                String nombre = rs.getString(2);
                String sexo = rs.getString(3);
                Float peso = rs.getFloat(4);
                Float fuerza = rs.getFloat(5);
                String pareja = rs.getString(6);
                Float carga = rs.getFloat(7);

                filtrarSupervPorSexo.add(new BSupervivientes(idhumano,nombre,sexo,peso,fuerza,pareja,carga));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return filtrarSupervPorSexo;
    }
    public void añadirSupervivientes(String nombre, String apellido, String sexo, Float peso, Float fuerza, String idPareja) {
        double seed = Math.random();
        long gen = Math.round(Math.pow(10,11)*seed);
        String id = String.valueOf(gen);

        try (Connection conn = this.obtenerConexion();) {
            String sql = "INSERT INTO Humanos (idHumanos,nombre,apellido,sexo,estado)\n" +
                    "VALUES (?,?,?,?,0);\n" +
                    "INSERT INTO Supervivientes (idHumanos,peso,fuerza,idPareja)\n" +
                    "VALUES (?,?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,id);
                pstmt.setString(2,nombre);
                pstmt.setString(3,apellido);
                pstmt.setString(4,sexo);
                pstmt.setString(5,id);
                pstmt.setFloat(6, peso);
                pstmt.setFloat(7, fuerza);
                if(idPareja==null){
                    assert false;
                    pstmt.setNull(8, Integer.parseInt(idPareja));
                }else{
                    pstmt.setString(8, idPareja);
                }

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void añadirPareja(String idHumanos, String idPareja) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Supervivientes SET idPareja = ? WHERE idHumanos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idHumanos);
                pstmt.setString(2, idPareja);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarNombre(String idHumanos, String nombre) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Humanos SET nombre = ? WHERE idHumanos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idHumanos);
                pstmt.setString(2, nombre);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarApellido(String idHumanos, String apellido) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Humanos SET apellido = ? WHERE idHumanos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idHumanos);
                pstmt.setString(2, apellido);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarPeso(String idHumanos, Float peso) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Supervivientes SET peso = ? WHERE idHumanos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idHumanos);
                pstmt.setFloat(2, peso);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static String sql_peso="SELECT ROUND(9.8 * (SELECT ROUND(SUM(o.peso*m.stock),2) FROM objetos o, mochila m WHERE o.idObjetos = m.idObjetos AND m.idHumanos = s.idHumanos GROUP BY m.idHumanos),2) AS 'Peso cargado (N)'\n" +
            "FROM supervivientes s, humanos h, mochila m\n" +
            "WHERE s.idHumanos = h.idHumanos AND m.idHumanos = s.idHumanos AND s.idHumanos = ?\n" +
            "GROUP BY h.idHumanos;";
    public BSupervivientes obtenerPeso(BSupervivientes peso) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_peso);
        ) {
            pstmt.setFloat(1, peso.getPeso());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    peso.setPeso(rs.getFloat(1));
                    System.out.println(rs.getFloat(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return peso;
    }
    public void editarFuerza(String idHumanos, Float fuerza) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Supervivientes SET fuerza = ? WHERE idHumanos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idHumanos);
                pstmt.setFloat(2, fuerza);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //ELIMINAR SUPERVIVIENTE COMPLETO
    public void borrarSuperviviente(String idHumanos) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM supervivientes s WHERE s.idHumanos = ?;");) {

            pstmt.setString(1, idHumanos);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void eliminarMochila(String idHumanos) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM mochila m WHERE m.idHumanos = ?;");) {

            pstmt.setString(1, idHumanos);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void eliminarHumanoSuper(String idHumanos) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM humanos h WHERE h.idHumanos = ?;");) {

            pstmt.setString(1, idHumanos);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void actualizarAPareja(String idPareja) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE Supervivientes SET idPareja = NULL WHERE idPareja = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idPareja);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //OBTENER INVENTARIO DE SUPERVIVIENTE
    public ArrayList<BObjetos> inventarioSuperviviente(){
        ArrayList<BObjetos> inventarioSuper = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT o.nombre AS 'Nombre', m.stock AS 'Cantidad', o.peso AS 'Peso (Kg)',\n" +
                    "CASE WHEN o.vacuna <> 1 THEN 'No es vacuna' ELSE 'Es vacuna' END AS 'Tipo'\n" +
                    "FROM mochila m, objetos o\n" +
                    "WHERE m.idObjetos = o.idObjetos AND m.idHumanos = ?;";
            Connection conn = this.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String nombreObjeto = rs.getString(1);
                int stock = rs.getInt(2);
                Float peso = rs.getFloat(3);

                inventarioSuper.add(new BObjetos(nombreObjeto,stock,peso));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return inventarioSuper;
    }
    //OBTENER FUERZA
    public BSupervivientes obtenerFuerza(BSupervivientes fuerza) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql_fuerza = "SELECT s.fuerza AS 'Fuerza (N)'\n" +
                "FROM supervivientes s\n" +
                "WHERE s.idHumanos = ?;";
        try (Connection conn = this.obtenerConexion();

             PreparedStatement pstmt = conn.prepareStatement(sql_fuerza);
        ) {
            pstmt.setFloat(1, fuerza.getPeso());


            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    fuerza.setPeso(rs.getFloat(1));
                    System.out.println(rs.getFloat(1));
                }
            }


        } catch (SQLException error) {
            error.printStackTrace();
        }

        return fuerza;
    }
    //Añadir objeto al inventario
    public void añadirObjeto(int idObjetos, String idHumano, int stock) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "INSERT INTO Mochila (idObjetos,idHumanos,stock)\n" +
                    "VALUES (?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idObjetos);
                pstmt.setString(2, idHumano);
                pstmt.setInt(3, stock);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cambiarStock(int stock) {

        try (Connection conn = this.obtenerConexion();) {
            String sql = "UPDATE mochila SET stock = ? WHERE idHumanos = ? AND idObjetos = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, stock);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarObjeto(String idHumanos) {
        try (Connection conn = this.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM mochila m WHERE m.idHumanos = ?;");) {

            pstmt.setString(1, idHumanos);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
