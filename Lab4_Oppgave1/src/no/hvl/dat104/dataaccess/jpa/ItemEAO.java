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

    @Override
    public void addItem(ItemEntity i) {
        em.persist(i);
    }

    @Override
    public ItemEntity findItem(Integer id) {
        return em.find(ItemEntity.class, id);
    }

    @Override
    public void updateItem(ItemEntity i) {
        em.merge(i);
    }

    @Override
    public void removeItem(ItemEntity id) {
        em.remove(em.find(ItemEntity.class, id.getItemId()));
    }

    @Override
    public List<ItemEntity> allItems() {
        TypedQuery<ItemEntity> query = em.createQuery("SELECT i FROM ItemEntity i", ItemEntity.class);
        return query.getResultList();
    }
}
