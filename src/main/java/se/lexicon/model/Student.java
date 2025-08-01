package se.lexicon.model;

public class Student {

    private static int personIdCounter = 0;

    private int id;
    private String name;
    private String email;
    private String address;

    public Student(String name, String email, String address) {
        this.id = ++personIdCounter;
        setName(name);
        setEmail(email);
        setAddress(address);

    }

    // Getters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Setter


    private void setName(String name) {

        if (name == null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
    }

    private void setEmail(String email) {

        if (email == null|| email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        this.email = email;
    }

    private void setAddress(String address) {

        if (address == null|| address.trim().isEmpty()){
            throw new IllegalArgumentException("Address cannot be null or empty");
        }

        this.address = address;
    }

    @Override
    public String toString() {
        return "Student id= " + id + ", name= " + name + ", email= " + email;
    }
}
