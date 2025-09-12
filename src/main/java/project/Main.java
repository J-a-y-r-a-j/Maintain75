package project;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
     void main() throws SQLException {
        JDBC jdbc = new JDBC();
        jdbc.fetchattendance();
        Subject s1 = new Subject();
        double overall = s1.calcoverallatt(jdbc.subjects);

        System.out.println("Current Overall Attendance "+overall+"\n");

        s1.attendingday(jdbc.subjects,true);
        overall = s1.calcoverallatt(jdbc.subjects);
        System.out.print("Attendance if Attending Today "+overall+"\n");

        jdbc.fetchattendance();
        s1.leaveday(jdbc.subjects);
        overall = s1.calcoverallatt(jdbc.subjects);
        System.out.print("Attendance if Skipping Today "+overall+"\n");
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
