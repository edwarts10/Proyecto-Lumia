/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lumia.com.lumia;

/**
 *
 * @author edwar
 */
public class Estudiante {
    private String nombre, apellido, correo, telefono, clave;
    public Estudiante(String nombre,String apellido,String correo,String telefono, String clave){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
    }
    //METODO DE ACCESO GETTERS
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getCcorreo(){return correo;}
    public String getTelefono(){return telefono;}
    public String getClave(){return clave;}
}
