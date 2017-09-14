package no.hvl.dat104.dataaccess.jpa;

import no.hvl.dat104.dataaccess.IUserEAO;
import no.hvl.dat104.model.ShoppingListEntity;
import no.hvl.dat104.model.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserEAO implements IUserEAO {
    @PersistenceContext(name = "itemPersistenceUnit")
    private EntityManager em;

    @Override
    public void addUser(UserEntity u) {
        em.persist(u);
    }

    @Override
    public UserEntity findUser(String id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void updateUser(UserEntity u) {
        em.merge(u);
    }

    @Override
    public void removeUser(UserEntity id) {
        em.remove(em.find(UserEntity.class, id.getUserId()));
    }

    @Override
    public List<UserEntity> allUser() {
        TypedQuery<UserEntity> query = em.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ShoppingListEntity> allShoppingListInUser(String user_id) {
        return null;
    }


}
