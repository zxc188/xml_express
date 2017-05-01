import java.io.File;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Xml_main {
	private static Document document;
	private static Element StudentInformation;                         //学生信息节点
	private static NodeList list;                                      //得到学生信息节点的子节点
	private static Node  student;                                      //第一个学生节点
	private static Element newstudent;                                  //新学生的节点
	private static NamedNodeMap studentmap;                             //第一个学生节点的属性节点
	private static String path="a.xml";                                 //原始的文件路径
	private static String newpath="b.xml";                              //目的保存路径
	public static void main(String[] args) {

		int i;
		try{
			document=XmlInto.input(path);
			StudentInformation=document.getDocumentElement();          //获得根节点
			newstudent=document.createElement("学生");                  //生成一个新的节点
			newstudent.setAttribute("班级", "0802");                    //设置属相
			newstudent.setAttribute("学号", "002");
			Element name=document.createElement("姓名");
			Element age=document.createElement("年龄");
			Element email2=document.createElement("email");
			name.appendChild(document.createTextNode("李四"));          //设置属相的text
			age.appendChild(document.createTextNode("19"));
			email2.appendChild(document.createTextNode("ls@tom.com"));
			newstudent.appendChild(name);
			newstudent.appendChild(age);
			newstudent.appendChild(email2);
			StudentInformation.appendChild(newstudent);
			Element email=document.createElement("email");
			Text emailtext=document.createTextNode("zs@tom.com");
			email.appendChild(emailtext);
			list=StudentInformation.getChildNodes();			        //获得根节点的子节点
			student=list.item(1);
			studentmap=student.getAttributes();			                //得到student的所有属性
			studentmap.removeNamedItem("性别");                           //删除student的属相值为"性别"的属性
			for(i=0;i<4;i++){                                           //循环删除student节点的节点
				student.removeChild(student.getLastChild());
			}
			student.appendChild(email);                                 //添加节点
			DOMSource source=new DOMSource(document);                   //以converted.xml文件构造一个StreamResult对象，用于保存转换后结果。 
	        StreamResult result=new StreamResult(new File(newpath));   
	        TransformerFactory tff = TransformerFactory.newInstance();  //得到转换器工厂类的实例 
	         //创建一个新的转换器，用于执行恒等转换， 
	         //即直接将DOM输入源的内容复制到结果文档中。 
	        Transformer tf = tff.newTransformer(); 
	        tf.transform(source, result); 	                            //执行转换 
            System.out.println("成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
