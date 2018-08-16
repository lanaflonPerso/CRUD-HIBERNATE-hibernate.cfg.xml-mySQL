import domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

// https://www.youtube.com/watch?v=8mUPvdDGoLQ&t=625s

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

//        do{
//
//            LaptopRepository.dropTable();
//
//            run=false;
//
//        }while(run);


//        // Laptop
//        Laptop laptop = new Laptop();
//        laptop.setLaptopId(101);
//        laptop.setLaptopName("Dell");
//
//        // Lecture
//        Lecture lecture1 = new Lecture();
//        lecture1.setLectureName("History");
//        Lecture lecture2 = new Lecture();
//        lecture2.setLectureName("Astronomy");
//
//        // Mark
//        Mark mark1 = new Mark();
//        mark1.setMark(4.5);
//        Mark mark2 = new Mark();
//        mark2.setMark(3);
//
//        // Student
//        Student student = new Student();
//        student.setStudentName("Navin");
//        student.setLaptop(laptop);
//        student.getLectures().add(lecture1);
//        student.getLectures().add(lecture2);
//        student.getMarks().add(mark1);
//        student.getMarks().add(mark2);
//
//        // Lecture
//        lecture1.getStudents().add(student);
//        lecture2.getStudents().add(student);
//
//        // Mark
//        mark1.setStudent(student);
//        mark2.setStudent(student);
//
//        // ------------------------------------------------
//
//        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//
//        session.save(laptop);
//        session.save(student);
//        session.save(lecture1);
//        session.save(lecture2);
//        session.save(mark1);
//        session.save(mark2);
//
//        session.getTransaction().commit();
//
//
//        System.out.println("press to drop");
//        Scanner sc = new Scanner(System.in);
//        sc.next();
//
//        session.close();
//        sessionFactory.close();



    }
}
