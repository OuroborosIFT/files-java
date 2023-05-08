package operation;

import model.User;
import repository.FileReadRepository;
import repository.FileWriteRepository;
import repository.UsersRepository;
import service.UserService;

import java.io.File;
import java.util.List;
import java.util.Random;

public class UserOperations {

    private final Random random = new Random();
    private final UsersRepository usersRepository;
    private final FileReadRepository readRepository;
    private final FileWriteRepository writeRepository;

    public UserOperations(File file) {
        usersRepository = new UserService(file);
        readRepository = new FileRead(file);
        writeRepository = new FileWrite(file);
    }

    public UserOperations(String filePath) {
        usersRepository = new UserService(filePath);
        readRepository = new FileRead(filePath);
        writeRepository = new FileWrite(filePath);
    }

    // Генерация уникального id пользователя
    private int generateID(int randId) {
        List<User> usersList = readRepository.readFile();

        for (User user : usersList) {
            if (user.getId() == randId) {
                return generateID(random.nextInt(1, 100));
            }
        }

        return randId;
    }

    // Поиск пользователя по id
    public void findUser(int id) {
        try {
            User user = usersRepository.findById(id);
            System.out.println("\nUser found : \n" + user);
        }catch (Exception e) {
            throw new RuntimeException("Сan`t find to user!");
        }
    }

    // Создание нового пользователя
    public void createUser(String name, String lastname, int age, boolean isJob) {
        try {
            int id = generateID(random.nextInt(1, 100000));
            User user = new User(id, name, lastname, age, isJob);

            System.out.println("\nUser created : \n" + user);
            usersRepository.create(user);
        }catch (Exception e) {
            throw new RuntimeException("Can't create user!");
        }
    }

    // Изменение имени пользователя
    public void updateUserName(int id, String name) {
        try {
            User user = usersRepository.findById(id);
            System.out.println("\nUser name changed : \n" + user);
            user.setName(name);
            usersRepository.update(user);
            System.out.println("New user data : \n" + user);
        }catch (Exception e) {
            System.out.println("Unable update to user`s name!");
        }
    }

    // Изменение фамилии пользователя
    public void updateUserLastname(int id, String lastname) {
        try {
            User user = usersRepository.findById(id);
            System.out.println("\nUser lastname changed : \n" + user);
            user.setLastname(lastname);
            usersRepository.update(user);
            System.out.println("New user data : \n" + user);
        }catch (Exception e) {
            System.out.println("Unable update to user`s lastname!");
        }
    }

    // Изменение возраста пользователя
    public void updateUserAge(int id, int age) {
        try {
            User user = usersRepository.findById(id);
            System.out.println("\nUser age changed : \n" + user);
            user.setAge(age);
            usersRepository.update(user);
            System.out.println("New user data : \n" + user);
        }catch (Exception e) {
            System.out.println("Unable update to user`s age!");
        }
    }

    // Изменение трудового статуса пользователя
    public void updateUserJob(int id, boolean isJob) {
        try {
            User user = usersRepository.findById(id);
            System.out.println("\nUser job changed : \n" + user);
            user.setJob(isJob);
            usersRepository.update(user);
            System.out.println("New user data : \n" + user);
        }catch (Exception e) {
            System.out.println("Unable update to user`s job!");
        }
    }
    // Удаление пользователя
    public void deleteUser(int id) {
        try {
            System.out.println("\nUser delete : \n" + usersRepository.findById(id));
            usersRepository.delete(id);
        }catch (Exception e) {
            throw new RuntimeException("Can't delete user!");
        }
    }

}
