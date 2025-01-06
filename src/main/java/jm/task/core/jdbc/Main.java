package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Alex", "Nesterov", (byte) 21);
        userService.saveUser("Kate", "Smith", (byte) 35);
        userService.saveUser("Lola", "Winter", (byte) 21);
        userService.saveUser("James", "Pupkin", (byte) 55);

        System.out.println(userService.getAllUsers().toString());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
