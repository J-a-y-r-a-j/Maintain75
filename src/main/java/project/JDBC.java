package project;

import java.sql.*;
import java.util.ArrayList;

public class JDBC{
    ArrayList<Subject> subjects = new ArrayList<>();

    void fetchattendance(){
        if(!subjects.isEmpty()){
            subjects.clear();
        }
        getallattendance();
    }

    void getallattendance(){
        try{
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://mainline.proxy.rlwy.net:46537/railway","root","mysqlroot321");
        Statement stmt = conn.createStatement();
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
            subjects.add(tempsub);
            //System.out.println(tempsub.name+" "+tempsub.ovrallatt);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void writeallattendance() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://host.docker.internal:3306/attendancesheet","root","mysqlroot321");
        Statement st = conn.createStatement();

        for(int i =0;i<3;i++){
            Subject temp = subjects.get(i);
            System.out.println(temp.name+" "+temp.theoryatt+" "+temp.theorytot+" "+temp.labatt+" "+temp.labtot+" "+temp.tutatt+" "+temp.tuttot);
            String update = "update sheet set theoryatt = "+temp.theoryatt+", theorytot = "+temp.theorytot+", labatt = "+temp.labatt+", labtot = "+ temp.labtot+", tutatt = "+ temp.tutatt+", tuttot = "+ temp.tuttot+"where id = "+(i+1);
            st.execute(update);
        }
        System.out.println("Attendance Updated");
    }



}
