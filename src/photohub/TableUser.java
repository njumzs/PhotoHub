package photohub;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;   
import java.sql.ResultSet;
import java.util.Random;

import com.mysql.jdbc.Driver;

public class TableUser 
{
	@SuppressWarnings("resource")
	public static int userID()
	{
		Random rand = new Random();
		int randNum = rand.nextInt(90000) + 10000;
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID FROM user");
			
			while(rs.next())
			{
				int temp = rs.getInt("ID");
				if(randNum == temp)
				{
					randNum = rand.nextInt(90000) + 10000;
					rs = stmt.executeQuery("SELECT ID FROM user");
				}
			}
			return randNum;
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return randNum;
	}
	public static void InvertUser(String email, String password, String username, int ID) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
		
			String a = "INSERT INTO user VALUES('" + ID + "','" + email + "','" + password + "','"
					+ username + "','" + 0 + "','','" + "F:\\tslstanley\\Software Engineering\\Workspace\\userdefault.svg" + "','')";
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void UpdateUsername(int id,  String username) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set username = " + username + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void Updatepassword(int id, String password) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set password = " + password + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void UpdateSex(int id, int sex) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set sex = " + sex + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void UpdateBorndate(int id, String borndate) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set borndate = " + borndate + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void UpdateHead(int id, String head) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set head = " + head + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void UpdateIntroduction(int id, String introduction) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set introduction = " + introduction + " where id = " + id;
			stmt.executeUpdate(a);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	@SuppressWarnings("resource")
	public static boolean emailOccupied(String email) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT email FROM user");
			while(rs.next())
			{
				String a = rs.getString("email");
				if(a.equals(email))
					return true;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}
	@SuppressWarnings("resource")
	public static int signIn(String email, String password) throws SQLException
	{

		//����������
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while(rs.next())
			{
				String a = rs.getString("email");
				String b = rs.getString("password");
				if(a.equals(email) && b.equals(password))
				{
					int userID = rs.getInt("id");
					return userID;
				}
					
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return -1;
	}
	public static String username(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("username");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;	
	}
	public static String email(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("email");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;	
	}
	public static String password(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("password");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;	
	}
	public static int sex(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				int a = rs.getInt("sex");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return 0;	
	}
	public static String borndate(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("borndate");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;	
	}
	public static String head(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("head");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;	
	}
	public static String introduction(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//����//���ݿ���ʽ
		Statement stmt = null;
		//���������
		ResultSet rs = null;
		//�������ݿ�����
		Connection conn = null;
		try{
			// ������������
			Class.forName(driver);
			//�������ݿ�
			conn = DriverManager.getConnection(URL, "root", "");
			//�鿴�Ƿ����ӳɹ�
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user where id = " + id);
			while(rs.next())
			{
				String a = rs.getString("introduction");
				return a;
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception ex) { 
				ex.printStackTrace();
			}
		}
		return null;	
	}
	
}


