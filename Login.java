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
public class Login
{
    String user="",pass="";
    int checkLogin()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your USERNAME");
        user=br.readLine();
        Statement st1=con.createStatement();
        int y=0,f;
        ResultSet rs1=st1.executeQuery("SELECT LOGINID FROM EMPLOGIN");
        while(rs1.next())
        {
            if(user.equals(rs1.getString("LOGINID")))
            {
                y=1;
                break;
            }
        }
        if(y==1) {
            System.out.println("Enter your PASSWORD");
        pass=br.readLine();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM EMPLOGIN");
        f=0;
        String str="User";
        while(rs.next())
        {
            if(user.equals(rs.getString("LoginId")))
            {
                if (pass.equals(rs.getString("Password")))
                {
                    if(str.equals(rs.getString("Role")))
                        f=1;
                    else
                        f=-1;
                }
                else
                {
                    System.out.println("You Entered Wrong Password");
                    System.out.println("You do not have access to this portal.");
                    f=0;
                    return f;
                }
            }
        }
        }
        else {

           System.out.println("ID Does Not Exist");
           f=0;
        }
        if(f==1)
        {
            System.out.println("You are Logged In As A User");
            return f;
        }
        else if(f==-1)
        {
            System.out.println("You are Logged In As An Administrator");
            return f;
        }
        {
            System.out.println("You do not have access to this portal.");
            return f;
            }

}
}
