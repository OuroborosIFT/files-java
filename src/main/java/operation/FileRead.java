package operation;

import model.User;
import repository.FileReadRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileRead implements FileReadRepository {

    private final File file;

    public FileRead(File file) {
        this.file = file;
    }

    public FileRead(String filePath) {
        file = new File(filePath);
    }

    @Override
    public List<User> readFile() {
        List<User> usersList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Разделяем строку по разделителю
                String[] info = line.split("\\|");
                // Читаем все данные
                int tempID = Integer.parseInt(info[0]);
                String name = info[1];
                String lastname = info[2];
                int age = Integer.parseInt(info[3]);
                boolean isJob = Boolean.parseBoolean(info[4]);

                usersList.add(new User(tempID, name, lastname, age, isJob));
            }
        } catch (FileNotFoundException e) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created!");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error!");
        }

        // Сортируем пользователей в порядке возрастания id
        usersList.sort(Comparator.comparing(User::getId));
        return usersList;
    }

}
