package Operating;

import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import Filein.Fileinput;

public class Modify {
	private static Document document_user;
	private static Document document_student;
	private static String s1,s2;
	public Modify(Document document1,Document document2){
		this.document_user=document1;
		this.document_student=document2;
	}
	public void change(String username){
		Scanner input=new Scanner(System.in);
		s1=input.nextLine();
		s2=input.nextLine();
		if(s1.equals("password")){
			Element user=document_user.getDocumentElement();
			NodeList users=user.getChildNodes();
			for(int i=0;i<users.getLength();i++){
				if(users.item(i).getNodeType()!=3){
					if(users.item(i).getFirstChild().getNodeValue().equals(username)){
						NamedNodeMap map=users.item(i).getAttributes();
						map.getNamedItem("password").getFirstChild().setNodeValue(s2);
						Fileinput.save("user.xml", document_user);
						break;
					}
				}
			}
		}else{
			Element student=document_student.getDocumentElement();
			NodeList students=student.getChildNodes();
			for(int i=0;i<students.getLength();i++){
				if(students.item(i).getNodeType()!=3){
					NamedNodeMap map=students.item(i).getAttributes();
					if(map.getNamedItem("number").getNodeValue().equals(username)){
						if(s1.equals("sex")||s1.equals("age")){
							if(s1.equals("sex")){
								map.getNamedItem("sex").getFirstChild().setNodeValue(s2);
							}else{
								map.getNamedItem("age").getFirstChild().setNodeValue(s2);
							}
						}else{
							NodeList student_information=students.item(i).getChildNodes();
							if(s1.equals("name")){
								student_information.item(1).getFirstChild().setNodeValue(s2);
							}else{
								student_information.item(3).getFirstChild().setNodeValue(s2);
							}
						}
						Fileinput.save("student.xml", document_student);
						break;
					}
				}
				
			}
			
		}
	}
}
