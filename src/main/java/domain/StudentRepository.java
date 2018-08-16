package domain;

import hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class StudentRepository implements RepositoryInterface{

    public static void listAll(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            List<Student> listStudents = session.createQuery("SELECT c FROM students c").getResultList();

            if (listStudents == null) {
                System.out.println("No students found!");
            } else {
                for (Student student : listStudents) {
                    System.out.println(student.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void listById(int studentId){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            try{
                Mark markById = session.find(Mark.class, studentId);
                System.out.println(markById);
            } catch (NullPointerException e){
                System.out.println("No student with id: " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void addNew(Student student){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void editExisting(Student studentToUpdate){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(studentToUpdate);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void deleteById(int studentIdToDelete){
        Session session = null;
        try {
            session = HibernateUtils.openSession();

            Student studentToDelete = session.find(Student.class, studentIdToDelete);
            System.out.println(studentToDelete);

            session.getTransaction().begin();
            session.remove(studentToDelete);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void dropTable(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.createSQLQuery("DROP TABLE students").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
