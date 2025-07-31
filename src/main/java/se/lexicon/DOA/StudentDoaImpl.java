package se.lexicon.DOA;

import se.lexicon.model.Student;

import se.lexicon.DOA.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentDoaImpl implements StudentDAO {

    private List<Student> students = new ArrayList<>();


    @Override
    public Student save(Student student) {

        if (student == null){
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (!students.contains(student)) {
            students.add(student);
        }

        return student;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return List.of();
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Boolean delete(Student student) {
        return null;
    }
}