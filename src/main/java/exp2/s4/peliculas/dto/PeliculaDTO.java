package exp2.s4.peliculas.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import exp2.s4.peliculas.modelos.Pelicula;

@JsonPropertyOrder({"id", "titulo", "año", "director", "genero", "sinopsis"})
public class PeliculaDTO {

    private int id;
    private String titulo;

    @JsonProperty("año")  // import jackson / anno -> "año"
    private int anno;

    private String director;
    private String genero;
    private String sinopsis;

    
    public PeliculaDTO(Pelicula p) {
        this.id       = p.getId();
        this.titulo   = p.getTitulo();
        this.anno     = p.getAnno();
        this.director = p.getDirector().getNombre();
        this.genero   = p.getGenero().getGenero();
        this.sinopsis = p.getSinopsis();
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAnno() { return anno; }
    public String getDirector() { return director; }
    public String getGenero() { return genero; }
    public String getSinopsis() { return sinopsis; }
}