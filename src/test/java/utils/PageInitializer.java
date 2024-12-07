package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MembershipPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static MembershipPage membershipPage;


    public static void initializePageObject(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        addEmployeePage= new AddEmployeePage();
        membershipPage=new MembershipPage();

    }
}
