package Operating;

import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import Filein.Person;

public class Find {
	private String username;
	private Document document_user;
	private Document document_student;
	
	public Find(Document document1,Document document2){
		this.document_student=document1;
		this.document_user=document2;
	}
	
	public void find_one(){
		show s=new show(document_student,document_user);
		Element user_root=document_user.getDocumentElement();
		NodeList user_childs=user_root.getChildNodes();
		System.out.println("请输入查询的number");
		Scanner input=new Scanner(System.in);
		username=input.nextLine();
		System.out.println("\nnumber\tname\tage\tsex\tphone\t\tpassword");
		for(int i=0;i<user_childs.getLength();i++){
			if(user_childs.item(i).getNodeType()!=3){
				if(user_childs.item(i).getFirstChild().getNodeValue().equals(username)){
					Person p=s.show_only(username);
					NamedNodeMap user_information=user_childs.item(i).getAttributes();
					String password=user_information.getNamedItem("password").getFirstChild().getNodeValue();
					System.out.println(p.getNumber()+"\t"+p.getName()+"\t"+p.getSex()+"\t"+p.getAge()+"\t"+p.getPhone()+"\t"+password);
				}
			}
		}
	}
}
