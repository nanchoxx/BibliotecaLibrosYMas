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
}
