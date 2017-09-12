package no.hvl.dat104.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "shopping_list", catalog = "DAT104")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String name;
    private String password;

    public UserEntity() {
        this("", "");
    }

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return Objects.equals(userId, that.userId) && (name != null ? name.equals(that.name) : that.name == null) && (password != null ? password.equals(that.password) : that.password == null);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
