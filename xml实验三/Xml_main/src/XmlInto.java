import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlInto {
	public static Document input(String path){
		Document document=null;
		try{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbf.newDocumentBuilder();
			document=builder.parse(new File("a.xml"));
		}catch(Exception e){
		e.printStackTrace();	
		}
		return document;
	}
}
