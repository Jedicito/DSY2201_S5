package exp2.s4.peliculas.dto;

public class PeliculaRequest {

    private String titulo;
    private int anno;
    private int idDirector;
    private int idGenero;
    private String sinopsis;

    public PeliculaRequest() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnno() { return anno; }
    public void setAnno(int anno) { this.anno = anno; }

    public int getIdDirector() { return idDirector; }
    public void setIdDirector(int idDirector) { this.idDirector = idDirector; }

    public int getIdGenero() { return idGenero; }
    public void setIdGenero(int idGenero) { this.idGenero = idGenero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}