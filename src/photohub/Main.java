package photohub;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

public class Main {
	public static void main(String[] args) throws SQLException, ServletException, IOException {
	/*	TableUser.InvertUser("wangqi@gmail.com", "wangqi", "wangqi");
		TableUser.InvertUser("puyang@gmail.com", "puyang", "puyang");
		TableUser.InvertUser("mengzhanshuai@gmail.com", "mengzhanshuai", "mengzhanshuai");
		TableUser.InvertUser("tangshunlei@gmail.com", "tangshunlei", "tangshunlei");
		TableUser.UpdateBorndate(1, "1");
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
//		Upload.UpLoadPhoto("E://allen.jpg", "wangqi.jpg");
/*		TablePhoto.InvertPhoto(12345,"12345", TablePhoto.photoID());
		TablePhoto.InvertPhoto(13234,"asdasd", TablePhoto.photoID());
		TablePhoto.InvertPhoto(56899,"l;,l;,,", TablePhoto.photoID());
		TablePhoto.InvertPhoto(56756,"wangqiwad", TablePhoto.photoID());
		TablePhoto.InvertPhoto(19023,"&*&(*^", TablePhoto.photoID());
*/		ArrayList <String>a = TablePhoto.photo();
		int num = a.size();
		System.out.println(num);
		for(int i = 0 ; i < num ; i ++)
			System.out.println(a.get(i).toString());
	}
}
