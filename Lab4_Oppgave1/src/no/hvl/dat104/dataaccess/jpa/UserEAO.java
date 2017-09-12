package no.hvl.dat104.dataaccess.jpa;

import no.hvl.dat104.dataaccess.IUserEAO;
import no.hvl.dat104.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserEAO implements IUserEAO {
    @PersistenceContext(name = "itemPersistenceUnit")
    private EntityManager em;

    public void addUser(UserEntity u) {
        em.persist(u);
    }

    public UserEntity findUser(String id) {
        return em.find(UserEntity.class, id);
    }

    public void updateUser(UserEntity u) {
        em.merge(u);
    }

    public void removeUser(UserEntity id) {
        em.remove(em.find(UserEntity.class, id.getUserId()));
    }

    public List<UserEntity> allUser() {
        TypedQuery<UserEntity> query = em.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
        return query.getResultList();
    }
}
