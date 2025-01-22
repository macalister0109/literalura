package cl.mjamett.literalura.services;

import cl.mjamett.literalura.model.Libro;
import cl.mjamett.literalura.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro guardarLibro(Libro libro) {
        if (libroRepository.findByIdentificadorApi(libro.getIdentificadorApi()) != null) {
            throw new IllegalArgumentException("El libro ya existe en la base de datos.");
        }
        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}
