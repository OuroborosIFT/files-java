package service;

import model.User;
import operation.FileRead;
import operation.FileWrite;
import repository.FileReadRepository;
import repository.FileWriteRepository;
import repository.UsersRepository;

import java.io.File;
import java.util.List;

public class UserService implements UsersRepository {

    private FileReadRepository fileReadRepository;
    private FileWriteRepository fileWriteRepository;

    public UserService(File file) {
        fileReadRepository = new FileRead(file);
        fileWriteRepository = new FileWrite(file);
    }

    public UserService(String filePath) {
        fileReadRepository = new FileRead(filePath);
        fileWriteRepository = new FileWrite(filePath);
    }

    @Override
    public User findById(int id) {
        List<User> userList = fileReadRepository.readFile();

        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void create(User user) {
        List<User> userList = fileReadRepository.readFile();
        userList.add(user);
        fileWriteRepository.writeFile(userList);
    }

    @Override
    public void update(User user) {
        List<User> userList = fileReadRepository.readFile();

        for (User users : userList) {
            if (user.getId() == users.getId()) {
                userList.remove(users);
                userList.add(user);
                break;
            }
        }

        fileWriteRepository.writeFile(userList);
    }

    @Override
    public void delete(int id) {
        List<User> userList = fileReadRepository.readFile();
        userList.removeIf(users -> id == users.getId());
        fileWriteRepository.writeFile(userList);
    }

}
