package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("Alex", "Nesterov", (byte) 21);
        userDao.saveUser("Kate", "Smith", (byte) 35);
        userDao.saveUser("Lola", "Winter", (byte) 21);
        userDao.saveUser("James", "Pupkin", (byte) 55);

        System.out.println(userDao.getAllUsers().toString());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }

}
