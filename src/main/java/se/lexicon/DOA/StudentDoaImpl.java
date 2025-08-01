package se.lexicon.DOA;

import se.lexicon.model.Student;

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

        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        String trimEmail = email.trim();

        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(trimEmail)) {
                return student;

            }
        }
        System.out.println("No student found.");
        return null;

    }

    @Override
    public List<Student> findByName(String name) {

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        List<Student> result = new ArrayList<>();
        String searchByName = name.trim();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchByName)) {
                result.add(student);
            }

        }
        if (result.isEmpty()) {
            System.out.println("No students found with that name.");
        }
        return result;
    }

    @Override
    public Student findById(Integer id) {

        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id cannot be null or negative.");
        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("No student found with that id.");
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Boolean delete(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        boolean removed = students.remove(student);

        if (removed) {
            System.out.println("Student was removed: "+ student);
        } else {
            System.out.println("Student was not found: "+ student);
        }

        return removed;
    }
}