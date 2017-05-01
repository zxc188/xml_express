package Filein;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Fileinput {
	public static Document input(String path){
		Document document=null;
		try{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbf.newDocumentBuilder();
			document=builder.parse(new File(path));
		}catch(Exception e){
		e.printStackTrace();	
		}
		return document;
	}
	public static void save(String path,Document document){
		try{
			DOMSource source=new DOMSource(document);                   //以converted.xml文件构造一个StreamResult对象，用于保存转换后结果。 
	        StreamResult result=new StreamResult(new File(path));   
	        TransformerFactory tff = TransformerFactory.newInstance();  //得到转换器工厂类的实例 
	         //创建一个新的转换器，用于执行恒等转换， 
	         //即直接将DOM输入源的内容复制到结果文档中。 
	        Transformer tf = tff.newTransformer(); 
	        tf.transform(source, result);
	        System.out.println("保存完成");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
