package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int courseCounter = 0;

    private int id;
    private String courseName;
    private LocalDate startDate;
    private Integer weekDuration;
    private List<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration) {

        this.id = ++courseCounter;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();

    }

    // Getter


    public int getId (){
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    //Setters

    private void setCourseName(String courseName) {
        if (courseName == null|| courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        this.courseName = courseName;
    }

    private void setStartDate(LocalDate startDate) {
        if (startDate== null){
            throw new IllegalArgumentException("Start date cannot be left empty");
        }

        if (startDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("One should not create a course after it was suppose to start");
        }
        this.startDate = startDate;
    }

    private void setWeekDuration(Integer weekDuration) {

        if (weekDuration == null || weekDuration <= 0){
            throw new IllegalArgumentException("Duration of course cannot be left empty");
        }
        this.weekDuration = weekDuration;
    }


    public void register(Student student) {
        if (student== null){
            throw new IllegalArgumentException("Student cannot be left empty");
        }

        if (!this.students.contains(student)) {
            this.students.add(student);
        }

        else System.out.println("The student already exist in the course");
    }

    public void unregister(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be left empty");
        }

        if (students.remove(student)) {
            System.out.println("Student has been removed from the course.");

        } else {
            System.out.println("Student was not found in the course.");
        }

    }

    @Override
    public String toString() {
        return "Course id=" + id + ", courseName= " + courseName + ", startDate=" + startDate + ", weekDuration=" + weekDuration + " weeks" +
                ", studentsCount=" + students.size();
    }

    public String coursesStudentsToString() {
        if (students.isEmpty()) {
            return "No students are enrolled in this course.";
        }

        StringBuilder courseStudents = new StringBuilder("Enrolled students:\n");
        for (Student student : students) {
            courseStudents.append(" - ").append(student).append("\n");
        }
        return courseStudents.toString();
    }

}
