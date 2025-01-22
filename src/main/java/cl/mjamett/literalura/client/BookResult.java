package cl.mjamett.literalura.client;

import java.util.List;

public class BookResult {
    private int id;
    private String title;
    private List<AuthorResult> authors;
    private List<String> languages;
    private int download_count;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorResult> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorResult> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() { // Nombre generado por convención
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }
}
