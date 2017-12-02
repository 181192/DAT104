package no.kalli.dataaccess;

import no.kalli.model.Klasse;
import no.kalli.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentEAO {
    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public void leggTilStudent(Student s, String klassekode) {
        Klasse k = em.find(Klasse.class, klassekode);
        s.setKlasseByKlasseKode(k);
        em.persist(s);
    }

    public Student finnStudent(String id) {
        return em.find(Student.class, id);
    }

    public void oppdaterStudent(Student s) {
        em.merge(s);
    }

    public void slettStudent(String id) {
        em.remove(em.find(Student.class, id));
    }

    public void byttKlasse(String studentId, String klassekode) {
        Student s = em.find(Student.class, studentId);
        Klasse k = em.find(Klasse.class, klassekode);
        s.setKlasseByKlasseKode(k);
    }

    public List<Student> alleStudenterIKlasse(String klassekode) {
        return em.find(Klasse.class, klassekode).getStudenter();
    }

    public List<Student> alleStudenter() {
        return em.createQuery("select s from Student s").getResultList();
    }

}
