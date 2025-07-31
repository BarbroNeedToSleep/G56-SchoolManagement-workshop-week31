package se.lexicon.DOA;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

public interface CourseDOA {

    Course save (Course course);

    Course findById(Course course);

    List<Course> findByName(Course course);

    List<Course> findByDate(Course course);

    List<Course> findAll();

    Boolean delete(Course course);


}
