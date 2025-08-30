import java.io.*;
public class File {
    public static void main(String[] args) {
        Subject test =  new Subject("test",66.7,78,85);
        test.suboverallatt(test);
        System.out.println(test.name);
        String testnumber;
        /*try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("store.txt"));
            writer.write("||ATTENDANCE STORAGE||");
            writer.write("\nSubject: "+test.name);
            writer.write("\nTheory Attendance: "+test.theoryatt);
            writer.write("\nLab Attendance: "+test.labatt);
            writer.write("\nTutorial Attendance: "+test.tutatt);
            writer.write("\nOverall Attendance:"+test.overallatt);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }*/

        try{
            BufferedReader reader = new BufferedReader(new FileReader("store.txt"));
            while((testnumber=reader.readLine()) != null){
                if(testnumber.startsWith("Subject:")){
                    String trimmed = testnumber.replace("Subject:","").trim();
                    test.name = trimmed;
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(test.name);
    }
}
