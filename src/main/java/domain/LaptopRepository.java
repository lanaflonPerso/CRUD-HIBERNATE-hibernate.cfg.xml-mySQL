package domain;

import hibernate.utils.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class LaptopRepository implements RepositoryInterface {

    public static void listAll(){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            List<Laptop> listLaptops = session.createQuery("SELECT c FROM laptops c").getResultList();

            if (listLaptops == null) {
                System.out.println("No laptop found!");
            } else {
                for (Laptop laptop : listLaptops) {
                    System.out.println(laptop.toString());
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

    public static void listById(int laptopId){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            try{
                Laptop laptopById = session.find(Laptop.class, laptopId);
                System.out.println(laptopById);
            } catch (NullPointerException e){
                System.out.println("No laptop with id: " + laptopId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void addNew(Laptop laptop){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(laptop);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void editExisting(Laptop laptopToUpdate){
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.getTransaction().begin();
            session.merge(laptopToUpdate);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void deleteById(int laptopIdToDelete){
        Session session = null;
        try {
            session = HibernateUtils.openSession();

            Laptop contactToDelete = session.find(Laptop.class, laptopIdToDelete);
            System.out.println(contactToDelete);

            session.getTransaction().begin();
            session.remove(contactToDelete);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static void dropTable() {
        Session session = null;
        try {
            session = HibernateUtils.openSession();
            session.createSQLQuery("DROP TABLE laptops").executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
