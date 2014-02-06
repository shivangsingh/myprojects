/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Shivang
 */
public class PasswordChangeUser {

    String changePassword(String a, String b) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection con = com.dao.DAOConnection.setConnection();
        System.out.println("Enter the ID");
        String p="";
        String s = br.readLine();
        if (s.equals(a)) {
            System.out.println("Enter the Old Password");
            p = br.readLine();
            if (p.equals(b)) {
                System.out.println("Enter the New Password");
                String s1 = br.readLine();
                PreparedStatement ps = con.prepareStatement("UPDATE EMPLOGIN SET PASSWORD=? WHERE LOGINID=?");
                ps.setString(1, s1);
                ps.setString(2, s);
                int status = ps.executeUpdate();
                if (status > 0) {
                    System.out.println("Password was changed Successfully");
                    return s1;
                } else {
                    System.out.println("No Such Account Exists");
                    return p;
                }
            }
             else {
                System.out.println("You Entered The Wrong Password. Try Again.");
                return b;
            }
        }
         else {
            Statement st = con.createStatement();
            int y = 0;
            ResultSet rs = st.executeQuery("SELECT LOGINID FROM EMPLOGIN");
            while (rs.next()) {
                if (s.equals(rs.getString("LOGINID"))) {
                    y = 1;
                    break;
                }
            }
            if (y == 1) {
                System.out.println("You Are Not Authorized To Change The Password Of Another Employee");
                return b;
            } else {
                System.out.println("ID Does Not Exist. Try Again.");
                return b;
            }
        }

    }
}


