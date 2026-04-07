/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JORGEP
 */
public class Libro {
    
    public static final String DISPONIBLE = "Disponible";
    public static final String PRESTADO = "Prestado";
    public static final String DADO_BAJA = "Dado de Baja";
    
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private String categoria;
    private String estado;
    private int contadorPrestamos;

    public Libro(int id, String titulo, String autor, String editorial, int anioPublicacion, String categoria, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
        this.estado = estado;
	this.contadorPrestamos = 0;
    }
    
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    public String mostrarInformacion() {
        return "ID: " + id +
               "\nTitulo: " + titulo +
               "\nAutor: " + autor +
               "\nEditorial: " + editorial +
               "\nAño: " + anioPublicacion +
               "\nCategoria: " + categoria +
               "\nEstado: " + estado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }
    
    public void incrementarPrestamo() {
	contadorPrestamos++;
    }

    public int getContadorPrestamos() {
	return contadorPrestamos;
    }
}
