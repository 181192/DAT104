package no.hvl.dat104.dataaccess.jpa;

import no.hvl.dat104.dataaccess.IShoppingListEAO;
import no.hvl.dat104.model.ItemEntity;
import no.hvl.dat104.model.ShoppingListEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShoppingListEAO implements IShoppingListEAO {
    @PersistenceContext(name = "itemPersistenceUnit")
    private EntityManager em;

    public void addShoppingList(ShoppingListEntity s) {
        em.persist(s);
    }

    public ShoppingListEntity findShoppingList(String id) {
        return em.find(ShoppingListEntity.class, id);
    }

    public void updateShoppingList(ShoppingListEntity s) {
        em.merge(s);
    }

    public void removeShoppingList(ShoppingListEntity id) {
        em.remove(em.find(ItemEntity.class, id.getShoppingListId()));
    }

    public List<ShoppingListEntity> allShoppingListEntity() {
        TypedQuery<ShoppingListEntity> query = em.createQuery("SELECT s FROM ShoppingListEntity s", ShoppingListEntity.class);
        return query.getResultList();
    }
}
