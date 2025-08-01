package se.lexicon.DOA;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDoaImpl implements CourseDOA{

    private List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) {
        if (course == null){
            throw new IllegalArgumentException("Course cannot be null");
        }

        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course saved: " + course);
        } else {
            System.out.println("Course already exists: " + course);
        }

        return course;
    }

    @Override
    public Course findById(Integer id) {

        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id cannot be null or negative.");
        }
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        System.out.println("No course found with that id.");

        return null;
    }

    @Override
    public List<Course> findByName(String courseName) {

        if (courseName == null || courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }

        List<Course> result = new ArrayList<>();
        String searchByCourseName = courseName.trim();

        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(searchByCourseName)) {
                result.add(course);
            }

        }
        if (result.isEmpty()) {
            System.out.println("No courses found with that name.");
        }
        return result;

    }

    @Override
    public List<Course> findByDate(LocalDate date) {

        if(date == null){
            throw new IllegalArgumentException("Date is not allowed to be null.");
        }
        List<Course> result = new ArrayList<>();

        for (Course course : courses) {
            if (course.getStartDate().equals(date)) {
                result.add(course);
            }
        }
        return result;

    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public Boolean delete(Course course) {

        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }

        boolean removed = courses.remove(course);

        if (removed) {
            System.out.println("Course was removed: "+ course);
        } else {
            System.out.println("Course was not found: "+ course);
        }

        return removed;
    }

}
