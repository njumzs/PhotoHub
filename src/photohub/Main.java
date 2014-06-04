package photohub;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
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
	*/	System.out.println("1:born " + TableUser.borndate(1));
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


	}
}
