package photohub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//import background.jdbcPool;

/**
 * @author mzs
 *created on 2014-5-19
 *本类用来处理与用户评级相关的内容
 *包括评价得删除
 */
public class Comment {
	/**
	 * 在数据库插入相关的评论
	 * 插入失败会进行回滚
	 * @param CommentID
	 * 			评论ID
	 * @param PictureID
	 * 			被评论图片的ID
	 * @param CommentMess
	 * 			评论内容
	 * @param CommentOwner
	 * 			评论者
	 */
	public static void AddComment(String CommentID,String PictureID,String CommentMess,String CommentOwner){
		 PreparedStatement CommentPst;
		  Connection conn = null;
		    try {
			//conn = jdbcPool.getDataSource().getConnection();
			conn = JdbcPool.getDataSource();
			
			
			Random rand = new Random();
			int randNum = rand.nextInt(90000) + 10000;
			
			
			PreparedStatement pstmt = conn.prepareStatement("select * from comments ");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				String a =  rs.getString("commentID"); 
				if(a.equals("" + randNum))
				{
					randNum = rand.nextInt(90000) + 10000;
					pstmt = conn.prepareStatement("select * from comments ");
					rs = pstmt.executeQuery();
				}
			}
			
			
			
			CommentPst = conn.prepareStatement("insert into comments (CommentID,PictureID,CommentMess,CommentOwner,CommentTime) values (?,?,?,?,?)");
			
			
			
			CommentPst.setString(1,randNum + "");
			CommentPst.setString(2, PictureID);
			String format = "yyyy-MM-dd HH:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date now = new Date();
			String CommentTime = sdf.format(now);// 返回规定格式的字符串，字符串表示时间
			CommentPst.setString(3, CommentMess);
			CommentPst.setString(4, CommentOwner);
			CommentPst.setString(5, CommentTime);
			CommentPst.executeUpdate();
			CommentPst.close();
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
	 * 删除某一条评论，只有评论者或者被评论者才有资格删除
	 * @param CommentID   需要删除的评论的ID
	 * @param Operater	删除操作执行者,从session中取到
	 * @String CommentOwner  评论的拥有者,也就是被评论图片的拥有者
	 * @return 删除成功返回true，失败返回false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean DeleteComment(String CommentID,String CommentOwner,String Operater) throws SQLException, ClassNotFoundException{
		Comment Lookup = new Comment();
		ResultSet CommentDetails = Lookup.LookupComment(CommentID);
		if((!Operater.equals(CommentDetails.getString("Commenter")))&&!Operater.equals(CommentOwner))
			return false;  //无修改权限
		Connection conn = null;
  		try {
			//conn = jdbcPool.getDataSource().getConnection();
  			 conn = JdbcPool.getDataSource();
  		    	Statement deleteAdminSendMessageStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
  		    	deleteAdminSendMessageStmt.executeUpdate("delete from comments where CommentID = '"+CommentID+"'"); 
  		}
  		//操作不成功要进行回滚
  		catch (SQLException e) {
			// TODO Auto-generated catch block
  			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} /*catch (NamingException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} */catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	     finally{
 	    	conn.close();
 	     }
		    	return true;
 	  	
	}
	
	/**
	 * 查询某一条评论的详细信息
	 * @param CommentID
	 * 评论ID
	 * @return
	 * 返回查询得到的结果集
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static ResultSet LookupComment(String CommentID) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		// conn = ((DataSource)jdbcPool.getDataSource()).getConnection();
		conn = JdbcPool.getDataSource();
		PreparedStatement pstmt = conn.prepareStatement("select * from comments where CommentID = ?");
		pstmt.setString(1, CommentID);
		ResultSet CommentDetailsResultSet = pstmt.executeQuery();
		
		return CommentDetailsResultSet;
		
	}
	public static ArrayList<CommentInfo> commentlist(int photoID) throws SQLException, ClassNotFoundException
	{
		
		Connection conn = null;
		// conn = ((DataSource)jdbcPool.getDataSource()).getConnection();
		conn = JdbcPool.getDataSource();
		PreparedStatement pstmt = conn.prepareStatement("select * from comments where pictureID = ?");
		pstmt.setString(1, photoID + "");
		ResultSet CommentDetailsResultSet = pstmt.executeQuery();
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		while(CommentDetailsResultSet.next())
		{
			 CommentInfo a = new  CommentInfo();
			 a.time = CommentDetailsResultSet.getString("commentTime");
			 a.userName = CommentDetailsResultSet.getString("commentowner");
			 a.commentMess = CommentDetailsResultSet.getString("commentMess");
			 list.add(a);
		}
		return list;
	}
	
		
}


