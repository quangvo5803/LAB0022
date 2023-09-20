package Model;

public class Intership extends Candidate {
    private String major;
    private String semester;
    private String university;

    public Intership() {
        super();
    }

    public Intership(String id, String firstName, String lastName, int birthday, String address, String phone, String mail, int type,String major, String semester, String university) {
        super(id, firstName, lastName, birthday, address, phone, mail, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    
}
