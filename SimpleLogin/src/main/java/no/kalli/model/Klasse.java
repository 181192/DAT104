package no.kalli.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "student", name = "klasse")
public class Klasse {
    private String kode;
    private String program;

    @OneToMany(mappedBy = "klasses", fetch = FetchType.EAGER)
    private List<Student> studenter;

    public Klasse() {
        this("","");
        this.studenter = new ArrayList<Student>();
    }

    public Klasse(String kode, String program) {
        this.kode = kode;
        this.program = program;
        this.studenter = new ArrayList<Student>();
    }

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


    public List<Student> getStudenter() {
        return studenter;
    }

    public void setStudenter(List<Student> studenter) {
        this.studenter = studenter;
    }
}
