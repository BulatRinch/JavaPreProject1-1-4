package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Vetrov", (byte)20);
        userService.saveUser("Alexandr", "Osipov", (byte)32);
        userService.saveUser("Anastasiya", "Petrova", (byte)21);
        userService.saveUser("Olga", "Kashina", (byte)33);

        List<User> allUsers= userService.getAllUsers();
        for (User i:allUsers) {
            System.out.println(i);
        }
       userService.cleanUsersTable();
       userService.dropUsersTable();


    }
}
