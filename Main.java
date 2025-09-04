public class Main {
    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.fetchattendance();
        Subject s1 = new Subject();
        double overall = s1.calcoverallatt(jdbc.subjects);

        /*for(Subject s : jdbc.subjects){
            System.out.println(s.theoryatt+" "+s.theorytot+" "+s.labatt+" "+s.labtot+" "+s.tutatt+" "+s.tuttot);
        }*/


        System.out.println("Current Overall Attendance "+overall);





        s1.attendingday(jdbc.subjects);
        overall = s1.calcoverallatt(jdbc.subjects);
        System.out.println("Attendance if Attending Today "+overall);
        jdbc.fetchattendance();



        /*for(Subject s : jdbc.subjects){
            System.out.println(s.theoryatt+" "+s.theorytot+" "+s.labatt+" "+s.labtot+" "+s.tutatt+" "+s.tuttot);
        }*/


        s1.leaveday(jdbc.subjects);
        overall = s1.calcoverallatt(jdbc.subjects);
        System.out.println("Attendance if Skipping Today "+overall);
        jdbc.fetchattendance();



        /*for(Subject s : jdbc.subjects){
            System.out.println(s.theoryatt+" "+s.theorytot+" "+s.labatt+" "+s.labtot+" "+s.tutatt+" "+s.tuttot);
        }*/


    }
}
