package no.hvl.dat104.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_list", schema = "shopping_list", catalog = "DAT104")
public class ShoppingListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_list_id")
    private Integer shoppingListId;
    private String description;

    @Transient
    private List<ItemEntity> items;

    public ShoppingListEntity() {
        this("");
        items = new ArrayList<>();
    }

    public ShoppingListEntity(String description) {
        this.description = description;
        items = new ArrayList<>();
    }

    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public void addItemToShoppingList(ItemEntity i) {
        items.add(i);
    }

    public void removeItemFromShoppingList(ItemEntity i) {
        items.remove(i);
    }
}
