package no.hvl.dat104.dataaccess;

import no.hvl.dat104.model.ShoppingListEntity;

import java.util.List;

public interface IShoppingListEAO {

    void addShoppingList(ShoppingListEntity s);

    ShoppingListEntity findShoppingList(Integer id);

    void updateShoppingList(ShoppingListEntity s);

    void removeShoppingList(ShoppingListEntity id);

    List<ShoppingListEntity> allShoppingListEntity();

    List allItemsInShoppingList(ShoppingListEntity sl_id);
}
