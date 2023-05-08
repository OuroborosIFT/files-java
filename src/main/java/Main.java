import model.GenerateUser;
import operation.UserOperations;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Users.txt");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the path of file : ");
//        String file = scanner.next();
        GenerateUser generateUser = new GenerateUser(file);
        UserOperations userOperations = new UserOperations(file);

        generateUser.generate();
    }
}
