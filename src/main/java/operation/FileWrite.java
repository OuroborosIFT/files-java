package operation;

import model.User;
import repository.FileWriteRepository;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class FileWrite implements FileWriteRepository {

    private final File file;

    public FileWrite(File file) {
        this.file = file;
    }

    public FileWrite(String filePath) {
        file = new File(filePath);
    }


    @Override
    public void writeFile(List<User> usersList) {
        // Сортируем пользователей в порядке возрастания id
        usersList.sort(Comparator.comparing(User::getId));

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (User user : usersList) {
                bufferedWriter.write(user.writeToFile() + "\n");
                bufferedWriter.flush();
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
            throw new RuntimeException("Unable to write data to file");
        }
    }

}
