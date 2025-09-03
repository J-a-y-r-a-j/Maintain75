import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class JDBC{
    public ArrayList<Subject> subjects = new ArrayList<>();
    void getallattendance(){
        try{
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancesheet","root","mysqlroot321");
        Statement stmt = conn.createStatement();
        System.out.println("connection successful");
        String get = "Select * from sheet";
        ResultSet rs = stmt.executeQuery(get);

        while(rs.next()){

            Subject tempsub = new Subject();
            tempsub.name = (rs.getString("subname"));
            tempsub.theoryatt = (rs.getInt("theoryatt"));
            tempsub.theorytot = (rs.getInt("theorytot"));
            tempsub.labatt = (rs.getInt("labatt"));
            tempsub.labtot = (rs.getInt("labtot"));
            tempsub.tutatt = (rs.getInt("tutatt"));
            tempsub.tuttot = (rs.getInt("tuttot"));
            tempsub.ovrallatt = (rs.getDouble("ovrallatt"));
            subjects.add(tempsub);
            //System.out.println(tempsub.name+" "+tempsub.ovrallatt);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
