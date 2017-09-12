package no.hvl.dat104.dataaccess;

import no.hvl.dat104.model.ItemEntity;

import java.util.List;

public interface IItemEAO {
    void addItem(ItemEntity v);

    ItemEntity findItem(String id);

    void updateItem(ItemEntity v);

    void removeItem(ItemEntity id);

    List<ItemEntity> allItems();
}
