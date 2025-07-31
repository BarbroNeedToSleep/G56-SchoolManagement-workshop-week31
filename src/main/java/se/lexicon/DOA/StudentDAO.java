package se.lexicon.DOA;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentDAO {

    Student save (Student student);

    Student findByEmail (Student email);

    List<Student> findByName(Student name);

    Student findById (Student id);

    List<Student> findAll();

    Boolean delete(Student student);


}
