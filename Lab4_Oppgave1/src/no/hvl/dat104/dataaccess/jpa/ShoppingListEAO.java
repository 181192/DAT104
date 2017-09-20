package no.hvl.dat104.dataaccess.jpa;

import no.hvl.dat104.dataaccess.IShoppingListEAO;
import no.hvl.dat104.model.ItemEntity;
import no.hvl.dat104.model.ShoppingListEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ShoppingListEAO implements IShoppingListEAO {
    @PersistenceContext(name = "itemPersistenceUnit")
    private EntityManager em;

    @Override
    public void addShoppingList(ShoppingListEntity s) {
        em.persist(s);
    }

    @Override
    public ShoppingListEntity findShoppingList(Integer id) {
        return em.find(ShoppingListEntity.class, id);
    }

    @Override
    public void updateShoppingList(ShoppingListEntity s) {
        em.merge(s);
    }

    @Override
    public void removeShoppingList(ShoppingListEntity id) {
        em.remove(em.find(ItemEntity.class, id.getShoppingListId()));
    }

    @Override
    public List<ShoppingListEntity> allShoppingListEntity() {
        TypedQuery<ShoppingListEntity> query = em.createQuery("SELECT s FROM ShoppingListEntity s", ShoppingListEntity.class);
        return query.getResultList();
    }

    @Override
    public List allItemsInShoppingList(ShoppingListEntity sl_id) {
        return em.createQuery("SELECT i FROM ItemEntity i WHERE i.shoppingList = :sl_id").setParameter("sl_id", sl_id).getResultList();
    }
}
