package repository;

import model.User;

public interface UsersRepository {

    User findById(int id);
    void create(User user);
    void update(User user);
    void delete(int id);

}
