package cl.mjamett.literalura.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


    @Entity
    @Table(name = "autor")

    public class Autor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String apellido;
        private int anioNacimiento;
        private int anioMuerte;

        @OneToMany(mappedBy = "autor")
        private List<Libro> libros = new ArrayList<>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombreAutor) {
            this.nombre = nombreAutor;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getAnioNacimiento() {
            return anioNacimiento;
        }

        public void setAnioNacimiento(int anioNacimiento) {
            this.anioNacimiento = anioNacimiento;
        }

        public int getAnioMuerte() {
            return anioMuerte;
        }

        public void setAnioMuerte(int anioMuerte) {
            this.anioMuerte = anioMuerte;
        }

        public List<Libro> getLibros() {
            return libros;
        }

        public void setLibros(List<Libro> libros) {
            this.libros = libros;
        }
    }


