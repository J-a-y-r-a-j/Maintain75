public class Main {
    public static void main(String[] args) {
        System.out.println("ATTENDANCE");
        System.out.println("Current Overall Attendance "+"");
        Subject CN =  new Subject();
        Subject DAA = new Subject("DAA",84.62,87.5,50);
        DAA.suboverallatt(DAA);
        System.out.println(DAA.name+" Overall Attendance "+DAA.overallatt+"%");
    }
}
