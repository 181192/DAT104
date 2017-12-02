package no.kalli.model;

import javax.persistence.*;

@Entity
@Table(schema = "student", name = "student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "navn")
    private String navn;
    @Column(name = "passord")
    private String passord;
    @Column(name = "salt")
    private String salt;

    @ManyToOne
    @JoinColumn(name = "klasse_kode", referencedColumnName = "kode")
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Klasse getKlasseByKlasseKode() {
        return klasseByKlasseKode;
    }

    public void setKlasseByKlasseKode(Klasse klasseByKlasseKode) {
        this.klasseByKlasseKode = klasseByKlasseKode;
    }
}
