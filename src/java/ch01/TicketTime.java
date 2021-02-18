
package ch01;

public class TicketTime 
{
    public String username;
    public String movie_name;
    public String Ticket_no;
    public int hall_no;
    public String date;
    public String start_time;
    public String hall_type;
    public int price;
    public String show_id;

    public TicketTime(String movie_name,String ticket_no,int length,String date,String start_time,String h,int t,String u,String show_id) {
        this.movie_name = movie_name;
        this.Ticket_no = ticket_no;
        this.hall_no = length;
        this.date=date;
        this.start_time=start_time;
        this.hall_type=h;
        this.price=t;
        this.username=u;
        this.show_id=show_id;
    }
}
