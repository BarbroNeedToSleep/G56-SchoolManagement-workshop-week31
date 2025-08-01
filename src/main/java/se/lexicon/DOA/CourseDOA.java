package se.lexicon.DOA;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

public interface CourseDOA {

    Course save (Course course);

    Course findById(Integer course);

    List<Course> findByName(String course);

    List<Course> findByDate(LocalDate course);

    List<Course> findAll();

    Boolean delete(Course course);


}
