/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp;
import java.sql.*;
/**
 *
 * @author Shivang
 */
public class AllEmployees
{
    void showEmployees()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT LOGINID,PASSWORD FROM EMPLOGIN WHERE ROLE='USER'");
        while(rs.next())
        {
            System.out.println(rs.getString("LoginId")+"   "+rs.getString("Password"));
        }
    }

}
