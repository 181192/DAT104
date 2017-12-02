package no.kalli.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Student {
    private String id;
    private String navn;
    private String passord;
    private String salt;
    private Klasse klasseByKlasseKode;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "navn")
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Basic
    @Column(name = "passord")
    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(navn, student.navn) &&
                Objects.equals(passord, student.passord) &&
                Objects.equals(salt, student.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, navn, passord, salt);
    }

    @ManyToOne
    @JoinColumn(name = "klasse_kode", referencedColumnName = "kode")
    public Klasse getKlasseByKlasseKode() {
        return klasseByKlasseKode;
    }

    public void setKlasseByKlasseKode(Klasse klasseByKlasseKode) {
        this.klasseByKlasseKode = klasseByKlasseKode;
    }
}
