import java.time.DayOfWeek;
import java.util.Scanner;
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
    void calcsubatt(Subject sub){
        //System.out.println(sub.name+" "+sub.theoryatt+" "+ sub.theorytot+" "+sub.labatt+" "+sub.labtot+" "+sub.tutatt+" "+sub.tuttot+" "+sub.ovrallatt);
        double theorypercentage = Math.round(((double) sub.theoryatt / sub.theorytot) * 10000.0) / 100.0;
        double labpercentage = Math.round(((double) sub.labatt / sub.labtot) * 10000.0) / 100.0;
        double tutpercentage = Math.round(((double) sub.tutatt / sub.tuttot) * 10000.0) / 100.0;
        sub.ovrallatt = Math.round((theorypercentage+labpercentage+tutpercentage)/3);
        System.out.println("Theory Percentage "+theorypercentage);
        System.out.println("Lab Percentage "+labpercentage);
        System.out.println("Tut Percentage"+tutpercentage);
        System.out.println("Overall Percentage "+ sub.ovrallatt);
    }
    public void attendingday(ArrayList<Subject> subjects){
        LocalDate today = LocalDate.now();
        JDBC jd = new JDBC();
        System.out.println("Today"+today.getDayOfWeek());
        DayOfWeek day = today.getDayOfWeek();
        Day d2 = new Day();
        Subject temp;
        System.out.println(jd.subjects);
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
                temp.theorytot++;
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
        }
    }
}
