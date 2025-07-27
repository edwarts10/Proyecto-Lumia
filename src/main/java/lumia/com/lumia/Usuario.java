/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lumia.com.lumia;

/**
 *
 * @author edwar
 */
//para usar como parametro,devolver usuarios y manipular datos de forma ordenada
public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String tipo;
    
    public Usuario (){
}

public Usuario (int id,String nombre, String correo, String contraseña, String tipo){
   // contrucion con todos los campos
    this.id=id;
    this.nombre=nombre;
    this.correo=correo;
    this.contraseña=contraseña;
    this.tipo=tipo;
}
//sin el id
public Usuario (String nombre, String correo,String contraseña, String tipo){
    this.nombre=nombre;
            this.correo=correo;
            this.contraseña=contraseña;
            this.tipo= tipo;
            
            
} 
// obtencion y establecimiento de datos
 public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para imprimir datos del usuario (opcional)
    @Override
    public String toString() {
        return id + " | " + nombre + " | " + correo + " | " + tipo;
    }
}
