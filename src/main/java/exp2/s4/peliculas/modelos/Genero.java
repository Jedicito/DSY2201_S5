package exp2.s4.peliculas.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genero")
    private String genero;

    public Genero() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}