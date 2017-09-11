package no.hvl.dat104.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "handleliste", name = "vare")
public class Vare {
    @Id
    private String item;

    public Vare() {
        this.item = "";
    }

    public Vare(String vare) {
        this.item = vare;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String navn) {
        this.item = navn;
    }
}