package no.hvl.dat104.dataaccess;


import no.hvl.dat104.model.Vare;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VareDAO {
    @PersistenceContext(name = "varePersistenceUnit")
    private EntityManager em;

    public void leggTilVare(Vare v) {
        em.persist(v);
    }

    public Vare finnVare(String id) {
        return em.find(Vare.class, id);
    }

    public void oppdaterVare(Vare v) {
        em.merge(v);
    }

    public void slettVare(Vare id) {
        em.remove(em.find(Vare.class, id.getItem()));
    }

    public List<Vare> alleVarer() {
        TypedQuery<Vare> query = em.createQuery("SELECT v FROM Vare v", Vare.class);
        return query.getResultList();
    }
}
