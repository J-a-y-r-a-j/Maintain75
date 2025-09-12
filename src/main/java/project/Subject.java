package project;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
public class Subject {
    String name;
    double theoryatt;
    double theorytot;
    double labatt;
    double labtot;
    double tutatt;
    double tuttot;
    double ovrallatt;

    Subject(String name, int theoryatt,int theorytot, int labatt,int labtot, int tutatt,int tuttot, int overallatt){
        this.name = name;
         this.theoryatt=   theoryatt;
        this.labatt =   labatt;
        this.tutatt = tutatt;
        this.theorytot = theorytot;
        this.labtot = labtot;
        this.tuttot = tuttot;
        this.ovrallatt = overallatt;

    }
    Subject(){}
    double calcoverallatt(ArrayList<Subject> subjects){
        Subject tempcn = subjects.get(0);
        Subject tempdaa = subjects.get(2);
        Subject tempsdam = subjects.get(1);
        double overallatt = tempcn.theoryatt+tempcn.labatt+tempcn.tutatt+tempdaa.theoryatt+tempdaa.labatt+tempdaa.tutatt+tempsdam.theoryatt+tempsdam.labatt+tempsdam.tutatt;
        double overalltot = tempcn.theorytot+tempcn.labtot+tempcn.tuttot+tempdaa.theorytot+tempdaa.labtot+tempdaa.tuttot+tempsdam.theorytot+tempsdam.labtot+tempsdam.tuttot;
        System.out.println(overallatt+"/"+overalltot);
        double overall = Math.round(((double) overallatt / overalltot) * 100 * 100.0) / 100.0;
        return overall;
    }
    public void attendingday(ArrayList<Subject> subjects, boolean pr){
        LocalDate today = LocalDate.now();
        if(pr) {
            System.out.println("Tommorow is " + today.getDayOfWeek().plus(3));
        }
        DayOfWeek day = today.getDayOfWeek().plus(3);
        Subject temp;
        switch(day){
            case MONDAY:
                temp = subjects.get(2);
                temp.theoryatt++;
                temp.theorytot++;
                temp = subjects.get(0);
                temp.theoryatt++;
                temp.theorytot++;
                temp = subjects.get(2);
                temp.labatt++;
                temp.labtot++;
                break;
            case TUESDAY:
                temp = subjects.get(1);
                temp.tutatt++;
                temp.tuttot++;
                temp = subjects.get(0);
                temp.theoryatt++;
                temp.theorytot++;
                temp = subjects.get(1);
                temp.theoryatt++;
                break;
            case WEDNESDAY:
                temp = subjects.get(1);
                temp.theoryatt++;
                temp.theorytot++;
                temp = subjects.get(2);
                temp.theoryatt++;
                temp.theorytot++;
                temp = subjects.get(0);
                temp.labatt++;
                temp.labtot++;
                break;
            case FRIDAY:
                temp = subjects.get(1);
                temp.labatt++;
                temp.labtot++;
                temp = subjects.get(0);
                temp.tutatt++;
                temp.tuttot++;
                temp = subjects.get(2);
                temp.tutatt++;
                temp.tuttot++;
                break;
        }
    }

    public void leaveday(ArrayList<Subject> subjects){
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek().plus(3);
        Subject temp;
        switch(day) {
            case MONDAY:
                temp = subjects.get(2);
                temp.theorytot++;
                temp = subjects.get(0);
                temp.theorytot++;
                temp = subjects.get(2);
                temp.labtot++;
                break;
            case TUESDAY:
                temp = subjects.get(1);
                temp.tuttot++;
                temp = subjects.get(0);
                temp.theorytot++;
                temp = subjects.get(1);
                temp.theorytot++;
                break;
            case WEDNESDAY:
                temp = subjects.get(1);
                temp.theorytot++;
                temp = subjects.get(2);
                temp.theorytot++;
                temp = subjects.get(0);
                temp.labtot++;
                break;
            case FRIDAY:
                temp = subjects.get(1);
                temp.labtot++;
                temp = subjects.get(0);
                temp.tuttot++;
                temp = subjects.get(2);
                temp.tuttot++;
                break;
        }
    }
}
