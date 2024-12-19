package db1;
import java.security.PrivateKey;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.util.Scanner;
	
public class cdb1 {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String username="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement psmt;
	
	public static void main(String[] args)
	{
		try {
			
			Scanner scr=new Scanner(System.in);
			
			Class.forName(Driver);
			conn=DriverManager.getConnection(url,username,password);
			
			System.out.println("enter database:");
			String sql="create database "+scr.next();
			
			PreparedStatement psmt=conn.prepareStatement(sql);
			int i=psmt.executeUpdate();
			if(i>0)
			{
				System.out.println("sucessfully created..!");
			}
			else
			{
				System.out.println(" error");
			}
			
			
			conn.close();
			psmt.close();
		
				}
		catch (Exception e) {
			System.out.println("already exists ..!");
		}
		
	}	 
	
	

}
