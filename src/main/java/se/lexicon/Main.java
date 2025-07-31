package se.lexicon;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Student alice = new Student("Alice", "alice@example.com", "Wonderland");
        Student bob = new Student("Bob", "bob@example.com", "Builder Street");

        Course java = new Course("Java", LocalDate.now().plusDays(1), 6);

        java.register(alice);
        java.register(bob);
        java.register(alice); // Duplicate test

        System.out.println("\nStudents in " + java.getCourseName() + ":");
        for (Student s : java.getStudents()) {
            System.out.println("- " + s);
        }

        java.unregister(bob);
        java.unregister(bob); // Already removed test
    }



}