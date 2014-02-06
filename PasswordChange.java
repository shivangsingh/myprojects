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
public class PasswordChange
{
    void changePassword()throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Connection con=com.dao.DAOConnection.setConnection();
        System.out.println("Enter the ID");
        String s=br.readLine();
        Statement st=con.createStatement();
        int y=0;
        ResultSet rs=st.executeQuery("SELECT LOGINID FROM EMPLOGIN");
        while(rs.next())
        {
            if(s.equals(rs.getString("LOGINID")))
            {
                y=1;
                break;
            }
        }
        if(y==1) {
        System.out.println("Enter the New Password");
        String s1=br.readLine();
        PreparedStatement ps=con.prepareStatement("UPDATE EMPLOGIN SET PASSWORD=? WHERE LOGINID=?");
        ps.setString(1, s1);
        ps.setString(2,s);
        int status=ps.executeUpdate();
        if (status>0)
            System.out.println("Password was changed Successfully");
        else
            System.out.println("No Such Account Exists");
    }
        else
            System.out.println("ID Does Not Exist. Try Again.");
    }
}
