package ru.malichenko.lesson5;

import ru.malichenko.lesson5.entity.Student;
import ru.malichenko.lesson5.dao.StudentDao;
import ru.malichenko.lesson5.utils.HibernateSessionFactory;

public class AppMain {

    public static void main(String[] args) {
        try {
            StudentDao studentDao = new StudentDao();
            for (int i = 0; i < 100; i++) {
                Student student = new Student();
                student.setName("Nick " + i);
                student.setMark("mark " + (100 - i));
                studentDao.persist(student);
                System.out.println(student);
            }
            System.out.println(studentDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateSessionFactory.shutdown();
        }
    }
}
