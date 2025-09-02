import java.io.*;
import java.util.*;
public class File{
    void readfileattendance(Subject sub){
        try{
            BufferedReader rd = new BufferedReader(new FileReader("attendancefile.txt"));
            String line;
            while((line = rd.readLine()) != null ){
                if(line.startsWith("Subject = ")){
                    String subname = line.replace("Subject = ","").trim();
                    sub.name = subname;
                }
                if(line.startsWith("ThAtt = ")){
                    String rdthatt = line.replace("ThAtt = ","").trim();
                    //int thatt = Double.parseDouble(rdthatt);
                    //sub.theoryatt = thatt;
                }
                if(line.startsWith("LbAtt = ")){
                    String rdlbatt = line.replace("LbAtt = ","").trim();
                    //Double lbatt = Double.parseDouble(rdlbatt);
                    //sub.labatt = lbatt;
                }
                if(line.startsWith("TuAtt = ")){
                    String rdtuatt = line.replace("TuAtt = ","").trim();
                    //Double tuatt = Double.parseDouble(rdtuatt);
                    //sub.tutatt = tuatt;
                }
                if(line.startsWith("OvAtt = ")){
                    String rdovatt = line.replace("TuAtt = ","").trim();
                    Double ovatt = Double.parseDouble(rdovatt);
                    sub.ovrallatt = ovatt;
                }

            }
            System.out.println(sub.name+" "+sub.theoryatt+" "+sub.labatt+" "+sub.tutatt+" "+sub.ovrallatt);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    void writefileattendance(Subject sub){
        try{
            BufferedWriter wr = new BufferedWriter( new FileWriter("attendancefile.txt",true));
            BufferedReader rd = new BufferedReader(new FileReader("attendancefile.txt"));
                wr.write("\n\nSubject = "+sub.name);
                wr.write("\nThatt = "+sub.theoryatt);
                wr.write("\nLbAtt = "+sub.labatt);
                wr.write("\nTuAtt = "+sub.tutatt);
                wr.write("\nOvAtt = "+sub.ovrallatt);
            wr.close();
        }catch(IOException d){
            d.printStackTrace();
        }

    }
}