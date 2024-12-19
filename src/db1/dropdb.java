package db1;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class dropdb {

	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner src=new Scanner(System.in);
		
		try {
		
			Class.forName(Driver);
conn=DriverManager.getConnection(url,username,password);
			
			System.out.println("enter database:");
	
			String sql="drop database "+src.next();
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0)
			{
				System.out.println("sucessfully deleted..!");
			}
			else
			{
				System.out.println(" error");
			}
			pmst.executeUpdate();
			conn.close();
			pmst.close();
		
				}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	
}