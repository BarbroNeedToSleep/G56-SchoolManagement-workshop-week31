package se.lexicon.DOA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDoaImplTest {

    private CourseDoaImpl courseDao;
    private Course course1;
    private Course course2;

    @BeforeEach
    void setUp() {
        courseDao = new CourseDoaImpl();
        course1 = new Course("Java", LocalDate.now().plusDays(5), 5);
        course2 = new Course("CSS", LocalDate.now().plusDays(10), 2);
    }


    @Test
    void saveAddNewCourse() {
        Course saved = courseDao.save(course1);
        assertEquals(course1, saved);
        assertEquals(1, courseDao.findAll().size());
    }

    @Test
    void saveDoNotAddDuplicate() {
        courseDao.save(course1);
        courseDao.save(course1);
        assertEquals(1, courseDao.findAll().size());
    }

    @Test
    void findByIdValidIdReturnCourse() {
        courseDao.save(course1);
        Course found = courseDao.findById(course1.getId());
        assertEquals(course1, found);
    }

    @Test
    void findByIdNonExistingShouldReturnNull() {
        courseDao.save(course1);
        Course found = courseDao.findById(999);
        assertNull(found);
    }

    @Test
    void findByNameValidNameReturnCourses() {
        courseDao.save(course1);
        courseDao.save(course2);
        List<Course> found = courseDao.findByName("java");
        assertEquals(1, found.size());
        assertTrue(found.contains(course1));
    }

    @Test
    void findByNameNoMatchReturnEmptyList() {
        courseDao.save(course1);
        List<Course> found = courseDao.findByName("Python");
        assertTrue(found.isEmpty());
    }

    @Test
    void findByDateValidDateReturnCourses() {
        courseDao.save(course1);
        courseDao.save(course2);
        List<Course> found = courseDao.findByDate(course1.getStartDate());
        assertEquals(1, found.size());
        assertTrue(found.contains(course1));
    }

    @Test
    void findByDateNoMatchReturnEmptyList() {
        courseDao.save(course1);
        List<Course> found = courseDao.findByDate(LocalDate.now().plusDays(100));
        assertTrue(found.isEmpty());
    }

    @Test
    void findAllReturnAllCourses() {
        courseDao.save(course1);
        courseDao.save(course2);
        List<Course> all = courseDao.findAll();
        assertEquals(2, all.size());
        assertTrue(all.contains(course1));
        assertTrue(all.contains(course2));
    }

    @Test
    void deleteExistingCourseRemoveAndReturnTrue() {
        courseDao.save(course1);
        boolean deleted = courseDao.delete(course1);
        assertTrue(deleted);
        assertTrue(courseDao.findAll().isEmpty());
    }

    @Test
    void deleteNonExistingCourseReturnFalse() {


        courseDao.save(course1);
        boolean deleted = courseDao.delete(course2);
        assertFalse(deleted);
        assertEquals(1, courseDao.findAll().size());
    }



}
