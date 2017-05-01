package Operating;

import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import Filein.Fileinput;

public class DelandAdd {
	private Document document_student;
	private Document document_user;
	
	public DelandAdd(Document d1,Document d2){
		document_student=d1;
		document_user=d2;
	}
	
	public void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你要删除的学生的学号");
		String number=input.nextLine();
		Element student_root=document_student.getDocumentElement();
		NodeList students=student_root.getChildNodes();
		Element user_root=document_user.getDocumentElement();
		NodeList users=user_root.getChildNodes();
		/*
		 * 删除studnet.xml文件中的信息
		 * */
		for(int i=0;i<students.getLength();i++){
			if(students.item(i).getNodeType()!=3){
			NamedNodeMap student_iformation=students.item(i).getAttributes();
			if(student_iformation.getNamedItem("number").getNodeValue().equals(number)){
				student_root.removeChild(students.item(i));
				Fileinput.save("student.xml", document_student);
				break;
				}
			}
		}
		/*
		 * 删除user.xml中的信息
		 * */
		for(int i=0;i<users.getLength();i++){
			if(users.item(i).getNodeType()!=3){
			if(users.item(i).getFirstChild().getNodeValue().equals(number)){
				user_root.removeChild(users.item(i));
				Fileinput.save("user.xml", document_user);
				break;
				}
			}
		}
	}
	
	public void add(){
		Scanner input=new Scanner(System.in);
		System.out.println("请按顺序输入  学号   姓名   年龄   性别   电话号码   密码");
		String number=input.nextLine();
		String name=input.nextLine();
		String age=input.nextLine();
		String sex=input.nextLine();
		String phone=input.nextLine();
		String password=input.nextLine();
		/*
		 * 向student.xml文件中增加数据
		 * */
		Element student_root=document_student.getDocumentElement();
		Element newstudent=document_student.createElement("Student");
		newstudent.setAttribute("age", age);
		newstudent.setAttribute("number", number);
		newstudent.setAttribute("sex", sex);
		Element newname=document_student.createElement("name");
		Text nametext=document_student.createTextNode(name);
		newname.appendChild(nametext);
		Element newphone=document_student.createElement("phone");
		Text photext=document_student.createTextNode(phone);
		newphone.appendChild(photext);
		newstudent.appendChild(newname);
		newstudent.appendChild(newphone);
		student_root.appendChild(newstudent);
		Fileinput.save("student.xml", document_student);
		/*
		 * 向user.xml文件中增加数据
		 * */
		Element user_root=document_user.getDocumentElement();
		Element newuser=document_user.createElement("username");
		Text usertext=document_user.createTextNode(number);
		newuser.appendChild(usertext);
		newuser.setAttribute("blo", "2");
		newuser.setAttribute("password", password);
		user_root.appendChild(newuser);
		Fileinput.save("user.xml", document_user);
	}
	
}

