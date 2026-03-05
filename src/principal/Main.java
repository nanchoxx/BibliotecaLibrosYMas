/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.Scanner;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;
import servicio.BibliotecaService;
import servicio.ControladorCliente;
import servicio.ControladorPrestamo;

/**
 *
 * @author JORGEP
 */
public class Main {
    
    public static void main(String[] args) {

        BibliotecaService bibliotecaService = new BibliotecaService();
        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("===== SISTEMA BIBLIOTECA =====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ================= REGISTRAR LIBRO =================
                case 1:

                    System.out.println("\n=== REGISTRAR LIBRO ===");

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Editorial: ");
                    String editorial = sc.nextLine();

                    System.out.print("Año Publicacion: ");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    Libro libro = new Libro(
                            id,
                            titulo,
                            autor,
                            editorial,
                            anio,
                            categoria,
                            Libro.DISPONIBLE
                    );

                    if (bibliotecaService.registrarLibro(libro)) {
                        System.out.println("Libro registrado correctamente.");
                    } else {
                        System.out.println("Error: ID ya existe.");
                    }

                    break;

                // ================= LISTAR LIBROS =================
                case 2:

                    System.out.println("\n=== LISTA DE LIBROS ===");

                    for (Libro l : bibliotecaService.listarLibros()) {
                        System.out.println("--------------------------------");
                        System.out.println(l.mostrarInformacion());
                    }

                    break;

                // ================= REGISTRAR CLIENTE =================
                case 3:

                    System.out.println("\n=== REGISTRAR CLIENTE ===");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Documento: ");
                    int documento = sc.nextInt();

                    System.out.print("Telefono: ");
                    int telefono = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = sc.nextLine();

                    Cliente cliente = new Cliente(
                            nombre,
                            documento,
                            telefono,
                            direccion,
                            false
                    );

                    if (controladorCliente.registar(cliente)) {
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("Cliente ya existe.");
                    }

                    break;

                // ================= LISTAR CLIENTES =================
                case 4:

                    System.out.println("\n=== LISTA DE CLIENTES ===");

                    for (Cliente c : controladorCliente.listarClientes()) {
                        System.out.println("--------------------------------");
                        System.out.println("Nombre: " + c.getNombre());
                        System.out.println("Documento: " + c.getDocumento());
                        System.out.println("Telefono: " + c.getTelefono());
                        System.out.println("Direccion: " + c.getDireccion());
                        System.out.println("Tiene libro: " + c.isLibroPrestado());
                    }

                    break;

                // ================= PRESTAR LIBRO =================
                case 5:

                    System.out.println("\n=== PRESTAR LIBRO ===");

                    System.out.print("ID del libro: ");
                    int idLibro = sc.nextInt();

                    System.out.print("Documento cliente: ");
                    int docCliente = sc.nextInt();

                    Libro libroPrestamo = bibliotecaService.buscarLibroPorId(idLibro);
                    Cliente clientePrestamo = controladorCliente.buscar(docCliente);

                    if (libroPrestamo == null) {
                        System.out.println("Libro no encontrado.");
                        break;
                    }

                    if (clientePrestamo == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    String resultado = controladorPrestamo.registrarPrestamo(
                            libroPrestamo,
                            clientePrestamo
                    );

                    System.out.println(resultado);

                    break;

                // ================= DEVOLVER LIBRO =================
                case 6:

                    System.out.println("\n=== DEVOLVER LIBRO ===");

                    System.out.print("ID del libro: ");
                    int idDev = sc.nextInt();

                    Libro libroDev = bibliotecaService.buscarLibroPorId(idDev);

                    if (libroDev == null) {
                        System.out.println("Libro no encontrado.");
                        break;
                    }

                    Prestamo prestamo = null;

                    // Buscar préstamo activo de ese libro
                    for (Prestamo p : controladorPrestamo.getListaPrestamos()) {
                        if (p.getLibro().getId() == idDev) {
                            prestamo = p;
                            break;
                        }
                    }

                    if (prestamo == null) {
                        System.out.println("No hay préstamo activo para este libro.");
                        break;
                    }

                    System.out.println(
                            controladorPrestamo.registrarDevolucion(prestamo)
                    );

                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
    
}
