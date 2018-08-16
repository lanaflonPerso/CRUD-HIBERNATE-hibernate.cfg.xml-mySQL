package domain;

import hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class MarkRepository implements RepositoryInterface {

    public static void listAll(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            List<Mark> listMarks = session.createQuery("SELECT c FROM marks c").getResultList();

            if (listMarks == null) {
                System.out.println("No marks found!");
            } else {
                for (Mark mark : listMarks) {
                    System.out.println(mark.toString());
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

    public static void listById(int markId){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            try{
                Mark markById = session.find(Mark.class, markId);
                System.out.println(markById);
            } catch (NullPointerException e){
                System.out.println("No lecture with id: " + markId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void addNew(Mark mark){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(mark);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void editExisting(Mark markToUpdate){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(markToUpdate);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void deleteById(int markIdToDelete){
        Session session = null;
        try {
            session = HibernateUtils.openSession();

            Lecture lectureToDelete = session.find(Lecture.class, markIdToDelete);
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
            session.createSQLQuery("DROP TABLE marks").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
