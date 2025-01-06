package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static String dbURL = "jdbc:mysql://localhost:3306/preproject_1_1_3?" +
            "useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
    private static String dbUser = "root";
    private static String dbPass = "root";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String dialect = "org.hibernate.dialect.MySQL8Dialect";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.setProperties(getSettings());
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Ошибка при создании SessionFactory");
            }
        }
        return sessionFactory;
    }

    private static Properties getSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, driver);
        settings.put(Environment.URL, dbURL);
        settings.put(Environment.USER, dbUser);
        settings.put(Environment.PASS, dbPass);
        settings.put(Environment.DIALECT, dialect);
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "");
        return settings;
    }
}
