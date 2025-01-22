package cl.mjamett.literalura.repository;

import cl.mjamett.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface AutorRepository  extends JpaRepository<Autor, Long>{

    List<Autor> findByNombreAndApellido(String nombre, String apellido);


    @Query("SELECT a FROM Autor a WHERE (a.anioNacimiento IS NOT NULL AND a.anioNacimiento <= :anio) AND " +
            "(a.anioMuerte IS NULL OR a.anioMuerte > :anio)")
    List<Autor> findAutoresVivosEnAnio(Integer anio);

    List<Autor> findByApellido(String apellido);


    List<Autor> findByNombreContaining(String cadena);


    @Query("SELECT DISTINCT a FROM Autor a JOIN a.libros l")
    List<Autor> findAutoresConLibros();

}
