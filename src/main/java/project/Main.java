package project;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

        JDBC jdbc = new JDBC();
        Subject s1 = new Subject();


    double dispatt(){
            jdbc.fetchattendance();
            double overall = s1.calcoverallatt(jdbc.subjects);
            System.out.println("Current Overall Attendance "+overall+"\n");
        return overall;
    }

    double going(){
         jdbc.fetchattendance();
         s1.attendingday(jdbc.subjects,true);
         double goverall = s1.calcoverallatt(jdbc.subjects);
         System.out.print("Attendance if Going "+goverall+"\n");
        return goverall;
    }

    double leave(){
         jdbc.fetchattendance();
         s1.leaveday(jdbc.subjects);
         double loverall = s1.calcoverallatt(jdbc.subjects);
         System.out.print("Attendance if Skipping"+loverall+"\n");
        return loverall;
    }

     void would() throws SQLException{
        jdbc.fetchattendance();
        System.out.println("Would you like to attend");
        Scanner sca = new Scanner(System.in);
        String choice = sca.next();
        switch(choice){
            case "y","yes":
                s1.attendingday(jdbc.subjects,false);
                jdbc.writeallattendance();
                break;
            case "n","no":
                s1.leaveday(jdbc.subjects);
                jdbc.writeallattendance();
                break;
        }


    }
}
