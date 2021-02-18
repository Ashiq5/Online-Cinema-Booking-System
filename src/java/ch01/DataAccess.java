/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01;

import java.sql.CallableStatement;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samsung
 */
public class DataAccess 
{
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl1";
    String username = "hr";
    String password = "hr";

    Connection conn = null;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public int createAccount(String firstName, String lastName, String username, 
            String password,String  email,String credit)
    {
        try
        {
            int f=1;
            try
            {
                String query = "select * from customer";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    f++;
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            String insertCommand = "insert into customer values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            String s="u_"+f;
            stmt.setString(3, s);
            stmt.setString(4, firstName);
            stmt.setString(5, lastName);
            stmt.setString(1, username);
            stmt.setString(6, email);
            stmt.setString(2, password);
            stmt.setString(7, credit);
            int count = stmt.executeUpdate();
            conn.commit();
            System.out.println("customer e insert hoise");
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println("kbfdjbdfj");
            return 0;
        }       
    }
    
   
    public int existUser(String username,String password)
    {
        try
        {
            String query = "select * from customer where user_name=? and password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            //System.out.println("dffdkjbkjdfjkdfj");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                
                return 1;
            }
            return 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    
    }
     public int existEmployee(String username,String password,String em)
    {
        try
        {
            String query;
            if(em.equals("ADMIN"))query = "select * from employee where user_name=? and password=? and j_type=?";
            else query = "select * from employee where user_name=? and password=? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            //System.out.println("dffdkjbkjdfjkdfj");
            stmt.setString(1, username);
            stmt.setString(2, password);
            if(em.equals("ADMIN"))stmt.setString(3, em);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return 1;
            }
            return 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    
    }
    public ArrayList<MovieTime> showMovieList(String dt)
    {
        ArrayList<MovieTime> transactions = new ArrayList<MovieTime>();
        String selectStatement="select e.movie_name,e.genre,e.length,f.show_id,f.start_time,f.dt,f.hall_no,f.price,g.hall_type from movie e join show f on(f.movie_id=e.movie_id and f.dt=?) join hall g on (f.hall_no=g.hall_no)";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String d;
            Date date = null;
            try {
                date=formatter.parse(dt);
                System.out.println(dt);
            } catch (ParseException ex) {
                System.out.println("dT NOT FOUNNT");
            }
            java.sql.Date df=new java.sql.Date(date.getTime());
            System.out.print(df);
            stmt.setDate(1,df);
            ResultSet rs = stmt.executeQuery();
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
                int r=rs.getInt("hall_no");
                String rt=rs.getString("show_id");
                MovieTime trans = new MovieTime(a,b,de,c,g,j,k,r,rt);
                System.out.println("movie LIST"+a+" "+b+" "+de+" "+c+" "+g+" "+j+" "+k+" "+r);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }
    
     public ArrayList<TicketTime> showBoughtTicketList(String sr)
    {
        ArrayList<TicketTime> transactions = new ArrayList<TicketTime>();
        String selectStatement=" select a.ticket_no,a.user_name,b.show_id,b.hall_no,b.start_time,b.dt,c.movie_name,d.hall_type,b.price "+
                               "from ticket a join show b on(a.show_id=b.show_id and a.user_name=?) "+
                               " join movie c on(b.movie_id=c.movie_id) join hall d on(d.hall_no=b.hall_no)";
        try
        {    PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1,sr);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String a = rs.getString("ticket_no");
                String pi = rs.getString("user_name");
                int b = rs.getInt("hall_no");
                String de = rs.getString("start_time");
                String c = rs.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=rs.getString("movie_name");
                String j=rs.getString("hall_type");
                int k=rs.getInt("price");
                String rt=rs.getString("show_id");
                TicketTime trans = new TicketTime(g,a,b,c,de,j,k,pi,rt);
                System.out.println("bought ticket List"+g+" "+a+" "+b+" "+c+" "+de+" "+j+" "+k);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("bought ticket List");
            return null;
        }
        return transactions;
    }
    public ArrayList<TicketTime> showWaitingList(String sr)
    {
        ArrayList<TicketTime> transactions = new ArrayList<TicketTime>();
        String selectStatement=" select * from t_w_f_a where user_name=?";
        try
        {   
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, sr);
            ResultSet ris = stmt.executeQuery();
            
            while(ris.next())
            {
                int b = ris.getInt("hall_no");
                String de = ris.getString("start_time");
                String c = ris.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=ris.getString("movie_name");
                String j=ris.getString("hall_type");
                int k=ris.getInt("price");
                String pi=ris.getString("user_name");
                String rt=ris.getString("show_id");
                TicketTime trans = new TicketTime(g,"",b,c,de,j,k,pi,rt);
                System.out.println("waiting list"+g+" "+" "+b+" "+c+" "+de+" "+j+" "+k);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }
    public ArrayList<TicketTime> showWaitingList()
    {
        ArrayList<TicketTime> transactions = new ArrayList<TicketTime>();
        String selectStatement=" select * from t_w_f_a";
        try
        {   
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            
            ResultSet ris = stmt.executeQuery();
            
            while(ris.next())
            {
                int b = ris.getInt("hall_no");
                String de = ris.getString("start_time");
                String c = ris.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=ris.getString("movie_name");
                String j=ris.getString("hall_type");
                int k=ris.getInt("price");
                String pi=ris.getString("user_name");
                String rt=ris.getString("show_id");
                TicketTime trans = new TicketTime(g,"",b,c,de,j,k,pi,rt);
                System.out.println("waiting list"+g+" "+" "+b+" "+c+" "+de+" "+j+" "+k);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }
    public void insertIntoWaiting(MovieTime m,String r,String show_id)
    {
        try
        {
            String insertCommand = "insert into t_w_f_a values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date=formatter.parse(m.date);
            } catch (ParseException ex) {
                //System.out.println("dT NOT FOUNNT");
            }
            java.sql.Date df=new java.sql.Date(date.getTime());
            stmt.setString(1, r);
            stmt.setDate(4, df);
            stmt.setString(7, m.hall_type);
            stmt.setString(8,show_id);
            stmt.setInt(2, m.hall_no);
            stmt.setString(5, m.start_time);
            stmt.setString(3, m.movie_name);
            stmt.setInt(6, m.price);
            int count = stmt.executeUpdate();
            conn.commit();
            System.out.println("waiting list e insert hoise");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //System.out.println("authorkbfdjbdfj");
            
        } 
        
    }
    public int createAccount(String firstName, String lastName, String jobtype, 
            String username,String  pass)
    {
        try
        {
            String insertCommand = "insert into employee values(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            
            stmt.setString(4, firstName);
            stmt.setString(5, lastName);
            stmt.setString(3,jobtype );
            stmt.setString(1, username);
            stmt.setString(2, pass);
            
            int count = stmt.executeUpdate();
            conn.commit();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    public int updateAccount(String firstName, String lastName, String jobtype, 
            String username,String  pass)
    {
        try
        {
            String insertCommand = "update employee set password = ? , j_type = ?, first_name = ?, last_name = ? where user_name =?";
            PreparedStatement stmt = conn.prepareStatement(insertCommand); 
            
            stmt.setString(3, firstName);
            stmt.setString(4, lastName);
            stmt.setString(2,jobtype );
            stmt.setString(5, username);
            stmt.setString(1, pass);
            System.out.println(firstName+lastName+jobtype+username+pass);
            int count = stmt.executeUpdate();
            System.out.println(count);
            conn.commit();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    public ArrayList<employtime> employee()
    {
        ArrayList<employtime> transactions = new ArrayList<employtime>();
        String selectStatement="select e.user_name,e.password,e.first_name,e.last_name,e.j_type from employee e";
        System.out.println("yoooooooooo");
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            
            //stmt.setString
            ResultSet rs = stmt.executeQuery();
            //System.out.print("jdfk");
            while(rs.next())
            {
                String a = rs.getString("user_name");
                String b = rs.getString("password");
                String c = rs.getString("first_name");
                
                String g=rs.getString("last_name");
                String j=rs.getString("j_type");
                
                employtime trans = new employtime(a,b,c,g,j);
                System.out.println(a+" "+b+" "+c+" "+c+" "+g+" "+j);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }
     public ArrayList<dorkar> showList()
    {
        ArrayList<dorkar> transactions = new ArrayList<dorkar>();
        String selectStatement="select s.show_id,s.start_time,s.hall_no,m.movie_name,m.genre,m.length,m.movie_id,s.dt,s.price from show s join movie m on (s.movie_id=m.movie_id)";
        System.out.println("yoooooooooo");
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            
            //stmt.setString
            ResultSet rs = stmt.executeQuery();
            //System.out.print("jdfk");
            while(rs.next())
            {
                String a = rs.getString("show_id");
                String b = rs.getString("start_time");
                int n=rs.getInt("hall_no");
                String c = rs.getString("movie_name");
                
                String g=rs.getString("genre");
                int j=rs.getInt("length");
                String gh=rs.getString("movie_id");
                String fg=rs.getString("dt");
                int df=rs.getInt("price");
                
                dorkar trans = new dorkar(a,b,c,g,j,n,gh,fg,df);
                System.out.println(a+" "+b+" "+c+" "+j+" "+g+" "+n);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return transactions;
    }  
     public int coy1(String movie_id,String movie_name,String genre,int length)
    {
        
        String selectStatement="insert into movie values(?,?,?,?)";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            
            stmt.setString(4, movie_id);
            stmt.setString(1, movie_name);
            stmt.setString(2,genre );
            stmt.setInt(3, length);
            int count = stmt.executeUpdate();
            conn.commit();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
        
    }
     public int coy2(String dt,String start_time,String s,String movie_id,String show_id,int hall_no,int price)
    {
        
        String selectStatement="insert into show values(?,?,?,?,?,?,?)";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            System.out.println("final check dada"+dt +" "+start_time +" "+ s +" "+ movie_id  +" "+show_id  +" "+hall_no);
            stmt.setString(2, start_time);
            stmt.setString(3, s);
            stmt.setString(4,movie_id);
            stmt.setString(5, show_id);
            stmt.setInt(6, hall_no);
            stmt.setInt(7,price);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String d;
            //dt=dt.replaceAll(" 00:00:00.0","");
            Date date = null;
            try {
                date=formatter.parse(dt);
                System.out.println(dt);
            } catch (ParseException ex) {
                System.out.println("dT NOT FOUNNT");
            }
            java.sql.Date df=new java.sql.Date(date.getTime());
            System.out.print(df);
            stmt.setDate(1,df);
            int count = stmt.executeUpdate();
            conn.commit();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        
        return 1;
        
    }
     public void insertTicket(String a,String b,String c,int fgkf,String aa,String bb) 
            
    {
        System.out.println("dkjfbkdjddjjjjjjjjjjjjjjjjjjjjjjj");
        try
        {
            int fr=1;
            try
            {
                String query = "select * from ticket";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                while(rs.next())
                {
                    fr++;
                }
            }
            catch(Exception gbfjg)
            {
                System.out.println("query hoy na");
                gbfjg.printStackTrace();
            }
            System.out.print("dkjfbkdjddjjjjjjjjjjjjjjjjjjjjjjj");
            try{
                String insertCommand = "insert into ticket values(?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(insertCommand); 
                String sds=""+String.valueOf(fr);
                stmt.setString(1, a);
                stmt.setString(4, c);
                stmt.setString(2,b);
                stmt.setString(3,sds);
                stmt.setInt(5,fgkf);
                int count = stmt.executeUpdate();
                conn.commit();
            }
            catch(Exception ex){
                System.out.print("insert o hoy nai");
                ex.printStackTrace();
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            date=formatter.parse(bb);
            System.out.println(bb);
            java.sql.Date df=new java.sql.Date(date.getTime());
            String dCommand = "delete from t_w_f_a where user_name=?  and dt=? and start_time=?";
            PreparedStatement stmt = conn.prepareStatement(dCommand); 
            stmt.setString(1, a);stmt.setDate(2, df);stmt.setString(3, aa);
            stmt.executeUpdate();
            conn.commit();
            
        }
        catch(Exception ef)
        {
            ef.printStackTrace();
            System.out.println("delete hoy na");
            
        }       
    }
    public void deletet_w_f_a(String a,String b,String c) 
            
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            date=formatter.parse(b);
            System.out.println(b);
            java.sql.Date df=new java.sql.Date(date.getTime());
            String dCommand = "delete from t_w_f_a where user_name=? and dt=? and start_time=?";
            PreparedStatement stmt = conn.prepareStatement(dCommand); 
            stmt.setString(1, a);stmt.setDate(2, df);stmt.setString(3, c);
            stmt.executeUpdate();
            conn.commit();
            
        }
        catch(Exception ef)
        {
            ef.printStackTrace();
            System.out.println("delete hoy na");
            
        }       
    }
    public void deleteTicket() 
            
    {
        try
        {
            String dCommand = "delete from ticket";
            PreparedStatement stmt = conn.prepareStatement(dCommand); 
            stmt.executeUpdate();
            conn.commit();
            
        }
        catch(Exception ef)
        {
            ef.printStackTrace();
            System.out.println("delete hoy na");
            
        }       
    }
    public int coy3(String movie_id,String movie_name,String genre,int length)
    {
        
        String selectStatement="update movie set movie_name=?, genre=?, length=? where movie_id="+movie_id;
        //String update="update movie set movie_name="+movie_name+",genre="+genre+",length="+length+" where movie_id="+movie_id+";";
                
                
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, movie_name);
            stmt.setString(2,genre );
            stmt.setInt(3, length);
            //stmt.setString(4, movie_id);
            System.out.println(movie_name+genre+length+movie_id);
            int count = stmt.executeUpdate();
            System.out.println(count);
            conn.commit();
            
        }
        catch(Exception e)
        {
            System.out.print("update hocche na");
            e.printStackTrace();
            return 0;
        }
        return 1;
        
    }
     public int coy4(String dt,String start_time,String s,String movie_id,String show_id,int hall_no,int price)
    {
        
        String selectStatement="update show set dt=?,start_time=?,manager_username=?,movie_id=?,hall_no=?,price=? where show_id="+show_id;
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            //System.out.println("final check dada"+dt +" "+start_time +" "+ s +" "+ movie_id  +" "+show_id  +" "+hall_no);
            stmt.setString(2, start_time);
            stmt.setString(3, s);
            stmt.setString(4,movie_id);
            //stmt.setString(7, show_id);
            stmt.setInt(5, hall_no);
            stmt.setInt(6,price);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String d;
            //dt=dt.replaceAll(" 00:00:00.0","");
            Date date = null;
            try {
                date=formatter.parse(dt);
                System.out.println(dt);
            } catch (ParseException ex) {
                System.out.println("dT NOT FOUNNT");
            }
            java.sql.Date df=new java.sql.Date(date.getTime());
            //System.out.print(df);
            stmt.setDate(1,df);
            int count = stmt.executeUpdate();
            conn.commit();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        
        return 1;
        
    }
    public ArrayList<TicketTime> showBoughtTicketList()
    {
        ArrayList<TicketTime> transactions = new ArrayList<TicketTime>();
        String selectStatement=" select a.ticket_no,a.user_name,b.show_id,b.hall_no,b.start_time,b.dt,c.movie_name,d.hall_type,b.price "+
                               "from ticket a join show b on(a.show_id=b.show_id) "+
                               " join movie c on(b.movie_id=c.movie_id) join hall d on(d.hall_no=b.hall_no)";
        try
        {    PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String a = rs.getString("ticket_no");
                String pi = rs.getString("user_name");
                int b = rs.getInt("hall_no");
                String de = rs.getString("start_time");
                String c = rs.getString("dt");
                c=c.replaceAll(" 00:00:00.0","");
                String g=rs.getString("movie_name");
                String j=rs.getString("hall_type");
                int k=rs.getInt("price");
                String rt=rs.getString("show_id");
                TicketTime trans = new TicketTime(g,a,b,c,de,j,k,pi,rt);
                System.out.println("bought ticket List"+g+" "+a+" "+b+" "+c+" "+de+" "+j+" "+k);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("bought ticket List");
            return null;
        }
        return transactions;
    }
    
}

