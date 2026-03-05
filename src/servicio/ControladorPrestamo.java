/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;

/**
 *
 * @author Vanes
 */
public class ControladorPrestamo {

    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public String registrarPrestamo(Libro libro, Cliente cliente) {

        // Verificar que el libro esté disponible
        if (!libro.getEstado().equals(Libro.DISPONIBLE)) {
            return "El libro no está disponible.";
        }

        // Verificar que el cliente no tenga libro
        if (cliente.isLibroPrestado()) {
            return "El cliente ya tiene un libro prestado.";
        }

        Prestamo nuevo = new Prestamo(listaPrestamos.size() + 1, libro, cliente);
        listaPrestamos.add(nuevo);

        libro.cambiarEstado(Libro.PRESTADO);
        cliente.setLibroPrestado(true);

        return "Préstamo registrado correctamente.";
    }

    public String registrarDevolucion(Prestamo prestamo) {

        prestamo.registrarDevolucion();

        prestamo.getLibro().cambiarEstado(Libro.DISPONIBLE);
        prestamo.getCliente().setLibroPrestado(false);

        return "Devolución registrada correctamente.";
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
}