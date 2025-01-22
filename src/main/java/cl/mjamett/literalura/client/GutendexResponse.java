package cl.mjamett.literalura.client;

import java.util.List;

public class GutendexResponse {
    private List<BookResult> results;

    public List<BookResult> getResults() {
        return results;
    }

    public void setResults(List<BookResult> results) {
        this.results = results;
    }
}