package ru.malichenko.lesson5.dao;

import ru.malichenko.lesson5.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.malichenko.lesson5.utils.HibernateSessionFactory;

import java.util.List;

public class StudentDao extends BaseDao<Student, Long>{
    private final SessionFactory factory = HibernateSessionFactory.getSessionFactory();

    public StudentDao() {
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = (List<Student>) session.createQuery("from Student").list();
        session.getTransaction().commit();
        session.close();
        return students;
    }

    public void deleteAll() {
        List<Student> entityList = findAll();
        for (Student entity : entityList) {
            delete(entity);
        }
    }
}
