package de.l3s.workive.analysis.docs;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

import de.l3s.workive.analysis.jaxb.Document;


public class XMLUtils {

	public <T> T read(File f, Class<T> class1) throws IOException {
		String xmlstr = FileUtils.read(f);

		return read(xmlstr, class1);

	}

	/*
	 * public String repairXML(InputStream xml) throws
	 * ParserConfigurationException, SAXException, UnsupportedEncodingException
	 * {
	 * 
	 * Reader reader = new InputStreamReader(xml,"UTF-8");
	 * 
	 * InputSource is = new InputSource(reader); is.setEncoding("UTF-8");
	 * 
	 * SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
	 * //parser.p
	 * 
	 * //SAXParser parser=new saxParser.parse(is, handler); }
	 */
	/*
	 * public void readwritefromXML(XMLPictureSet pictureset) { try{ JAXBContext
	 * jc = JAXBContext.newInstance(XMLPictureSet.class); Marshaller m =
	 * jc.createMarshaller(); FileOutputStream fo=new
	 * FileOutputStream("out.xml"); m.marshal(pictureset, fo); fo.flush();
	 * fo.close();
	 * 
	 * 
	 * jc = JAXBContext.newInstance(XMLPictureSet.class); Unmarshaller um =
	 * jc.createUnmarshaller(); pictureset = (XMLPictureSet) um.unmarshal(new
	 * java.io.FileInputStream("out.xml" )); }catch(IOException e) {
	 * e.printStackTrace(); } catch (JAXBException e) { e.printStackTrace(); } }
	 */

	public static boolean isPureAscii(String v) {
		byte bytearray[] = v.getBytes();
		CharsetDecoder d = Charset.forName("US-ASCII").newDecoder();
		try {
			CharBuffer r = d.decode(ByteBuffer.wrap(bytearray));
			r.toString();
		} catch (CharacterCodingException e) {
			return false;
		}
		return true;
	}

	public static String stripNonASCII(String ret) {
		char[] chars = ret.toCharArray();
		CharsetDecoder d = Charset.forName("US-ASCII").newDecoder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			try {
				char c = chars[i];
				String letter = new String(new char[] { c });
				byte bytearray[] = letter.getBytes();
				CharBuffer r = d.decode(ByteBuffer.wrap(bytearray));
				r.toString();
				sb.append(c);
			} catch (CharacterCodingException e) {

			}
		}
		return sb.toString();
	}

	public <T> T read(String xml, Class<T> class1) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(class1);
			Unmarshaller u = jc.createUnmarshaller();
			return class1.cast(u.unmarshal(new StringReader(xml)));// class1.cast(o);
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		throw new ClassCastException("XML content does not represent class "
				+ class1);

	}
	public void write(Document class1)
	{
		JAXBContext jc;
		StringWriter xmlWriter  = new StringWriter();
		try {
			jc = JAXBContext.newInstance(Document.class);
			Marshaller m = jc.createMarshaller();
			 m.marshal(class1,  xmlWriter);
			 System.out.println(xmlWriter);
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		throw new ClassCastException("XML content does not represent class "
				+ class1);
	}


	
}
