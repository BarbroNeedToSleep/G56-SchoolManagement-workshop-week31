package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course course;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        course = new Course("Java", LocalDate.now().plusDays(5), 5);
        student1 = new Student("Lina", "lina@example.com", "Katt Street");
        student2 = new Student("Alfred", "alfred@example.com", "Katt Street");
    }

    @Test
    void testCourseConstructorValid() {
        assertEquals("Java", course.getCourseName());
        assertEquals(5, course.getWeekDuration());
        assertTrue(course.getStartDate().isAfter(LocalDate.now()));
        assertTrue(course.getStudents().isEmpty());
    }

    @Test
    void testRegisterStudentAddsStudent() {
        course.register(student1);
        assertEquals(1, course.getStudents().size());
        assertTrue(course.getStudents().contains(student1));
    }

    @Test
    void testRegisterDuplicateStudentDoesNotAdd() {
        course.register(student1);
        course.register(student1);
        assertEquals(1, course.getStudents().size());
    }

    @Test
    void testUnregisterStudentRemovesStudent() {
        course.register(student1);
        course.unregister(student1);
        assertFalse(course.getStudents().contains(student1));
        assertTrue(course.getStudents().isEmpty());
    }

    @Test
    void testUnregisterNonexistentStudentDoesNothing() {
        course.register(student1);
        course.unregister(student2);
        assertEquals(1, course.getStudents().size());
    }

    @Test
    void testConstructorWithPastDateThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new Course("Java", LocalDate.now().minusDays(1), 5);
        });
        assertEquals("One should not create a course after it was suppose to start", ex.getMessage());
    }

}

