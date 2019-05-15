import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

//# creating database in MySQL Workbench
//#create database qadb;
//
//#point to database with use command
//use qadb;
//
//#create tables
//create table Employeeinfo(name varchar(20), id int, location varchar(20), age int);
//
//describe Employeeinfo;
//
//insert into Employeeinfo values('sam', 1, 'newjersey', 21);
//insert into Employeeinfo values('ram', 2, 'newyork', 31);
//insert into Employeeinfo values('tam', 3, 'serbia', 23);
//insert into Employeeinfo values('lam', 4, 'hungary', 75);

public class Main {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadb", "root", "password2346456");

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'sam'");
        //rs vraca array i zato moram da iskoristim next

        while(rs.next()) {
            //System.out.println(rs.getString("location"));
            //System.out.println(rs.getInt("age"));


            WebDriver driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Web Drivers\\chromedriver.exe");

            driver.get("https://login.salesforce.com");

            driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("location"));
            driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("age"));
        }
    }

}
