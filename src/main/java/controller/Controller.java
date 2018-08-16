package controller;

import domain.Laptop;
import domain.Lecture;
import domain.Student;

import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in);

    public void addNewStudent(){

        System.out.println("Add new Student");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("Student name: ");
        String name = scanner.next();

        Student student = new Student(name);

        System.out.println("Student's laptop name: ");
        String laptopName = scanner.next();

        Laptop laptop = new Laptop(laptopName);
        student.setLaptop(laptop);
        
        boolean lectureRun = true;
        do {
            System.out.println("Lecture: ");
            String lectureName = scanner.next();
            Lecture lecture = new Lecture(lectureName);

            System.out.println("Mark for " + lectureName + " : ");


        }while(lectureRun);



    }
}
