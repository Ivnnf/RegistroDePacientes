
package Controlador;

import Modelo.Paciente;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;


public class ControladorPaciente {
    
     public boolean agregar(Paciente paciente)
    {
    
        try {
            
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
            
            String consulta = "INSERT INTO paciente(rut, nombre, genero, edad, direccion, ciudad, isapre, donante) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnt.prepareStatement(consulta);
            ps.setString(1, paciente.getRut());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getGenero());
            ps.setInt(4, paciente.getEdad());
            ps.setString(5, paciente.getDireccion());
            ps.setString(6, paciente.getCiudad());
            ps.setString(7, paciente.getIsapre());
            ps.setBoolean(8, paciente.isDonante());
            
            
            ps.executeUpdate();
            ps.close();
            cnt.close();
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println("Error bd: "+ e.getMessage());
            return false;
        }
    
    }
     
     
     public ArrayList <Paciente> traerPaciente ()
    {
        ArrayList <Paciente> listaPacientes = new ArrayList <>();
        
        
        try {
            
            Conexion con = new Conexion ();
            Connection cnt = con.obtenerConexion();
            
            String consulta = "SELECT rut, nombre, genero, edad, direccion, ciudad, isapre, donante FROM paciente";
            PreparedStatement ps = cnt.prepareStatement(consulta);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Paciente pac = new Paciente ();
                
                pac.setRut(rs.getString("rut"));
                pac.setNombre(rs.getString("nombre"));
                pac.setGenero(rs.getString("genero"));
                pac.setEdad(rs.getInt("edad"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setIsapre(rs.getString("isapre"));
                pac.setDonante(rs.getBoolean("donante"));
                
               
                listaPacientes.add(pac);
            }
            
            
            rs.close();
            ps.close();
            cnt.close();
       
        } catch (SQLException e) {
            
            System.out.println("Error bd: "+e.getMessage());
            
        }
        
        return listaPacientes;
        
    }
     
    public Paciente buscarProductoPorCodigo (String rut) 
   {
       Paciente pac = new Paciente ();

        try {

            Conexion con = new Conexion ();
            Connection cnt = con.obtenerConexion();

            String consulta = "SELECT rut, nombre, genero, edad, direccion, ciudad, isapre, donante FROM paciente WHERE rut =?";
            PreparedStatement ps = cnt.prepareStatement(consulta);
            ps.setString(1, rut);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                pac.setRut(rs.getString("rut"));
                pac.setNombre(rs.getString("nombre"));
                pac.setGenero(rs.getString("genero"));
                pac.setEdad(rs.getInt("edad"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCiudad(rs.getString("ciudad"));
                pac.setIsapre(rs.getString("isapre"));
                pac.setDonante(rs.getBoolean("donante"));

            }
            rs.close();
            ps.close();
            cnt.close();

        } catch (SQLException e) {

            System.out.println("Error bd: "+e.getMessage());

        }
        return pac; 
    }  
    
}
