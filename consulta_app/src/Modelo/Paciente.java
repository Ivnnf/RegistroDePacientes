
package Modelo;


public class Paciente {
    
    
    private String rut,nombre,genero,direccion,ciudad,isapre;
    private int edad;
    private boolean donante;

    public Paciente(String rut, String nombre, String genero, String direccion, String ciudad, String isapre, int edad, boolean donante) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.isapre = isapre;
        this.edad = edad;
        this.donante = donante;
    }

    public Paciente() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getIsapre() {
        return isapre;
    }

    public void setIsapre(String isapre) {
        this.isapre = isapre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isDonante() {
        return donante;
    }

    public void setDonante(boolean donante) {
        this.donante = donante;
    }

   

    
    
}