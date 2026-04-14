package exp2.s4.peliculas.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anno")
    private int anno;

    @ManyToOne
    @JoinColumn(name = "iddirector")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;

    @Column(name = "sinopsis")
    private String sinopsis;

    public Pelicula() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnno() { return anno; }
    public void setAnno(int anno) { this.anno = anno; }

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}