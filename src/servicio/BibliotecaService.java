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

        listaLibros.add(libro);
        return true;
    }

    public ArrayList<Libro> listarLibros() {
        return listaLibros;
    }
    
}
