import java.util.Scanner;
public class Subject {
    String name;
    double theoryatt;
    double labatt;
    double tutatt;
    double overallatt;

    Subject(String name, double theoryatt, double labatt, double tutatt, double overallatt){
        this.name = name;
         this.theoryatt=   theoryatt;
        this.labatt =   labatt;
        this.tutatt = tutatt;
    }
    Subject(){}
    Subject(String name,double theoryatt, double labatt,double tutatt){
        this.name = name;
        this.theoryatt = theoryatt;
        this.tutatt = tutatt;
        this.labatt = labatt;
    }
    double calcatt(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter Sessions Attended(x/y)");
        double x = s1.nextDouble();
        double y = s1.nextDouble();
        double curratt = (x / y)*100;
        System.out.printf("Current Attendance "+curratt+"%");
        return curratt;
    }

    double suboverallatt(Subject temp){
        temp.overallatt = (temp.labatt+temp.theoryatt+temp.tutatt)/(3);
        return temp.overallatt;
    }
}
