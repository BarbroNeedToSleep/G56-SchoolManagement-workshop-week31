package se.lexicon.DOA;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentDAO {

    Student save (Student student);

    Student findByEmail (String email);

    List<Student> findByName(String name);

    Student findById (Integer id);

    List<Student> findAll();

    Boolean delete(Student student);


}
