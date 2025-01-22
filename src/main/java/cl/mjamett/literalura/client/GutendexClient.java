package cl.mjamett.literalura.client;
import org.springframework.stereotype.Service;
import cl.mjamett.literalura.model.Libro;
import org.springframework.web.client.RestTemplate;
import cl.mjamett.literalura.model.Autor;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class GutendexClient {
    private final String API_URL = "https://gutendex.com/books?search=";

    public Libro buscarLibro(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + titulo;

        try {
            var response = restTemplate.getForObject(url, GutendexResponse.class);
            if (response != null && !response.getResults().isEmpty()) {
                var bookData = response.getResults().get(0);

                // Procesar el libro
                Libro libro = new Libro();
                libro.setTitulo(bookData.getTitle());
                libro.setIdioma(bookData.getLanguages().get(0));
                libro.setNumeroDescargas(bookData.getDownload_count());
                libro.setIdentificadorApi(String.valueOf(bookData.getId()));

                // Procesar el autor
                if (!bookData.getAuthors().isEmpty()) {
                    var authorData = bookData.getAuthors().get(0);
                    Autor autor = new Autor();
                    autor.setNombre(authorData.getName());
                    autor.setAnioNacimiento(authorData.getBirth_year());
                    autor.setAnioMuerte(authorData.getDeath_year());
                    libro.setAutor(autor);
                }

                return libro;
            }
        } catch (HttpClientErrorException e) {
            throw new IllegalArgumentException("Error al buscar el libro en la API: " + e.getMessage());
        }

        throw new IllegalArgumentException("Libro no encontrado.");
    }
}
