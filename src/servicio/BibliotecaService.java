/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author JORGEP
 */
public class BibliotecaService {
    
    private ArrayList<Libro> listaLibros;

    public BibliotecaService() {
        listaLibros = new ArrayList<>();
    }
    
    public boolean registrarLibro(Libro libro) {

        if (libro == null) {
            return false;
        }

        for (int i = 0; i < listaLibros.size(); i++) {

            Libro l = listaLibros.get(i);

            if (l.getId() == libro.getId()) {
                return false; // Ya existe un libro con ese ID
            }
        }

        listaLibros.add(libro);
        return true;
    }

    public ArrayList<Libro> listarLibros() {
        return listaLibros;
    }
    
    public Libro buscarLibroPorId(int id) {

        for (int i = 0; i < listaLibros.size(); i++) {

            Libro l = listaLibros.get(i);

            if (l.getId() == id) {
                return l;
            }
        }

        return null;
    }

    public void buscarLibros(String textoBusqueda) {
	boolean encontrado = false;

	for (int i = 0; i < listaLibros.size(); i++) {
	    Libro libro = listaLibros.get(i);

	    if(libro.getTitulo().toLowerCase().contains(textoBusqueda.toLowerCase()) ||
	       libro.getAutor().toLowerCase().contains(textoBusqueda.toLowerCase()) ||
	       libro.getCategoria().toLowerCase().contains(textoBusqueda.toLowerCase())) {

               System.out.println("Libro encontrado:");
	       System.out.println("Titulo: " + libro.getTitulo());
	       System.out.println("Autor: " + libro.getAutor());
	       System.out.println("Categoria: " + libro.getCategoria());
	       System.out.println("-------------------------");

	       encontrado = true;

	    }
	 }

         if(!encontrado) {
	    System.out.println("No se encontraron libros con esas caracteristicas.");
	 }
    }   

    public void mostrarLibrosMasPrestados() {
	listaLibros.sort((a, b) -> b.getContadorPrestamos() - a.getContadorPrestamos());

	System.out.println("=== Libros mas prestados ===");

	int limite = Math.min(3, listaLibros.size());

	for(int i = 0; i < limite; i++) {
	   Libro libro = listaLibros.get(i);
	   System.out.println((i + 1) + ". " + libro.getTitulo() + " - Prestamos: " + libro.getContadorPrestamos());
	}
    } 	

}
