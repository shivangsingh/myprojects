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
public class Addition
{
    void Add()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        PreparedStatement pst=con.prepareStatement("INSERT INTO PROSPECT VALUES(?,?,?,?,?,?,?,?)");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the ID");
        int z=0;
        String s=br.readLine();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT PID FROM PROSPECT");
        while(rs.next())
        {
            if(s.equals(rs.getString("PID")))
                z=1;
        }
        if(z==0) {
        pst.setString(1,s);
        System.out.println("Enter the Name");
        pst.setString(2,br.readLine());
        System.out.println("Enter the Address");
        pst.setString(3,br.readLine());
        System.out.println("Enter the Interested Model");
        pst.setString(4,br.readLine());
        System.out.println("Enter the Interested Color");
        pst.setString(5,br.readLine());
        System.out.println("Enter the Status");
        pst.setString(6,br.readLine());
        System.out.println("Enter the Phone");
        pst.setString(7,br.readLine());
        System.out.println("Enter the Employee ID");
        pst.setString(8,br.readLine());
        int status=pst.executeUpdate();
        if(status>0)
            System.out.println("Data Was Added Successfully");
        else
            System.out.println("Data Could Not Be Added");
        }
        else
            System.out.println("This ID Already Exists. Try Again.");
        con.close();
    }


}
