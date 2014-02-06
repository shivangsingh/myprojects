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
public class Search
{
    void searchProspect()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        System.out.println("Enter 1 to search by Name");
        System.out.println("Enter 2 to search by Id");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x=Integer.parseInt(br.readLine());
        int x1=0;
        if(x==1)
        {
            System.out.println("Enter the Name");
            String s=br.readLine();
            s= "%"+s+"%";
            PreparedStatement ps=con.prepareStatement("SELECT * FROM PROSPECT WHERE PName like ?");
            ps.setString(1,s);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                x1=1;
                System.out.printf("%-10s %-15s %-30s %-10s %-10s %-10s %-15s %-10s \n", rs.getString("PID"), rs.getString("PName"), rs.getString("PAddress"), rs.getString("Model"), rs.getString("Color"), rs.getString("Status"), rs.getString("Phone"), rs.getString("EmpId") );

            }
            if (x1==1) {
                System.out.println("Thank You!");

            }
            else
                System.out.println("No Entry Exists With That Name");
        }
        else if (x==2)
        {
            System.out.println("Enter the ID");
            String s1=br.readLine();
            s1="%"+s1+"%";
            PreparedStatement ps1=con.prepareStatement("SELECT * FROM PROSPECT WHERE PID like ?");
            ps1.setString(1,s1);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next())
            {
                x1=1;
                System.out.printf("%-10s %-15s %-30s %-10s %-10s %-10s %-15s %-10s \n", rs1.getString("PID"), rs1.getString("PName"), rs1.getString("PAddress"), rs1.getString("Model"), rs1.getString("Color"), rs1.getString("Status"), rs1.getString("Phone"), rs1.getString("EmpId") );
            }
            if (x1==1) {
                System.out.println("Thank You!");

            }
            else
                System.out.println("No Entry Exists With That Name");
        }
        else
            System.out.println("Wrong Choice Entered. Please Try Again.");
        con.close();
        }

}
