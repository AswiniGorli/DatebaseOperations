package db1;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class getbyemail {
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
			String sql="select * from regdetails "+src.next()+" where email=?";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst=conn.prepareStatement(sql);
			System.out.println("enter email:");
			pmst.setString(1, src.next());
			ResultSet rs=pmst.executeQuery();
			while(rs.next())
			{
				System.out.println("id: "+rs.getInt("id"));
				System.out.println("name: "+rs.getString("name"));
				System.out.println("email: "+rs.getString("email"));
				System.out.println("password: "+rs.getString("password"));
				
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
