package Filein;

import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Operating.DelandAdd;
import Operating.Find;
import Operating.Modify;
import Operating.login;
import Operating.show;

public class Student{
	private static Document document_user;
	private static Element user_root;
	private static Document document_student;
	private static Element student_root;
	private static int choose=0;
	public static void main(String[] args) {
		document_user=Fileinput.input("user.xml");
		user_root=document_user.getDocumentElement();//得到user的根节点
		document_student=Fileinput.input("student.xml");
		student_root=document_user.getDocumentElement();//得到student的根节点
		Scanner input=new Scanner(System.in);
		login l=new login(user_root);
		/*
		 * 获取登录标志    若果为 1 则为管理员登录，若为 2 则为用户登录 
		 * */
		int blo=l.IN();
		System.out.println("\n欢迎登陆\t"+blo);
    	switch(blo){
			/*
			 * 管理员登录，允许进行   删除，查找，增加  操作
			 * 管理员禁止增加管理员账户
			 * */
			case 1:
				while(choose!=4){
					System.out.println("0.查看全部信息\t1.查找 \t\t2.删除\t\t3.增加\t\t4.退出");
				    choose=input.nextInt();
				    switch(choose){
				    	case 0:
				    		show s=new show(document_student,document_user);
				    		s.show_all();
				    		System.out.println();
				    		break;
				    	case 1:
				    		Find f=new Find(document_student,document_user);
				    		f.find_one();
				    		System.out.println();
				    		break;
				    	case 2:
				    		DelandAdd del=new DelandAdd(document_student,document_user);
				    		del.delete();
				    		break;
				    	case 3:
				    		DelandAdd del2=new DelandAdd(document_student,document_user);
				    		del2.add();
				    		break;
				    	case 4:
				    		System.out.println("!!!EXIT!!!");
				    		break;
				    }
				}
				break;
			/*
			 * 普通永不登录，允许进行   修改,查看个人  操作
			 * */
			case 2:
				while(choose!=4){
					System.out.println("1.修改\t\t2.查看个人信息\t\t4.退出");
					choose=input.nextInt();
					switch(choose){
						case 1:
							Modify m=new Modify(document_user,document_student);
							m.change(l.get_username());
							break;
						case 2:
							System.out.println("number\tname\tsex\tage\tphone");
							show s=new show(document_student,document_user);
							Person p=s.show_only(l.get_username());
							System.out.println(p.getNumber()+"\t"+p.getName()+"\t"+p.getSex()+"\t"+p.getAge()+"\t"+p.getPhone()+"\n");
							break;
						case 4:
							System.out.println("!!!EXIT!!!");
							break;
					}
				}
				break;
			}
		
	}
}
