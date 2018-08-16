import domain.*;
import hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.persistence.TypedQuery;
import java.util.List;

public class FunctionalityTest {

    @Test
    public static void shouldAddNewStudent() {

        String studentName = "Jon";
        Student student = new Student(studentName);
        String laptopName = "Lenovo ThinkPad";
        Laptop laptop = new Laptop(laptopName);
        student.setLaptop(laptop);
        String lectureName1 = "Astronomy";
        String lectureName2 = "History";
        Lecture lecture1 = new Lecture(lectureName1);
        Lecture lecture2 = new Lecture(lectureName2);
        student.getLectures().add(lecture1);
        student.getLectures().add(lecture2);
        lecture1.getStudents().add(student);
        lecture2.getStudents().add(student);
        double grade1 = 3.5;
        double grade2 = 4.5;
        Mark mark1 = new Mark(grade1);
        Mark mark2 = new Mark(grade2);
        mark1.setStudent(student);
        mark2.setStudent(student);

        StudentRepository.addNew(student);

        String customQueryFindJon = "select s from Student s where s.studentName = :studentName";

        Session session = null;

        try {
            session = HibernateUtils.openSession();

            TypedQuery<Student> foundJon = session.createQuery(customQueryFindJon, Student.class);
            foundJon.setParameter("firstName", studentName);

            List<Student> results = foundJon.getResultList();

            Student jonObject = results.get(0);

            int idToDelete = jonObject.getStudentId();

            Assertions.assertNotEquals(null, foundJon);

            StudentRepository.deleteById(idToDelete);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
