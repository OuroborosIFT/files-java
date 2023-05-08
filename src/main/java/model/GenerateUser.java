package model;

import operation.UserOperations;

import java.io.File;
import java.util.Random;

public class GenerateUser {
    private final UserOperations usersOperations;

    private final String[][] names = {
            {"Alexandr", "Anton", "Kiril", "Petr", "Alexey", "Vladimir", "Eugeniy", "Oleg", "Ilya", "Pavel", "Ivan"},
            {"Izmaylov", "Romanov", "Antonov", "Bobrov", "Petrov", "Bodrov", "Ezhov", "Tarashov", "Rostrikin", "Leskov", "Abalenskiy"}
    };

    public GenerateUser(File file) {
        usersOperations = new UserOperations(file);
    }

    public GenerateUser(String filePath) {
        usersOperations = new UserOperations(filePath);
    }


    public UserOperations generate() {
        for (int i = 0; i < names[0].length; i++) {
            Random random = new Random();
            String name = names[0][random.nextInt(0, names[0].length)];
            String lastname = names[1][random.nextInt(0, names[1].length)];
            int age = random.nextInt(1, 90);
            boolean isJob = random.nextBoolean();

            usersOperations.createUser(name, lastname, age, isJob);
        }

        return usersOperations;
    }

}
