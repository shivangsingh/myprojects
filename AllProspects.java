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
public class AllProspects
{
    void showProspects()throws Exception
    {
        Connection con=com.dao.DAOConnection.setConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM PROSPECT");
        System.out.printf("%-10s %-15s %-30s %-10s %-10s %-10s %-15s %-10s \n", "PID", "PName", "PAddress", "Model", "Color", "Status", "Phone", "EmpId");
        while(rs.next())
        {
            System.out.printf("%-10s %-15s %-30s %-10s %-10s %-10s %-15s %-10s \n", rs.getString("PID"), rs.getString("PName"), rs.getString("PAddress"), rs.getString("Model"), rs.getString("Color"), rs.getString("Status"), rs.getString("Phone"), rs.getString("EmpId") );
        }
        con.close();
    }


 }
