package Model;

public class Experiance extends Candidate{
    private int yearExperience;
    private String skill;

    public Experiance() {
        super();
    }

    public Experiance(String id, String firstName, String lastName, int birthday, String address, String phone, String mail, int type,int yearExperience, String skill) {
        super(id, firstName, lastName, birthday, address, phone, mail, type);
        this.yearExperience = yearExperience;
        this.skill = skill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    
}
