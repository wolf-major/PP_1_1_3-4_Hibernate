package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL," +
                "lastName VARCHAR(80) NOT NULL," +
                "age  TINYINT(3) NOT NULL)";

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sqlCreate).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Ошибка при создании таблицы");
        }
    }

    @Override
    public void dropUsersTable() {
        String sqlDrop = "DROP TABLE IF EXISTS users";

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sqlDrop).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Ошибка при удалении таблицы");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(new User(name, lastName, age));
            transaction.commit();
            System.out.printf("User с именем — %s добавлен в базу данных.\n", name);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении пользователя");
            assert transaction != null;
            transaction.rollback();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.get(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Ошибка при удалении пользователя");
            assert transaction != null;
            transaction.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        String sqlSelect = "SELECT id, name, lastName, age FROM users";
        List<User> usersArray = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sqlSelect).addEntity(User.class);
            usersArray = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Ошибка при получении списка пользователей");
        }
        return usersArray;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        String sqlDelete = "DELETE FROM users";

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sqlDelete).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Ошибка при очистке таблицы");
            assert transaction != null;
            transaction.rollback();
        }
    }
}
