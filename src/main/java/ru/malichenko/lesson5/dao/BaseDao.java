package ru.malichenko.lesson5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.malichenko.lesson5.utils.HibernateSessionFactory;

import javax.persistence.Entity;
import java.io.Serializable;

public class BaseDao <T,ID>{
    private final SessionFactory factory = HibernateSessionFactory.getSessionFactory();
    private Class<T> classT;
    private ID id;
    private String className;

    public BaseDao() {
    }

    public BaseDao(Class<T> classT) {
        if (!classT.isAnnotationPresent(Entity.class)) {
        throw new RuntimeException(classT.toString() + " does not Entity");
        }
        this.classT = classT;
        this.className = classT.toString();
    }

    public BaseDao(Class<T> classT, ID id) {
        if (!classT.isAnnotationPresent(Entity.class)) {
            throw new RuntimeException(classT.toString() + " does not Entity");
        }
        this.classT = classT;
        this.id = id;
        this.className = classT.toString();
    }

    public void persist(T entity) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public T findById(ID id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        T entity = (T) session.get(className, (Serializable) id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void delete(T entity) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }
}
