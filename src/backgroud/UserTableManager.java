package backgroud;

/**
 * 这个类主要用来集成与用户成员表有关的一些操作
 * @author mzs
 *created on 2014-5-11
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import javax.naming.*;
import javax.sql.*;

//import background.JdbcPool;

//import org.json.JSONException;

public class UserTableManager {
	/**
	 * 无参默认构造函数
	 */
    public UserTableManager() throws NamingException{
		/**************************************
		 * 
		 */
	}
    /**
     * 根据用户名查找用户资料
     * @param name
     * @return
     * 	返回查询得到的结果集
     * @throws SQLException
     * @throws NamingException
     * @throws ClassNotFoundException
     */
    public static ResultSet getUserDetails(String name) throws SQLException, NamingException, ClassNotFoundException  {
		 Connection conn = null;
		// conn = ((DataSource)jdbcPool.getDataSource()).getConnection();
		conn = JdbcPool.getDataSource();
		PreparedStatement pstmt = conn.prepareStatement("select * from user where name = ?");
		pstmt.setString(1, name);
		ResultSet memberDetailsResultSet = pstmt.executeQuery();
		return memberDetailsResultSet;
		
	}
   /**
    * 用户注册
    * @param name
    * @param passWd
    * @param sex
    * @param birthDate
    * @param imagePath
    */
    public void userRegister(String name,String passWd,int sex,String birthDate,String imagePath){
	    PreparedStatement userRegsPst;
	    Connection conn = null;
	    try {
		//conn = jdbcPool.getDataSource().getConnection();
		conn = JdbcPool.getDataSource();
		userRegsPst = conn.prepareStatement("insert into user (name,passWd,registerDate,sex,birthDate,age,imagePath) values (?,?,?,?,?,?,?)");
		userRegsPst.setString(1, name);
		userRegsPst.setString(2, passWd);
		String format = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date now = new Date();
		String  registerTime = sdf.format(now);// 返回规定格式的字符串，字符串表示时间
		userRegsPst.setString(3, registerTime);
		userRegsPst.setInt(4, sex);
		userRegsPst.setString(5, birthDate);
		sdf = new SimpleDateFormat("yyyy-MM-dd"); //输入的出生日期也应该是这种格式
		Date birthTime = sdf.parse(birthDate);
		Date nowTime = new Date();
		int age = nowTime.getYear() - birthTime.getYear();
		userRegsPst.setInt(6, age);
		userRegsPst.setString(7, imagePath);
		userRegsPst.executeUpdate();
		userRegsPst.close();
	  //	conn.commit();
	    
	    }
	    //同样插入不成功要进行回滚
	    catch (SQLException e) {
		// TODO Auto-generated catch block
	    	e.printStackTrace();
	    	try {
	    		conn.rollback();
	    	} catch (SQLException e1) {
			// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } catch (ParseException e) {
		// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    finally {
	    	try {
	    		conn.close();
	    	} catch (SQLException e) {
			// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
		
		
    }
    /**
     * 登陆时验证用户名和密码，返回boolean型
     * @param name
     * @param passWd
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean  login(String name,String passWd) throws SQLException, ClassNotFoundException{
		Connection conn = null;
		//conn = (jdbcPool.getDataSource()).getConnection();
		conn = JdbcPool.getDataSource();
		Statement loginPst = conn.createStatement();
		ResultSet loginResultSet = loginPst.executeQuery("select * from user where name = '" + name +"' and passWd = '"+passWd+"'");
		return loginResultSet.next();
	}
    
   /**
    * 修改用户资料，原子操作上锁
    * @param name
    * @param passWd
    * @param sex
    * @param birthDate
    * @param imagePath
    * 		头像，存储的是在服务器中路径
    * @return
    * @throws SQLException
    * @throws NamingException
    * @throws ClassNotFoundException
    * @throws ParseException
    */
    public synchronized boolean modifyUserData(String name, String passWd, int sex, String birthDate, String imagePath) throws SQLException, NamingException, ClassNotFoundException, ParseException {
		Connection conn = null;
		if(!getUserDetails(name).next())
			return false;  //查无此人，错误
		conn = JdbcPool.getDataSource();
		Statement modifyMemberStmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet modifyMemberResultSet = modifyMemberStmt
				.executeQuery("select * from user where name = '" + name +"'");
		modifyMemberResultSet.next();
		modifyMemberResultSet.updateString("passWd", passWd);
		modifyMemberResultSet.updateInt("sex", sex);
		modifyMemberResultSet.updateString("birthDate", birthDate);
		modifyMemberResultSet.updateString("imagePath", imagePath);
			/* 这里要改年龄,从现在的年份得到 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthTime = sdf.parse(birthDate);
		Date nowTime = new Date();
		int age = nowTime.getYear() - birthTime.getYear();
		modifyMemberResultSet.updateInt("age", age);
		modifyMemberResultSet.updateRow();
		modifyMemberResultSet.close();
		modifyMemberStmt.close();
		conn.close();
		return true;
	}
   
	
    
	
	
}
