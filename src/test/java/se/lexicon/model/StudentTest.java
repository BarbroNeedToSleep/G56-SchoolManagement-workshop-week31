package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Lina", "lina@example.com", "Katt Street");
    }

    @Test
    void testStudentIsCreatedWithValidValues() {
        Student student = new Student("Lina", "lina@example.com", "Katt Street");

        assertEquals("Lina", student.getName());
        assertEquals("lina@example.com", student.getEmail());
        assertEquals("Katt Street", student.getAddress());
        assertTrue(student.getId() > 0);
    }

}
