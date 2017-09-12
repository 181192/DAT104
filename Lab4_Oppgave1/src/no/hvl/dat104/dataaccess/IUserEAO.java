package no.hvl.dat104.dataaccess;

import no.hvl.dat104.model.UserEntity;

import java.util.List;

public interface IUserEAO {

    void addUser(UserEntity u);

    UserEntity findUser(String id);

    void updateUser(UserEntity u);

    void removeUser(UserEntity id);

    List<UserEntity> allUser();
}
