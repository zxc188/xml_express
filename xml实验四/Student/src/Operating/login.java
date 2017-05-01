package Operating;

import java.util.Scanner;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/*
 *登录判断类
 * */

public class login {
	private static Element element;
	private static int log=0;
	private NodeList users;
	private String username;
	private String password;
	private static boolean islogin=false;
	
	public login(Element element){
		this.element=element;
	}
	
	/*
	 * 登录判断方法
	 * */
	
	public int IN(){
		Scanner input=new Scanner(System.in);
		while(log==0){
			System.out.println("用户名：           ");
		    username=input.nextLine();
			System.out.println("密码：           ");
		    password=input.nextLine();
			users=element.getChildNodes();//得到全部user节点节集合
			for(int i=0;i<users.getLength();i++){
				if(users.item(i).getNodeType()!=3){
					NamedNodeMap map =users.item(i).getAttributes();//得到user的属性节点集合
					if(users.item(i).getFirstChild().getNodeValue().equals(username)&&
						map.getNamedItem("password").getNodeValue().equals(password)){
						System.out.println("!!!登陆成功!!!");
						if(map.getNamedItem("blo").getNodeValue().equals("1")){
							log=1;
							break;
						}else if(map.getNamedItem("blo").getNodeValue().equals("2")){
							log=2;
							break;
						}
					}
				}
			}
			if(log==0){
				System.out.println("用户名或密码错误，请确认后重新登录");
			}
		}
		return log;
	}
	/*
	 * 获取用户的登录信息
	 * */
	public String get_username(){
		return username;
	}
	public String get_password(){
		return password;
	}
}