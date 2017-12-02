package no.kalli.dataaccess;

import no.kalli.model.Klasse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class KlasseEAO {

    @PersistenceContext(name = "studentPersistenceUnit")
    private EntityManager em;

    public void leggTilKlasse(Klasse k) {
        em.persist(k);
    }

    public Klasse finnKlasse(String klassekode) {
        return em.find(Klasse.class, klassekode);
    }

    public void oppdaterKlasse(Klasse k) {
        em.merge(k);
    }

    public void slettKlasse(String klassekode) {
        em.remove(em.find(Klasse.class, klassekode));
    }

    public List<Klasse> alleKlasser() {
        List<Klasse> klasser = em.createQuery("select k from klasse k").getResultList();
        return klasser;
    }
}
