package de.l3s.workive.analysis.docs;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class FileUtils {

	public static void main(String[] args) {
		try {
			copy("fromFile.txt", "toFile.txt");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void copy(String toFileName, String fromFileName)
			throws IOException {
		copyToDir(new File(fromFileName), new File(toFileName));

	}

	public static void copyToDir(File outDir, File... files) throws IOException {

		if (outDir == null || !outDir.isDirectory()) {
			throw new IOException("is not a directory: " + outDir);
		}
		for (File f : files) {

			if(f.isDirectory())
			{
				File newdir=new File(outDir, f.getName());
				newdir.mkdir();
				
				for(File child:f.listFiles())
				{
					copyToDir(newdir,child);
				}
			continue;
			}
			File fromFile = f;
			File toFile = outDir;
			if (!fromFile.exists())
				throw new IOException("FileCopy: " + "no such source file: "
						+ fromFile.getAbsolutePath());
			if (!fromFile.isFile())
				throw new IOException("FileCopy: " + "can't copy directory: "
						+ fromFile.getAbsolutePath());
			if (!fromFile.canRead())
				throw new IOException("FileCopy: "
						+ "source file is unreadable: "
						+ fromFile.getAbsolutePath());

			if (toFile.isDirectory())
				toFile = new File(toFile, fromFile.getName());

			if (toFile.exists()) {
				if (!toFile.canWrite())
					throw new IOException("FileCopy: "
							+ "destination file is unwriteable: "
							+ toFile.getAbsolutePath());
				System.out.print("Overwrite existing file " + toFile.getName()
						+ "? (Y/N): ");
				System.out.flush();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				String response = in.readLine();
				if (!response.equals("Y") && !response.equals("y"))
					throw new IOException("FileCopy: "
							+ "existing file was not overwritten.");
			} else {
				String parent = toFile.getParent();
				if (parent == null)
					parent = System.getProperty("user.dir");
				File dir = new File(parent);
				if (!dir.exists())
					throw new IOException("FileCopy: "
							+ "destination directory doesn't exist: " + parent);
				if (dir.isFile())
					throw new IOException("FileCopy: "
							+ "destination is not a directory: " + parent);
				if (!dir.canWrite())
					throw new IOException("FileCopy: "
							+ "destination directory is unwriteable: " + parent);
			}

			FileInputStream from = null;
			FileOutputStream to = null;
			try {
				from = new FileInputStream(fromFile);
				to = new FileOutputStream(toFile);
				byte[] buffer = new byte[4096];
				int bytesRead;

				while ((bytesRead = from.read(buffer)) != -1)
					to.write(buffer, 0, bytesRead); // write
			} finally {
				if (from != null)
					try {
						from.close();
					} catch (IOException e) {
						;
					}
				if (to != null)
					try {
						to.close();
					} catch (IOException e) {
						;
					}
			}
		}
	}

	public static String readGZIPString(File in)
	{
		Reader reader = null;
	StringWriter writer = null;
//	String charset = "UTF-8"; // You should determine it based on response header.
	String charset = "UTF-8"; // You should determine it based on response header.
	FileInputStream finstr=null;
	try {
		 finstr = new FileInputStream(in);
	    InputStream gzippedResponse = finstr;
	    InputStream ungzippedResponse = new GZIPInputStream(gzippedResponse);
	    reader = new InputStreamReader(ungzippedResponse, charset);
	    writer = new StringWriter();

	    char[] buffer = new char[10240];
	    for (int length = 0; (length = reader.read(buffer)) > 0;) {
	    	writer.write(buffer,0,length);
	    }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			writer.close();
			finstr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	}

	return writer.toString();
	}
	public static void copy(File toFile, File fromFile) throws IOException {

	
			if (!fromFile.exists())
				throw new IOException("FileCopy: " + "no such source file: "
						+ fromFile.getAbsolutePath());
			if (!fromFile.isFile())
				throw new IOException("FileCopy: " + "can't copy directory: "
						+ fromFile.getAbsolutePath());
			if (!fromFile.canRead())
				throw new IOException("FileCopy: "
						+ "source file is unreadable: "
						+ fromFile.getAbsolutePath());

			if (toFile.isDirectory())
				toFile = new File(toFile, fromFile.getName());

			if (toFile.exists()) {
				if (!toFile.canWrite())
					throw new IOException("FileCopy: "
							+ "destination file is unwriteable: "
							+ toFile.getAbsolutePath());
				System.out.print("Overwrite existing file " + toFile.getName()
						+ "? (Y/N): ");
				System.out.flush();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				String response = in.readLine();
				if (!response.equals("Y") && !response.equals("y"))
					throw new IOException("FileCopy: "
							+ "existing file was not overwritten.");
			} else {
				String parent = toFile.getParent();
				if (parent == null)
					parent = System.getProperty("user.dir");
				File dir = new File(parent);
				if (!dir.exists())
					throw new IOException("FileCopy: "
							+ "destination directory doesn't exist: " + parent);
				if (dir.isFile())
					throw new IOException("FileCopy: "
							+ "destination is not a directory: " + parent);
				if (!dir.canWrite())
					throw new IOException("FileCopy: "
							+ "destination directory is unwriteable: " + parent);
			}

			FileInputStream from = null;
			FileOutputStream to = null;
			try {
				from = new FileInputStream(fromFile);
				to = new FileOutputStream(toFile);
				byte[] buffer = new byte[4096];
				int bytesRead;

				
				while ((bytesRead = from.read(buffer)) != -1)
					to.write(buffer, 0, bytesRead); // write
			} finally {
				if (from != null)
					try {
						from.close();
					} catch (IOException e) {
						;
					}
				if (to != null)
					try {
						to.close();
					} catch (IOException e) {
						;
					}
			}
		
	}

	public static void saveStrings(File xmlOutDir, String... xmlstrings)
			throws IOException {
		for (String xml : xmlstrings) {
			FileWriter fr = new FileWriter(new File(xmlOutDir, Math.abs(xml.hashCode())
					+ ".xml"));
			fr.write(xml);
			fr.flush();
			fr.close();
		}

	}

	public static void saveStreams(File xmlOutDir, InputStream... streams)
			throws IOException {

		for (InputStream is : streams) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;

			while ((bytesRead = is.read(buffer)) != -1)
				baos.write(buffer, 0, bytesRead); // write
			String xml = baos.toString("UTF-8");
			FileWriter fw = new FileWriter(new File(xmlOutDir, Math.abs(xml.hashCode())
					+ ".xml"));
			fw.write(xml);
			baos.flush();
			baos.close();
			fw.flush();
			fw.close();

		}

	}
	public synchronized static void cleanDir(File dir, boolean createIfNotexist) throws IOException {
		
		if(createIfNotexist)
		{
			if(!dir.exists()){dir.mkdir();return;}
			
		}
		File f[]=dir.listFiles();
		if(f==null) return;
		if(f.length>0)
		{
			delete(dir);
			dir.mkdir();
		}
		
	}
	static synchronized void delete(File f) throws IOException {
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  if (!f.delete())
		    throw new FileNotFoundException("Failed to delete file: " + f);
		}

	public static List<File> listFilesRec(File fd) {
	ArrayList<File> ret=new ArrayList<File>();
	
	for(File f :fd.listFiles())
	{
		if(!f.isDirectory())
		{
			ret.add(f);
		}
		else
		{
			ret.addAll(listFilesRec(f));
		}
	}
	return ret;
	}
	
	public static String read(File filePath)
		    throws java.io.IOException{
		        StringBuffer fileData = new StringBuffer(1000);
		        BufferedReader reader = new BufferedReader(
		                new FileReader(filePath));
		        char[] buf = new char[1024];
		        int numRead=0;
		        while((numRead=reader.read(buf)) != -1){
		            fileData.append(buf, 0, numRead);
		        }
		        reader.close();
		        return fileData.toString();
		    }
	
	public static String readString(File filePath)
		    throws java.io.IOException{
		        StringBuffer fileData = new StringBuffer(1000);
		        BufferedReader reader = new BufferedReader(
		                new FileReader(filePath));
		        char[] buf = new char[1024];
		        int numRead=0;
		        while((numRead=reader.read(buf)) != -1){
		            fileData.append(buf, 0, numRead);
		        }
		        reader.close();
		        return fileData.toString();
		    }
	public static byte[] readBytes(File file)
		    throws java.io.IOException{
	

	    byte []buffer = new byte[(int) file.length()];
	    InputStream ios = null;
	    try {
	        ios = new FileInputStream(file);
	        if ( ios.read(buffer) == -1 ) {
	            throw new IOException("EOF reached while trying to read the whole file");
	        }        
	    } finally { 
	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        }
	    }

	    return buffer;
	    
		    }
	
	public void traverse(File startpont, TraverseListener l)
	{
		LinkedList<File> st=new LinkedList<File>();
		st.add(startpont);
		
		while(st.size()>0)
		{
			File examine = st.poll();
			if(examine.isDirectory())
			{
				l.directoryFound(examine);
				for(File f:examine.listFiles())
				{
					st.add(f);
				}
			}else
			{
				l.fileFound(examine);
			}
		}
	}
	public static void write(File file, String string) {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(string);
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void serialize(File vocfile, Object vocabulary) throws IOException {

		FileOutputStream fos = new FileOutputStream(vocfile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(vocabulary);
		oos.flush();
		oos.close();
	}

	
	public  static <T> T deserialize(File file,Class<T> class1) throws IOException,
			ClassNotFoundException {

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object myDeserializedObject = ois.readObject();
		ois.close();
		return class1.cast(myDeserializedObject);

	}
}
