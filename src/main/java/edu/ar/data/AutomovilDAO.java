package edu.ar.data;

import static edu.ar.data.Conexion.getConexion;
import static edu.ar.data.Conexion.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import edu.ar.model.Auto;

public class AutomovilDAO {
    public static final String SQL_SELECT = "SELECT A.id, M.id, M.nombre, MO.id, MO.modelo, A.version, A.anio, C.id, C.color, A.chasis, A.motor FROM autos AS A, marcas AS M, modelos AS MO, colores AS C WHERE (M.id = A.idMarca) AND (MO.idMarca = A.idMarca AND MO.id = A.idModelo) AND (C.id = A.idColor) ORDER BY A.id ASC";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM autos WHERE id = ?";
    public static final String SQL_INSERT = "INSERT INTO autos (idMarca, idModelo, version, anio, chasis, motor, idColor) VALUES(?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE autos SET idMarca = ?, idModelo = ?, version = ?, anio = ?, chasis = ?, motor = ?, idColor = ? WHERE id = ?";
    public static final String SQL_DELETE = "DELETE FROM autos WHERE id = ?";

    public static List<Auto> obtener() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Auto auto = null;
        List<Auto> autos = new ArrayList<>();

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            // Itero los autos devueltos por la base de datos en el ResultSet
            // Obteniendo los atributos de cada auto y seteándolos a los objs Autos
            // finalmente guardo cada auto en el listado de autos(ArrayList)
            while(rs.next()) {
                int id = rs.getInt("A.id");
                int idMarca = rs.getInt("M.id");
                String marca = rs.getString("M.nombre");
                int idModelo = rs.getInt("MO.id");
                String modelo =  rs.getString("MO.modelo");
                String version = rs.getString("A.version");
                int anio = rs.getInt("A.anio");
                String chasis = rs.getString("A.chasis");
                String motor = rs.getString("A.motor");
                int idColor = rs.getInt("C.id");
                String color =  rs.getString("C.color");

                auto = new Auto(id, idMarca, marca, idModelo, modelo, version, anio, chasis, motor, idColor, color);
                
                autos.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try{
                close(rs);
                close(ps);
                close(conn);
            } catch(Exception e) {
                e.printStackTrace(System.out);
            }
        }
        
        return autos;
    }

    public static void insertar(Auto autoAgregar) {
        System.out.println("en insertar");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConexion();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, autoAgregar.getIdMarca());
            ps.setInt(2, autoAgregar.getIdModelo());
            ps.setString(3, autoAgregar.getVersion());
            ps.setInt(4, autoAgregar.getAnio());
            ps.setString(5, autoAgregar.getChasis());
            ps.setString(6, autoAgregar.getMotor());
            ps.setInt(7, autoAgregar.getIdColor());
            
            System.out.println("setee ps");

            int retorno = ps.executeUpdate();

            System.out.println("Ejecuté insert");

            if (retorno > 0)
                System.out.println("Dado de alta correctamente !");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally{
            try{
                close(ps);
                close(conn);
            } catch(Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("salgo insert");
        
        return;

    }
}