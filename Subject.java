import java.util.Scanner;

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
        /*double theorypercentage = Math.round((sub.theoryatt/sub.theorytot);
        double labpercentage = Math.round((sub.labatt/sub.labtot)*100);
        double tutpercentage =Math.round((sub.tutatt/sub.tuttot)*100)/100;*/
        double theorypercentage = Math.round(((double) sub.theoryatt / sub.theorytot) * 10000.0) / 100.0;
        double labpercentage = Math.round(((double) sub.labatt / sub.labtot) * 10000.0) / 100.0;
        double tutpercentage = Math.round(((double) sub.tutatt / sub.tuttot) * 10000.0) / 100.0;
        sub.ovrallatt = Math.round((theorypercentage+labpercentage+tutpercentage)/3);
        System.out.println("Theory Percentage "+theorypercentage);
        System.out.println("Lab Percentage "+labpercentage);
        System.out.println("Tut Percentage"+tutpercentage);
        System.out.println("Overall Percentage "+ sub.ovrallatt);
    }
}
