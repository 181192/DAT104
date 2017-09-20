package no.hvl.dat104.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "shopping_list", catalog = "DAT104")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sh_id", referencedColumnName = "shopping_list_id")
    private ShoppingListEntity shoppingList;

    public UserEntity() {
        this("", "", null);
    }

    public UserEntity(String userId, String password, ShoppingListEntity s) {
        this.userId = userId;
        this.password = password;
        this.shoppingList = s;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingListEntity getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingListEntity shoppingList) {
        this.shoppingList = shoppingList;
    }
}
