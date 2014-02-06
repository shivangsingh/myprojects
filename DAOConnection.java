/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import java.sql.*;
/**
 *
 * @author Anant
 */
public class DAOConnection 
{
    public static Connection setConnection()throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Sales_eNcore", "root", "11reasons");
        return con;
    }
    
}
