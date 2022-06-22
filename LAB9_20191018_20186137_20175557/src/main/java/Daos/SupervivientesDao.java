package Daos;
import Beans.BSupervivientes;

import java.sql.*;
import java.util.ArrayList;
public class SupervivientesDao extends DaosBase {

    public ArrayList<BSupervivientes> ObtenerListaSupervivientes(){
        ArrayList<BSupervivientes> obtenerlistasupervivientes = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', CONCAT(h.nombre,' ',h.apellido) AS 'Nombre completo', h.sexo AS 'Sexo',\n" +
                    "s.peso AS 'Peso (Kg)', s.fuerza AS 'Fuerza (N)', \n" +
                    "CASE WHEN (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) IS NULL THEN \"Soltero(a)\"\n" +
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
}
