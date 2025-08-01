package se.lexicon.DOA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDoaImplTest {

    private StudentDoaImpl studentDao;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        studentDao = new StudentDoaImpl();
        student1 = new Student("Lina", "lina@example.com", "Katt Street");
        student2 = new Student("Alfred", "alfred@example.com", "Main Road");
    }

    @Test
    void saveAddsStudent() {
        Student saved = studentDao.save(student1);
        assertEquals(student1, saved);
        assertEquals(1, studentDao.findAll().size());
    }

    @Test
    void saveDoesNotAddDuplicate() {
        studentDao.save(student1);
        studentDao.save(student1);
        assertEquals(1, studentDao.findAll().size());
    }

    @Test
    void saveNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> studentDao.save(null));
    }

    @Test
    void findByEmailReturnsStudent() {
        studentDao.save(student1);
        Student found = studentDao.findByEmail("lina@example.com");
        assertEquals(student1, found);
    }

    @Test
    void findByEmailNoMatchReturnsNull() {
        studentDao.save(student1);
        Student found = studentDao.findByEmail("notfound@example.com");
        assertNull(found);
    }

    @Test
    void findByEmailNullOrEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByEmail(null));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByEmail(""));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByEmail("   "));
    }

    @Test
    void findByNameReturnsStudents() {
        studentDao.save(student1);
        studentDao.save(student2);
        List<Student> found = studentDao.findByName("Lina");
        assertEquals(1, found.size());
        assertTrue(found.contains(student1));
    }

    @Test
    void findByNameNoMatchReturnsEmptyList() {
        studentDao.save(student1);
        List<Student> found = studentDao.findByName("Unknown");
        assertTrue(found.isEmpty());
    }

    @Test
    void findByNameNullOrEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByName(null));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByName(""));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findByName("   "));
    }

    @Test
    void findByIdReturnsStudent() {
        studentDao.save(student1);
        Student found = studentDao.findById(student1.getId());
        assertEquals(student1, found);
    }

    @Test
    void findByIdNoMatchReturnsNull() {
        studentDao.save(student1);
        Student found = studentDao.findById(999);
        assertNull(found);
    }

    @Test
    void findByIdNullOrInvalidThrows() {
        assertThrows(IllegalArgumentException.class, () -> studentDao.findById(null));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findById(-1));
        assertThrows(IllegalArgumentException.class, () -> studentDao.findById(0));
    }

    @Test
    void findAllReturnsAllStudents() {
        studentDao.save(student1);
        studentDao.save(student2);
        List<Student> all = studentDao.findAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(student1));
        assertTrue(all.contains(student2));
    }

    @Test
    void deleteExistingStudentRemovesAndReturnsTrue() {
        studentDao.save(student1);
        boolean deleted = studentDao.delete(student1);
        assertTrue(deleted);
        assertTrue(studentDao.findAll().isEmpty());
    }

    @Test
    void deleteNonExistingStudentReturnsFalse() {
        studentDao.save(student1);
        boolean deleted = studentDao.delete(student2);
        assertFalse(deleted);
        assertEquals(1, studentDao.findAll().size());
    }

    @Test
    void deleteNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> studentDao.delete(null));
    }
}