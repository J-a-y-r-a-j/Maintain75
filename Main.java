public class Main {
    public static void main(String[] args) {
        System.out.println("ATTENDANCE");
        //System.out.println("Current Overall Attendance "+"");
        Subject CN =  new Subject();
        //Subject DAA = new Subject("DAA",84.62,87.5,50);
        //DAA.suboverallatt(DAA);
        //System.out.println(DAA.name+" Overall Attendance "+DAA.overallatt+"%");
        File f1 = new File();
        //Subject SDAM = new Subject("SDAM",92.31,57.14,28.57);
        //SDAM.suboverallatt(SDAM);
        //f1.readfileattendance(DAA);
        //f1.writefileattendance(SDAM);
        JDBC jdbc = new JDBC();
        jdbc.getallattendance();
        Subject s1 = new Subject();

        for(Subject sub: jdbc.subjects){
            s1.calcsubatt(sub);
            //System.out.println(sub.name+" "+sub.theoryatt+" "+ sub.theorytot+" "+sub.labatt+" "+sub.labtot+" "+sub.tutatt+" "+sub.tuttot+" "+sub.ovrallatt);
        }



    }
}
