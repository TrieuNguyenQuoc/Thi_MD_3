package modle;

public class Student {
    private int id;
    private String name;
    private String email;
    private String birth;
    private String address;
    private String phone;
    private int classroom;

    public Student (int id, String name, String email, String birth, String address, String phone, int classroom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.classroom = classroom;
    }

    public int getId ( ) {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getBirth ( ) {
        return birth;
    }

    public void setBirth (String birth) {
        this.birth = birth;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getPhone ( ) {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public int getClassroom ( ) {
        return classroom;
    }

    public void setClassroom (int classroom) {
        this.classroom = classroom;
    }

}
