/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp;
import java.sql.*;
import java.io.*;
/**
 *
 * @author Shivang
 */
public class StatusUpdate
{
    void updateStatus()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Prospect ID to change the status");
        String s=br.readLine();
        Statement st=con.createStatement();
        int y=0;
        ResultSet rs=st.executeQuery("SELECT PID FROM PROSPECT");
        while(rs.next())
        {
            if(s.equals(rs.getString("PID")))
            {
                y=1;
                break;
            }
        }
        if(y==1) {

        System.out.println("Enter the New Status");
        String s1=br.readLine();
        if(s1.equalsIgnoreCase("Hot")||s1.equalsIgnoreCase("Cold")||s1.equalsIgnoreCase("Warm"))
        {
        PreparedStatement ps=con.prepareStatement("UPDATE PROSPECT SET STATUS=? WHERE PID=?");
        ps.setString(1,s1);
        ps.setString(2,s);
        ps.executeUpdate();
        PreparedStatement ps1=con.prepareStatement("SELECT * FROM PROSPECT WHERE PID=?");
            ps1.setString(1,s);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next())
            {
                System.out.printf("%-10s %-15s %-30s %-10s %-10s %-10s %-15s %-10s \n", rs.getString("PID"), rs.getString("PName"), rs.getString("PAddress"), rs.getString("Model"), rs.getString("Color"), rs.getString("Status"), rs.getString("Phone"), rs.getString("EmpId") );
            }
        }
        else
            System.out.println("The Entered Status is Invalid.");
        }
        else
            System.out.println("ID Does Not Exist. Try Again.");
        con.close();
    }

}
