package no.hvl.dat104.dataaccess.jpa;


import no.hvl.dat104.dataaccess.IItemEAO;
import no.hvl.dat104.model.ItemEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ItemEAO implements IItemEAO {
    @PersistenceContext(name = "itemPersistenceUnit")
    private EntityManager em;

    public void addItem(ItemEntity v) {
        em.persist(v);
    }

    public ItemEntity findItem(String id) {
        return em.find(ItemEntity.class, id);
    }

    public void updateItem(ItemEntity v) {
        em.merge(v);
    }

    public void removeItem(ItemEntity id) {
        em.remove(em.find(ItemEntity.class, id.getItem()));
    }

    public List<ItemEntity> allItems() {
        TypedQuery<ItemEntity> query = em.createQuery("SELECT i FROM ItemEntity i", ItemEntity.class);
        return query.getResultList();
    }
}
