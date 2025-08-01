package se.lexicon.DOA;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDoaImpl implements CourseDOA{

    private List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course findById(Integer course) {
        return null;
    }

    @Override
    public List<Course> findByName(String course) {
        return List.of();
    }

    @Override
    public List<Course> findByDate(LocalDate course) {
        return List.of();
    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }

    @Override
    public Boolean delete(Course course) {
        return null;
    }
}
