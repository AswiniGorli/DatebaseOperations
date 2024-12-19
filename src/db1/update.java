package db1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class update {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		
		try {
			Scanner src=new Scanner(System.in);
			
			Class.forName(Driver);
			conn=DriverManager.getConnection(url,username,password);
			
			System.out.println("enter table name:");
			String sql="update "+src.next()+" set id=?,name=?,email=?,password=? where id=?";
		
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter id:");
			pmst.setInt(1, src.nextInt());
			
			System.out.println("enter name:");
			pmst.setString(2, src.next());
			
			System.out.println("enter email:");
			pmst.setString(3, src.next());
			
			System.out.println("enter password:");
			pmst.setString(4, src.next());
			
			System.out.println("enter provide id:");
			pmst.setInt(5, src.nextInt());
			
	
			int i=pmst.executeUpdate();
			if(i>0)
			{
				System.out.println("updated sucessfully..!");
			}
			else
			{
				System.out.println("error..!");	
			}
			conn.close();
			pmst.close();
			src.close();
						
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
