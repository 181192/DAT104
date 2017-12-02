package no.kalli.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Klasse {
    private String kode;
    private String program;

    @Id
    @Column(name = "kode")
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    @Basic
    @Column(name = "program")
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klasse klasse = (Klasse) o;
        return Objects.equals(kode, klasse.kode) &&
                Objects.equals(program, klasse.program);
    }

    @Override
    public int hashCode() {

        return Objects.hash(kode, program);
    }
}
