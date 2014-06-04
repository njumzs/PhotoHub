package photohub;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;   
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TablePhoto 
{
	
	public static void InvertUser(int userID, String photo) throws SQLException
	{

		//驱动程序名
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT photoID FROM photo");
			int max = 0;
			while(rs.next())
			{
				int temp = rs.getInt("photoID");
				if(max < temp)
					max = temp;
			}
			max = max + 1;
			Date date = new Date();
			Date currentTime = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String dateString = formatter.format(currentTime);  
			String a = "INSERT INTO user VALUES('" + max + "','" + userID + "','" + photo + "','"
					+ dateString + "','')";
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
	public static void deleteIntroduction(int id) throws SQLException
	{

		//驱动程序名
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "update user set introduction = '' where photoID = " + id;
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
	public static void deletePhoto(int id) throws SQLException
	{

		//驱动程序名
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			String a = "delete from photo where photoid = " + id;
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
	
	public static int username(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photo where photoid = " + id);
			while(rs.next())
			{
				int a = rs.getInt("userID");
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
	public static String photo(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photo where photoid = " + id);
			while(rs.next())
			{
				String a = rs.getString("photo");
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
	public static String time(int id)
	{
		final String driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photo where photoid = " + id);
			while(rs.next())
			{
				String a = rs.getString("time");
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
		//URL指向要访问的数据库名doudou
		final String URL = "jdbc:mysql://localhost:3306/photohub";
		//创建//数据库表达式
		Statement stmt = null;
		//创建结果集
		ResultSet rs = null;
		//创建数据库连接
		Connection conn = null;
		try{
			// 加载驱动程序
			Class.forName(driver);
			//连接数据库
			conn = DriverManager.getConnection(URL, "root", "");
			//查看是否连接成功
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photo where photoid = " + id);
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


