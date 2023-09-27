package logic;

import database.UserDatabase;
import ir.sharif.ap.hw4.model.User;

import java.util.Objects;

public class UserController {

    public boolean isUsernameRepeated(String username) {
        for (User user : UserDatabase.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User createUser(String username, String password) {
        User newUser = new User(username, password);
        UserDatabase.getUsers().add(newUser);
        UserDatabase.saveChanges();
        return newUser;
    }

    public User getUser(String username) {
        for (User user : UserDatabase.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean isUserValid(String username, String password) {
        return isUsernameRepeated(username) && Objects.requireNonNull(getUser(username)).getPassword().equals(password);
    }
}