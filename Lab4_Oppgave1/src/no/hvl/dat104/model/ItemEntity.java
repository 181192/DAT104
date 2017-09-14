package no.hvl.dat104.model;

import javax.persistence.*;

@Entity(name = "ItemEntity")
@Table(name = "item", schema = "shopping_list", catalog = "DAT104")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    private String item;

    public ItemEntity() {
        this("");
    }

    public ItemEntity(String item) {
        this.item = item;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
