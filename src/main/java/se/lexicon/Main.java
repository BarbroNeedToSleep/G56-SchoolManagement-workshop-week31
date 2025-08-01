package se.lexicon;

import se.lexicon.DOA.CourseDoaImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;
import se.lexicon.DOA.StudentDoaImpl;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentDoaImpl studentDao = new StudentDoaImpl();
        CourseDoaImpl courseDao = new CourseDoaImpl();

        Student lina = new Student("Lina", "lina@example.com", "Katt Street");
        Student alfred = new Student("Alfred", "Alfred@test.com", "Katt Street");

        System.out.println(lina.toString());

        Course java = new Course("Java", LocalDate.now().plusDays(5), 5);
        Course css = new Course("CSS", LocalDate.now().plusDays(5), 2);
        Course sql = new Course("SQL", LocalDate.now().plusDays(5), 3);

        System.out.println(css.toString());

        courseDao.save(java);
        courseDao.save(css);
        courseDao.save(sql);
        courseDao.save(java); // Duplicate test

        java.register(lina);
        java.register(alfred);
        java.register(lina); // Duplicate test


        java.unregister(alfred);
        java.unregister(alfred); // Already removed test

        css.register(lina);

        System.out.println(java.coursesStudentsToString());

        System.out.println(css.coursesStudentsToString());

        studentDao.save(lina);
        studentDao.save(alfred);
        studentDao.save(lina);

        // Find student by email
        Student found = studentDao.findByEmail("lina@example.com");
        System.out.println("Found student by email: " + found);

        // Find students by name
        List<Student> foundByName = studentDao.findByName("Lina");
        System.out.println("Found students by name 'Lina': " + foundByName);

        // Delete a student
        studentDao.delete(alfred);

        // List all students
        System.out.println("All students:");
        for (Student student : studentDao.findAll()) {
            System.out.println(student);
        }

        Course foundById = courseDao.findById(java.getId());
        System.out.println("Found by ID: " + foundById);

        // Find by name
        List<Course> foundByCoursesName = courseDao.findByName("Java");
        System.out.println("Found by name 'Java':");
        for (Course course : foundByCoursesName) {
            System.out.println(course);
        }

        // Find by date
        List<Course> foundByDate = courseDao.findByDate(LocalDate.now().plusDays(5));
        System.out.println("Courses starting in 5 days:");
        for (Course course : foundByDate) {
            System.out.println(course);
        }

        // Delete a course
        courseDao.delete(css);

        // List all courses
        System.out.println("All current courses:");
        for (Course course : courseDao.findAll()) {
            System.out.println(course);
        }
    }

}