/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01;

import static java.lang.Class.forName;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hp
 */
public class DBConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.print("found");
        } catch (ClassNotFoundException ex) {
            System.out.print("not found");
        }
        String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl1";
        String username = "hr";
        String password = "hr";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connection successfully established.");
        } catch (SQLException ex) {
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        /*Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            //Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        /*String s="DROP TABLE CUSTOMER";
        try {
            stmt.executeUpdate(s);
            System.out.println("Sequence Created");
        } catch (SQLException ex) {
            System.out.println("Sequence NOT Created");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql =    "CREATE TABLE CUSTOMER " +
                   "(user_id INTEGER not NULL, " +
                   " user_name VARCHAR(20) not NULL, "+
                   " first_name VARCHAR(255), " + 
                   " last_name VARCHAR(255), " + 
                   " EMAIL  VARCHAR(30), " + 
                   " PASSWORD VARCHAR(20), " +
                   " CREDIT_CARD_NO VARCHAR(30), " +
                   " PRIMARY KEY ( user_id ))"; 
          /*"CREATE TABLE REG " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))";*/

        /*try {
            stmt.executeUpdate(sql);
            System.out.println("Sequence Created");
        } catch (SQLException ex) {
            System.out.println("Sequence NOT Created");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       /* try
        {
            String insertCommand = "insert into reg values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setInt(1, 1);
            stmt.setString(2, "Ishtiaq");
            stmt.setString(3, "Ashiq");
            stmt.setInt(4, 20);
            //stmt.setString(3, "kjn");
            //stmt.setString(4, "lkknfn");
            
            int count = stmt.executeUpdate();
            conn.commit();
            System.out.println(count+"somossa ki>");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("kbfdjbdfj");
            
        }
        try
        {
            String query = "select * from reg";
            PreparedStatement stmnt = conn.prepareStatement(query);
            //stmt.setString(1, "IT_PROG");
            //stmt.setString(2, "ldfnn");
            //System.out.print(stmt.g);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(2));
                 
            }
            //System.out.println(rs.getString(4));
        }
        catch(Exception e)
        {
            e.printStackTrace();
           
        }
    }*/
       /*try
        {
            String query = "select * from customer where user_name=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            System.out.println("dffdkjbkjdfjkdfj");
            //stmt.setString(1, "");
            stmt.setString(1, username);
            //stmt.setString(3, "");
            //stmt.setString(4, password);
            //stmt.setString(5, username);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                System.out.print("ldfdkg");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("jfksfjsbfjks");
        }     */
        //ArrayList<MovieTime> transactions = new ArrayList<MovieTime>();
        /*String datetime="14-dec-2016";
        
        String spr="select f.hall_type,f.price,e.dt from show e join price_listing f "+ 
                "using (show_id) where e.dt=?";
        String selectStatement="select e.movie_name,e.genre,e.length,f.start_time,f.dt,g.price,g.hall_type from movie e join show f on(e.movie_id=f.movie_id) join price_listing g on (f.show_id=g.show_id and f.dt=?)";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String d;
            d = "2016-12-14";
            Date date = null;
            try {
                date=formatter.parse(d);
                System.out.println(d);
            } catch (ParseException ex) {
                System.out.println("dT NOT FOUNNT");
            }
            java.sql.Date df=new java.sql.Date(date.getTime());
            System.out.print(df);
            stmt.setDate(1,df);
            //stmt.setString
            ResultSet rs = stmt.executeQuery();
            //System.out.print("jdfk");
            while(rs.next())
            {
                String a = rs.getString("movie_name");
                String b = rs.getString("genre");
                int de = rs.getInt("length");
                String c = rs.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=rs.getString("start_time");
                String j=rs.getString("hall_type");
                int k=rs.getInt("price");
                //MovieTime trans = new MovieTime(a,b,de,c,g);
                System.out.println(a+" "+b+" "+de+" "+c+" "+g+" "+j+" "+k);
                //transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
        String selectStatement=" select a.ticket_no,a.hall_no,b.start_time,b.dt,c.movie_name,d.hall_type,d.price "+
                               "from ticket a join show b on(a.show_id=b.show_id and a.authorized=?) "+
                               " join movie c on(b.movie_id=c.movie_id) join price_listing d on(d.movie_id=c.movie_id)";
        try
        {    PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setInt(1,0);
            ResultSet rs = stmt.executeQuery();
            //System.out.print("jdfk");
            while(rs.next())
            {
                String a = rs.getString("ticket_no");
                int b = rs.getInt("hall_no");
                String de = rs.getString("start_time");
                String c = rs.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=rs.getString("movie_name");
                String j=rs.getString("hall_type");
                int k=rs.getInt("price");
                //TicketTime trans = new TicketTime(g,a,b,c,de,j,k);
                System.out.println(g+" "+a+" "+b+" "+c+" "+de+" "+j+" "+k);
                //transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
}

