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
public class SalesEncore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        Connection con = null;
        try {
            con = com.dao.DAOConnection.setConnection();

        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Sales eNcore");
        System.out.println("-----------------------");
        System.out.println("Enter Your Credentials To Gain Access");
        Login l1 = new Login();
        int x = l1.checkLogin();
        String x1=l1.user;
        String x2=l1.pass;
        System.out.println();
        int y = 1;
        if (x == 1) {
            while (y != 8) {
                System.out.println("What would you like to do ?");
                System.out.println("Your Account Has The Following Features : ");
                System.out.println("Enter 1 to Add a new Prospect");
                System.out.println("Enter 2 to View All the Prospects");
                System.out.println("Enter 3 to Update the Interested Color of a Prospect");
                System.out.println("Enter 4 to Update the Interested Model of a Prospect");
                System.out.println("Enter 5 to Search for a Particular Prospect");
                System.out.println("Enter 6 to Update the Status of a Prospect");
                System.out.println("Enter 7 to Change Your Password");
                System.out.println("Enter 8 to Sign Out of the Account");
                y = Integer.parseInt(br.readLine());
                if (y == 1) {
                    Addition a1 = new Addition();
                    a1.Add();
                    System.out.println();
                } else if (y == 2) {
                    AllProspects ap = new AllProspects();
                    ap.showProspects();
                    System.out.println();
                } else if (y == 3) {
                    ColorUpdate c1 = new ColorUpdate();
                    c1.updateColor();
                    System.out.println();
                } else if (y == 4) {
                    ModelUpdate m1 = new ModelUpdate();
                    m1.updateModel();
                    System.out.println();
                } else if (y == 5) {
                    Search s1 = new Search();
                    s1.searchProspect();
                    System.out.println();
                } else if (y == 6) {
                    StatusUpdate s1 = new StatusUpdate();
                    s1.updateStatus();
                    System.out.println();
                } else if (y == 7) {
                    PasswordChangeUser pcu=new PasswordChangeUser();
                    x2=pcu.changePassword(x1, x2);
                    System.out.println();
                } else if(y==8){
                    System.out.println("----------Thank You For Using Sales eNcore----------");
                }
                else {
                    System.out.println("You Have Entered an Incorrect Choice. Try again");
                    System.out.println();
                }
            }
        }
        else if(x==-1)
        {
            while(y!=7)
            {
                System.out.println("What would you like to do ?");
                System.out.println("Your Account Has The Following Features : ");
                System.out.println("Enter 1 to View All The Employees");
                System.out.println("Enter 2 to Add New Account");
                System.out.println("Enter 3 to Delete An Employee Account");
                System.out.println("Enter 4 to View All Prospects");
                System.out.println("Enter 5 to Delete A Prospect");
                System.out.println("Enter 6 to Change Password");
                System.out.println("Enter 7 to Sign Out of the Account");
                y = Integer.parseInt(br.readLine());
                if (y == 1) {
                    AllEmployees ae1=new AllEmployees();
                    ae1.showEmployees();
                    System.out.println();
                } else if (y == 2) {
                    AccountAdd aa1=new AccountAdd();
                    aa1.addAccount();
                    System.out.println();
                } else if (y == 3) {
                    EmployeeDelete ed=new EmployeeDelete();
                    ed.deleteEmployee();
                    System.out.println();
                } else if (y == 4) {
                    AllProspects ap1 = new AllProspects();
                    ap1.showProspects();
                    System.out.println();
                } else if (y == 5) {
                    ProspectDelete pd=new ProspectDelete();
                    pd.deleteProspect();
                    System.out.println();
                } else if (y == 6) {
                    PasswordChange pc=new PasswordChange();
                    pc.changePassword();
                    System.out.println();
                } else if (y == 7) {
                    System.out.println("----------Thank You For Using Sales eNcore----------");
                } else {
                    System.out.println("You Have Entered an Incorrect Choice. Try again");
                    System.out.println();

                }
            }
        }
        else  {}


    }
}
