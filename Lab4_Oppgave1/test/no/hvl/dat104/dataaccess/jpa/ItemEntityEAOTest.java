package no.hvl.dat104.dataaccess.jpa;

import no.hvl.dat104.dataaccess.IItemEAO;
import no.hvl.dat104.model.ItemEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemEntityEAOTest {
    private IItemEAO itemEAO;
    private ItemEntity item = new ItemEntity("Melk");
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        itemEAO = new ItemEAO();
        emf = Persistence.createEntityManagerFactory("eclipselink");
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @Test
    void addItem() {
    }

    @Test
    void findItem() {
        assertEquals(item, itemEAO.findItem(1));
    }

    @Test
    void updateItem() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void allItems() {

    }

}