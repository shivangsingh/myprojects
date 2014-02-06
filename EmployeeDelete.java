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
public class EmployeeDelete
{
    void deleteEmployee()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOGIN WHERE LOGINID=?");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
        ps.setString(1,s);
        int x=ps.executeUpdate();
        if (x>0)
            System.out.println("Entry is Deleted");
        else
            System.out.println("Entry does not exist");

        }
        else
            System.out.println("ID Does Not Exist. Try Again");

    }
}
