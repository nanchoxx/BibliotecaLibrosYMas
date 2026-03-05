/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.Scanner;
import modelo.Libro;
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

                case 3:
                    System.out.println("Registrar cliente");
                    break;

                case 4:
                    System.out.println("Listar clientes");
                    break;

                case 5:
                    System.out.println("Prestar libro");
                    break;

                case 6:
                    System.out.println("Devolver libro");
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
