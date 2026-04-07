/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author LUZ ELENA
 */
public class Cliente {
    
    private String nombre; 
    private String documento;
    private int telefono;
    private String direccion;
    private boolean libroPrestado;
    private ArrayList<Libro> historialPrestamos = new ArrayList<>();

    public Cliente(String nombre, String documento, int telefono, String direccion, boolean libroPrestado) {
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.libroPrestado = libroPrestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String  getDocumento() {
	return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public void agregarAlHistorial(Libro libro) {
	historialPrestamos.add(libro);
    }

    public void mostrarHistorial() {
	if(historialPrestamos.isEmpty()) {
	    System.out.println("Este cliente no tiene historial de prestamos.");
	    return;
	}

	System.out.println("Historial de prestamos:");
	for(int i = 0; i < historialPrestamos.size(); i++) {
	    System.out.println(historialPrestamos.get(i).getTitulo());
	}
    }
}
