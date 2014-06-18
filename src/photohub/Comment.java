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
 *���������������û�������ص�����
 *�������۵�ɾ��
 */
public class Comment {
	/**
	 * �����ݿ������ص�����
	 * ����ʧ�ܻ���лع�
	 * @param CommentID
	 * 			����ID
	 * @param PictureID
	 * 			������ͼƬ��ID
	 * @param CommentMess
	 * 			��������
	 * @param CommentOwner
	 * 			������
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
			String CommentTime = sdf.format(now);// ���ع涨��ʽ���ַ������ַ�����ʾʱ��
			CommentPst.setString(3, CommentMess);
			CommentPst.setString(4, CommentOwner);
			CommentPst.setString(5, CommentTime);
			CommentPst.executeUpdate();
			CommentPst.close();
		  //	conn.commit();
		    
		    }
		    //ͬ�����벻�ɹ�Ҫ���лع�
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
	 * ɾ��ĳһ�����ۣ�ֻ�������߻��߱������߲����ʸ�ɾ��
	 * @param CommentID   ��Ҫɾ�������۵�ID
	 * @param Operater	ɾ������ִ����,��session��ȡ��
	 * @String CommentOwner  ���۵�ӵ����,Ҳ���Ǳ�����ͼƬ��ӵ����
	 * @return ɾ���ɹ�����true��ʧ�ܷ���false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean DeleteComment(String CommentID,String CommentOwner,String Operater) throws SQLException, ClassNotFoundException{
		Comment Lookup = new Comment();
		ResultSet CommentDetails = Lookup.LookupComment(CommentID);
		if((!Operater.equals(CommentDetails.getString("Commenter")))&&!Operater.equals(CommentOwner))
			return false;  //���޸�Ȩ��
		Connection conn = null;
  		try {
			//conn = jdbcPool.getDataSource().getConnection();
  			 conn = JdbcPool.getDataSource();
  		    	Statement deleteAdminSendMessageStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
  		    	deleteAdminSendMessageStmt.executeUpdate("delete from comments where CommentID = '"+CommentID+"'"); 
  		}
  		//�������ɹ�Ҫ���лع�
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
	 * ��ѯĳһ�����۵���ϸ��Ϣ
	 * @param CommentID
	 * ����ID
	 * @return
	 * ���ز�ѯ�õ��Ľ����
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


