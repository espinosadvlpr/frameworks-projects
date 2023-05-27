package uptc.fr.model;

import java.util.Date;

import uptc.fr.conf.Column;
import uptc.fr.conf.Entity;

@Entity(table = "message")
public class MessageEntity {
    @Column(name = "mes_id")
    private Long id;
    @Column(name = "mes_num")
    private int num;
    @Column(name = "mes_text")
    private String texto;
    @Column(name = "mes_date")
    private Date fecha;

    public MessageEntity() {
    }

    public MessageEntity(long id, int num, String texto, Date fecha) {
        this.id = id;
        this.num = num;
        this.texto = texto;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String print() {
        return "MessageEntity{" +
                "id=" + id +
                ", num=" + num +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}