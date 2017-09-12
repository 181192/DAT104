package no.hvl.dat104.model;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list", schema = "shopping_list", catalog = "DAT104")
public class ShoppingListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_list_id")
    private Integer shoppingListId;
    private String description;

    public ShoppingListEntity() {
        this("");
    }

    public ShoppingListEntity(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingListEntity that = (ShoppingListEntity) o;

        if (shoppingListId.intValue() == that.shoppingListId.intValue())
            if (description != null ? description.equals(that.description) : that.description == null) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = shoppingListId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
