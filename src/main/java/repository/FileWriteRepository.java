package repository;

import model.User;

import java.util.List;

public interface FileWriteRepository {

    void writeFile(List<User> usersList);

}
