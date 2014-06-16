package photohub;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import PhotoFilter.PicUtil;

public class Main {
	public static void main(String[] args) throws SQLException, ServletException, IOException {
	//	TableUser.InvertUser("wangqi@gmail.com", "wangqi", "wangqi",70000);
	//	TableUser.InvertUser("puyang@gmail.com", "puyang", "puyang",80000);
	//	TableUser.InvertUser("mengzhanshuai@gmail.com", "mengzhanshuai", "mengzhanshuai",90000);
	//	TableUser.InvertUser("tangshunlei@gmail.com", "tangshunlei", "tangshunlei",10000);
	/*	TableUser.UpdateBorndate(1, "1");
		TableUser.UpdateHead(1, "2");
		TableUser.UpdateIntroduction(1, "3");
		TableUser.Updatepassword(1, "4");
		TableUser.UpdateSex(1, 5);
		TableUser.UpdateUsername(1, "6");
	*/	
		/*
		System.out.println("1:born " + TableUser.borndate(1));
		System.out.println("1:email " + TableUser.email(1));
		System.out.println("1:head " + TableUser.head(1));
		System.out.println("1:introduction " + TableUser.introduction(1));
		System.out.println("1:pass " + TableUser.password(1));
		System.out.println("1:sex " + TableUser.sex(1));
		System.out.println("1:name " + TableUser.username(1));
		System.out.println(TableUser.signIn("email", "4"));
		System.out.println(TableUser.signIn("wangqi", "hello"));
		System.out.println(TableUser.signIn("email", "7346"));
		System.out.println(TableUser.signIn("ajaksldjl", "4"));
		System.out.println(TableUser.emailOccupied("wangqi"));
		System.out.println(TableUser.emailOccupied("email"));
		System.out.println(TableUser.emailOccupied("q2hakjshdlkaj"));
		System.out.println("sign in " + TableUser.signIn("wangqi@gmail.com", "wangqi"));
*/

	//	Upload.UpLoadPhoto("E://allen.jpg", "12312");
/*		TablePhoto.InvertPhoto(12345,"12345", TablePhoto.photoID());
		TablePhoto.InvertPhoto(13234,"asdasd", TablePhoto.photoID());
		TablePhoto.InvertPhoto(56899,"l;,l;,,", TablePhoto.photoID());
		TablePhoto.InvertPhoto(56756,"wangqiwad", TablePhoto.photoID());
		TablePhoto.InvertPhoto(19023,"&*&(*^", TablePhoto.photoID());
		ArrayList <String>a = TablePhoto.photo();
		int num = a.size();
		System.out.println(num);
		for(int i = 0 ; i < num ; i ++)
			System.out.println(a.get(i).toString());
*/
	//	BufferedImage originalPic = ImageIO.read(new FileInputStream(imgPath)); 
//		PicUtil.getDlurPicture("E://iverson.jpg", "E://1.jpg");
//		PicUtil.getGrayPicture("E://iverson.jpg", "E://2.jpg");
//		PicUtil.getPicEdge("E://iverson.jpg", "E://3.jpg");
//		PicUtil.getSharperPicture("E://iverson.jpg", "E://4.jpg");
//		PicUtil.gray("E://iverson.jpg", "E://5.jpg");
//		PicUtil.pressText("BINGO", "E://iverson.jpg", "E://6.jpg");
		
/*		ArrayList <PhotoInfo>a = TablePhoto.photoList();
		int num = a.size();
		System.out.println(num);
		for(int i = 0 ; i < num ; i ++)
			System.out.println(a.get(i).photo);
		
		System.out.println(TablePhoto.photoList().toString());
		System.out
				.println((new String(
						"E:\\Tomcat\\apache-tomcat-7.0.47-windows-x64\\apache-tomcat-7.0.47\\webapps\\PhotoHub\\photo\\82830.44bec144t9a1b082baf67&690.jpg"))
						.replaceAll("\\\\", "\\\\\\\\"));
		String filename = "9-1-193474-1-34-163-20081225072400.jpg";
		System.out.println(filename.substring(filename.lastIndexOf(".") + 1));
	*/
		//TablePhoto.updateIntroduction(71314, "NBA");
		Comment.AddComment("asd", "asd", "asdad", "asdad");
	}
}
