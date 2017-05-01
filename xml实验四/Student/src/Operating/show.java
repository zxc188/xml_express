package Operating;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import Filein.Person;

public class show {
	private  Document document_student;
	private Document document_user;
	public show(Document document,Document document2){
		this.document_student=document;
		this.document_user=document2;
	};
	/*
	 * 返回一个person对象，这个对象的number为username
	 * */
	public  Person show_only(String username){
		Person p=new Person();
		Element student=document_student.getDocumentElement();
		NodeList students=student.getChildNodes();
		for(int i=0;i<students.getLength();i++){
			if(students.item(i).getNodeType()!=3){
				NamedNodeMap map=students.item(i).getAttributes();
				if(map.getNamedItem("number").getFirstChild().getNodeValue().equals(username)){
					NodeList student_information=students.item(i).getChildNodes();
					p.setAge(map.getNamedItem("age").getFirstChild().getNodeValue());
					p.setSex(map.getNamedItem("sex").getFirstChild().getNodeValue());
					p.setNumber(map.getNamedItem("number").getFirstChild().getNodeValue());
					p.setName(student_information.item(1).getFirstChild().getNodeValue());
					p.setPhone(student_information.item(3).getFirstChild().getNodeValue());
					break;
				}			
			}
		}
		return p;
	}
	/*
	 * 利用上面的show_only方法来查看所有成员的信息
	 * */
	public void show_all(){
		System.out.println("number\tname\tage\tsex\tphone\t\tpassword");
		Element user_root=document_user.getDocumentElement();
		NodeList user_childs=user_root.getChildNodes();
		for(int i=0;i<user_childs.getLength();i++){
			if(user_childs.item(i).getNodeType()!=3){
				if(!user_childs.item(i).getFirstChild().getNodeValue().equals("admin")){
					String username=user_childs.item(i).getFirstChild().getNodeValue();
					Person p=show_only(username);
					NamedNodeMap user_information=user_childs.item(i).getAttributes();
					String password=user_information.getNamedItem("password").getFirstChild().getNodeValue();
					System.out.println(p.getNumber()+"\t"+p.getName()+"\t"+p.getSex()+"\t"+p.getAge()+"\t"+p.getPhone()+"\t"+password);
				}
			}
		}
	}
}
