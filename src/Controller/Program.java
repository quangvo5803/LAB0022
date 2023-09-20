package Controller;

import java.util.ArrayList;
import java.util.Calendar;

import Common.Validation;
import Model.Candidate;
import Model.Experiance;
import Model.Fresher;
import Model.Intership;
import View.Menu;

public class Program extends Menu<String> {
    static String[] menuChoice = {"Experience","Fresher","Intership","Searching","Exit"};
    ArrayList<Candidate> candidates;
    
    public Program(){
        super("Candidate Management System",menuChoice);
        candidates = new ArrayList<>();
    }

    //------------------------------------------------------------------------
    @Override
    public void execute(int n){
        switch (n){
            case 1:{
                createCandidate(candidates, 0);
                break;
            }
            case 2:{
                createCandidate(candidates, 1);
                break;
            }
            case 3:{
                createCandidate(candidates, 2);
                break;
            }
            case 4:{
                search(candidates);
                break;
            }
            case 5:{
                System.exit(0);
            }
        }
    }

    public void createCandidate(ArrayList<Candidate> candidates,int type){
        while(true){
            System.out.println();
            String id = Validation.getID();
            String firstName = Validation.getString("Enter first name: ");
            String lastName = Validation.getString("Enter last name: ");
            int birthday = Validation.getInt("Enter birth date: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = Validation.getString("Enter address: ");
            String phone = Validation.getPhone();
            String email = Validation.getEmail();
            Candidate c = new Candidate(id, firstName, lastName, birthday, address, phone, email, type);
            
            if(Validation.checkIdExist(candidates, id)){
                switch(type){
                    case 0:{
                        createExperience(candidates,c);
                        break;
                    }
                    case 1:{
                        createFresher(candidates,c);
                        break;
                    }
                    case 2:{
                        createIntership(candidates,c);
                        break;
                    }
                }
            }
            else{
                System.out.println("Id has exist");
                break;
            }
            
            if(!Validation.getYesNo("Do you want to continue(Y,N): ").equalsIgnoreCase("Y")){
                break;
            }
        }
    }
    
    public void createExperience(ArrayList<Candidate> candidates,Candidate candidate){
        int yearExperience = Validation.getExprience(candidate.getBirthday());
        String skill = Validation.getString("Enter skill: ");
        candidates.add(new Experiance(candidate.getId(),candidate.getFirstName(),candidate.getLastName(),
                candidate.getBirthday(),candidate.getAddress(),candidate.getPhone(),candidate.getMail(),
                candidate.getType(),yearExperience,skill));
        System.out.println("---------------Create success---------------");
        
    }
    
    public void createFresher(ArrayList<Candidate> candidates,Candidate candidate){
        String graduationDate = Validation.getString("Enter graduation date: ");
        String graduationRank = Validation.getGraduationRank();
        candidates.add(new Fresher(candidate.getId(),candidate.getFirstName(),candidate.getLastName(),
                candidate.getBirthday(),candidate.getAddress(),candidate.getPhone(),candidate.getMail(),
                candidate.getType(),graduationDate,graduationRank));
        System.out.println("---------------Create success---------------");
        
    }
    
    public void createIntership(ArrayList<Candidate> candidates,Candidate candidate){
        String major = Validation.getString("Enter major: ");
        String semester = Validation.getSemester();
        String university = Validation.getString("Enter university: ");
        candidates.add(new Intership(candidate.getId(),candidate.getFirstName(),candidate.getLastName(),
                candidate.getBirthday(),candidate.getAddress(),candidate.getPhone(),candidate.getMail(),
                candidate.getType(),major,semester,university));
        System.out.println("---------------Create success---------------");
        
    }
    
    public void search(ArrayList<Candidate> candidates){
        
        System.out.println("---------------------------------------------");
        if(candidates.isEmpty()){
            System.out.println("---------------List empty---------------");
            return;
        }
        printListNameCandidate(candidates);
        String nameSearch = Validation.getString("Enter name to search(First name or Last name): ");
        int count = 0;
        int type = Validation.getInt("Enter type of candidate: ", 0, 2);
        for(Candidate c:candidates){
            if(c.getType() == type && c.getFirstName().contains(nameSearch) || c.getLastName().contains(nameSearch)){
                System.out.println(c.toString());
                count++;
            }
        }
        if(count ==0){
            System.out.println("Cannot found");
        }
    }
    
    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("---------------Experience Candidate---------------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experiance) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("---------------Fresher Candidate---------------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("---------------Internship Candidate---------------");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Intership) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        
        System.out.println("---------------------------------------------");
    }
}
    