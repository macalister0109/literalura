package cl.mjamett.literalura;

import cl.mjamett.literalura.client.GutendexClient;
import cl.mjamett.literalura.model.Libro;
import cl.mjamett.literalura.services.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class LiteraluraApp implements CommandLineRunner {

    private final GutendexClient gutendexClient;
    private final LibroService libroService;

    public LiteraluraApp(GutendexClient gutendexClient, LibroService libroService) {
        this.gutendexClient = gutendexClient;
        this.libroService = libroService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Buscar libro por título");
                System.out.println("2. Listar libros");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.nextLine(); // Limpia la entrada
                    continue;
                }

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        Libro libro = gutendexClient.buscarLibro(titulo);
                        libroService.guardarLibro(libro);
                        System.out.println("Libro guardado: " + libro.getTitulo());
                        break;

                    case 2:
                        libroService.listarLibros().forEach(l -> System.out.println("Título: " + l.getTitulo()));
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpia la entrada
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}
