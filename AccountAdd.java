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
public class AccountAdd
{
    void addAccount()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        PreparedStatement ps=con.prepareStatement("INSERT INTO EMPLOGIN VALUES(?,?,?)");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the ID");
        int z=0;
        String s=br.readLine();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT LOGINID FROM EMPLOGIN");
        while(rs.next())
        {
            if(s.equals(rs.getString("LOGINID")))
                z=1;
        }
        if(z==0) {
        ps.setString(1,s);
        System.out.println("Enter the Password");
        s=br.readLine();
        ps.setString(2,s);
        System.out.println("Enter the Role");
        s=br.readLine();
        if(s.equalsIgnoreCase("User")||s.equalsIgnoreCase("Admin")) {
        ps.setString(3,s);
        int status=ps.executeUpdate();
        if(status>0)
            System.out.println("Data was Added Successfully");
        else
            System.out.println("Data was not Added");
        }
        else
                System.out.println("Entered Role Is Not Valid. Enter Either User Or Admin. Try Again");
        }
        else
            System.out.println("ID Already Exists. Try Again");
    }


    }


