package uptc.fr.model;

import uptc.fr.conf.Column;
import uptc.fr.conf.Entity;

@Entity(table = "author")
public class AuthorEntity {
    @Column(name = "aut_id")
    private Long id;
    @Column(name = "aut_name")
    private String nombre;
    @Column(name = "aut_email")
    private String correo;

    public AuthorEntity() {
    }

    public AuthorEntity(long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String print() {
        return "AuthorEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}