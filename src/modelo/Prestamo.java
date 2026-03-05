/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Vanes
 */
public class Prestamo {

    private int id;
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(int id, Libro libro, Cliente cliente) {
        this.id = id;
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
    }

    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}