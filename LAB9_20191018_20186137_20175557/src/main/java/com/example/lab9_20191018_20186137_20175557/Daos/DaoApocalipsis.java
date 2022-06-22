package com.example.lab9_20191018_20186137_20175557.Daos;
import com.example.lab9_20191018_20186137_20175557.Beans.BHumanos;
import java.sql.*;
import java.util.ArrayList;
public class DaoApocalipsis {
    public ArrayList<BHumanos> Mision1(){
        ArrayList<BHumanos> mision1 = new ArrayList<>();
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mysystem4?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', h.nombre as 'Nombre',h.apellido AS 'Apellido', h.sexo AS 'Sexo', \n" +
                    "CASE WHEN h.estado <> 0 THEN 'Humano' ELSE 'Zombie' END AS 'Estado' \n" +
                    "FROM humanos h;";
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                BHumanos hu = new BHumanos();
                hu.setIdHumanos(rs.getString(1));
                hu.setNombre(rs.getString(2));
                hu.setApellido(rs.getString(3));
                hu.setSexo(rs.getString(4));
                hu.setEstado(rs.getInt(5));

                System.out.println("probando");

                mision1.add(hu);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return mision1;
    }
    public ArrayList<BHumanos> Mision2(){
        ArrayList<BHumanos> mision2 = new ArrayList<>();
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mysystem4?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql = "SELECT h.idHumanos AS 'Número de identificación', h.nombre as 'nombre',h.apellido AS 'apellido', h.sexo AS 'Sexo',\n" +
                    "s.peso AS 'Peso (Kg)', s.fuerza AS 'Fuerza (N)', \n" +
                    "CASE WHEN (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) IS NULL THEN 'Soltero(a)'\n" +
                    "ELSE (SELECT CONCAT(h.nombre,' ',h.apellido) FROM humanos h WHERE h.idHumanos = s.idPareja) END AS 'Pareja',\n" +
                    "(SELECT ROUND(SUM(o.peso*m.stock),2) FROM objetos o, mochila m WHERE o.idObjetos = m.idObjetos AND m.idHumanos = s.idHumanos GROUP BY m.idHumanos) AS 'Peso cargado (Kg)'\n" +
                    "FROM supervivientes s, humanos h, mochila m\n" +
                    "WHERE s.idHumanos = h.idHumanos AND m.idHumanos = s.idHumanos\n" +
                    "GROUP BY h.idHumanos;";
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                BHumanos hu2 = new BHumanos();
                hu2.setIdHumanos(rs.getString(1));
                hu2.setNombre(rs.getString(2));
                hu2.setApellido(rs.getString(3));
                hu2.setPeso(rs.getString(4));
                hu2.setFuerza(rs.getInt(5));

                System.out.println("probando");

                mision2.add(hu2);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return mision2;
    }
}
