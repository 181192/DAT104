package no.kalli.model;

import javax.persistence.*;

@Entity
@Table(schema = "student", name = "student")
public class Student {
    private String id;
    private String navn;
    private String passord;
    private String salt;
    private Klasse klasseByKlasseKode;

    public Student() {
        this("", "", "", "", null);
    }

    public Student(String id, String navn, String passord, String salt, Klasse klasseByKlasseKode) {
        this.id = id;
        this.navn = navn;
        this.passord = passord;
        this.salt = salt;
        this.klasseByKlasseKode = klasseByKlasseKode;
    }

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

    @ManyToOne
    @JoinColumn(name = "klasse_kode", referencedColumnName = "kode")
    public Klasse getKlasseByKlasseKode() {
        return klasseByKlasseKode;
    }

    public void setKlasseByKlasseKode(Klasse klasseByKlasseKode) {
        this.klasseByKlasseKode = klasseByKlasseKode;
    }

    private Klasse klasses;

    @ManyToOne(optional = false)
    public Klasse getKlasses() {
        return klasses;
    }

    public void setKlasses(Klasse klasses) {
        this.klasses = klasses;
    }
}
