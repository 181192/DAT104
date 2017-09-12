package no.hvl.dat104.model;

import javax.persistence.*;

@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        return (itemId.intValue() == that.itemId.intValue()) && ((item != null) ? item.equals(that.item) : (that.item == null));
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}
