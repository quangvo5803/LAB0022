package Common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

import Model.Candidate;

public class Validation {
    static final Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}";
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    
    public static String getString(String prompt){
        System.out.print(prompt);
        String s =sc.nextLine();
        while(s.isEmpty()){
            System.out.print("Enter again(Can not blank): ");
            s = sc.nextLine();
        }
        return s;
    }
    
   public static int getInt(String prompt){
    int i = 0;
    boolean isValid = false;
    while (isValid == false){
        System.out.print(prompt);
        if (sc.hasNextInt()){
            i = sc.nextInt();
            isValid = true;
    } 
    else{
        System.out.println("Error! Invalid integer value. Try again.");
    }
        sc.nextLine();
    }
        return i;
   }
   public static int getInt(String prompt,int min, int max){
       int i = 0;
       boolean isValid = false;
       while (isValid == false){
           i= getInt(prompt);
           if (i<min)
               System.out.println("Error! Number must be greater than " + min + ".");
           else if(i> max){
               System.out.println("Error! Number must be less than " + max + ".");
           }
           else 
               isValid = true;
       }
          return i;
    }
   
   public static double getDouble(String prompt){
       double d =0;
       boolean isValid = false;
       while (isValid==false){
           System.out.print(prompt);
           if(sc.hasNextDouble()){
               d = sc.nextDouble();
               isValid = true;
           }
           else{
               System.out.println("Error! Invalid decimal value.Try again");
           }
           sc.nextLine();
       }
       return d;
    }
   
   public static double getDouble(String prompt,double min,double max){
       double d = 0;
       boolean isValid = false;
       while (isValid == false){
           d= getDouble(prompt);
           if (d<min)
               System.out.println("Error! Number must be greater than " + min + ".");
           else if(d> max){
               System.out.println("Error! Number must be less than " + max + ".");
           }
           else 
               isValid = true;
       }
          return d;
    }
   
    
    
    public static String getYesNo(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Y") || tmp.equalsIgnoreCase("N"))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Y/N)!");
            }

        } while (check);
        return result;
    }
    
    public static String getUD(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("U") || tmp.equalsIgnoreCase("D"))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (U/D)!");
            }

        } while (check);
        return result;
    }
    
    public static String getPhone() {
        while (true) {
            String result = getString("Enter phone number: ");
            //check user input phone valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
            }
        }
    }
    
    public static String getEmail() {
        //loop until user input correct
        while (true) {
            String result = getString("Enter email: ");
            //check user input email valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
            }
        }
    }
    
    public static String getGraduationRank() {
        while (true) {
            String result = getString("Enter graduation rank: ");
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }
    
    public static int getExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = getInt("Enter exprience: ",1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }
    
    public static String getSemester(){
       System.out.print("Enter semester(Spring, Summer, Fall): ");
       String s = sc.nextLine();
       while(!s.equalsIgnoreCase("spring") && ! s.equalsIgnoreCase("summer") && !s.equalsIgnoreCase("fall")){
           System.out.print("Enter course again (Spring, Summer, Fall): ");
           s = sc.nextLine();
       }
       return s;
   }
    
    public static String getID(){
        System.out.print("Enter ID: ");
        String s = sc.nextLine();
        Pattern p = Pattern.compile("[SEse]{2}[0-9]{6}");
        while(true){
            if(p.matcher(s).find()){
                break;
            }else{
                System.out.print("Enter id Student (SExxxxxx): ");
                s = sc.nextLine();
            }
        }
        return s;
    }
}
