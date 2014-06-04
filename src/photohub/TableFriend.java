package photohub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableFriend
{
	public static void InvertFriend(int id1 , int id2)
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
			String a = "INSERT INTO user VALUES('" + id1 + "','" + id2 + "')";
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
	public static int [] friendList(int id)
	{
		int[] list = new int[20];
		list[0] = 0;
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
			rs = stmt.executeQuery("SELECT * FROM friends");
			while(rs.next())
			{
				int id1 = rs.getInt("ID1");
				int id2 = rs.getInt("ID2");
				if(id1 == id)
				{
					list[0] ++;
					list[list[0]] = id1;
				}
				else
				{
					list[0] ++;
					list[list[0]] = id2;
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
		return list;	
	}
}
