package database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.sharif.ap.hw4.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class UserDatabase {

    private final static LinkedList<User> users = new LinkedList<>();
    private final static String path = ".\\src\\main\\resources\\userDB";
    private final static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static LinkedList<User> getUsers() {
        return users;
    }

    public static void saveChanges() {
        File saveAddress = new File(path);
        for (File file : saveAddress.listFiles()) {
            file.delete();
        }
        File save = new File(path + "\\users");
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(save));
            for (User user : users) {
                printStream.println(gson.toJson(user));
            }
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() throws FileNotFoundException {
        File file = new File(path + "\\users");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            int maxId = 0;
            while (scanner.hasNext()){
                User currentUser = gson.fromJson(scanner.nextLine(), User.class);
                users.add(currentUser);
                if (currentUser.getId() > maxId) {
                    maxId = currentUser.getId();
                }
            }
            User.setLastId(maxId);
            scanner.close();
        }
    }

}