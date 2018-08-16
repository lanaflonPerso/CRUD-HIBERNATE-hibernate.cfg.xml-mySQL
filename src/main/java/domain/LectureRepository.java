package domain;

import hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class LectureRepository implements RepositoryInterface {

    public static void listAll(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            List<Lecture> listLectures = session.createQuery("SELECT c FROM lectures c").getResultList();

            if (listLectures == null) {
                System.out.println("No lectures found!");
            } else {
                for (Lecture lecture : listLectures) {
                    System.out.println(lecture.toString());
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

    public static void listById(int lectureId){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            try{
                Laptop laptopById = session.find(Laptop.class, lectureId);
                System.out.println(laptopById);
            } catch (NullPointerException e){
                System.out.println("No lecture with id: " + lectureId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void addNew(Lecture lecture){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(lecture);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void editExisting(Lecture lectureToUpdate){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(lectureToUpdate);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void deleteById(int lectureIdToDelete){
        Session session = null;
        try {
            session = HibernateUtils.openSession();

            Lecture lectureToDelete = session.find(Lecture.class, lectureIdToDelete);
            System.out.println(lectureToDelete);

            session.getTransaction().begin();
            session.remove(lectureToDelete);
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
            session.createSQLQuery("DROP TABLE lectures").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
