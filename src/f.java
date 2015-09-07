import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class f {
	static String path = "/home/lishuo/777/thtyg/script/Th_rss";
	static String allspell = new String();
    
	public static void main(String[] args){
		System.out.println(1212153);
//		listfiles(path);
		expfiles(path);
		System.out.println(1212212153);
	}
	
	public static void saveback(String folderpath) {
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				System.out.println("folder:"+newfolderpath);
				saveback(newfolderpath);
			}else{
				String fn = files[i].getName();
				String orifn = fn.replaceAll("/1/", "/0/");
				if(fn.indexOf("lib_ED_PL")>-1){
			    	ArrayList<String> r = readed(files[i]);
			    	try {
			    		save_ed(fn);
			    	}catch(Exception e){
			    		e.printStackTrace();
			    	}
				}
			}
		}
	}
	
	public static void save_ed(String fn){
		String orifn = fn.replaceAll("/1/", "/0/");
		try{
			String content = new String();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fn),"uft-8"));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(orifn),"uft-8"));
			String s;
			while ((s = br2.readLine()) != null) {
				if(s.indexOf("/* to be translated */")>-1){
					int n1 = s.indexOf("\"");
					String f = s.substring(0,n1);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
    
	public static void listfiles(String folderpath) {
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				System.out.println("folder:"+newfolderpath);
				listfiles(newfolderpath);
			}else{
				String fn = files[i].getName();
				if(fn.indexOf("lib_ED_PL")>-1){
			    	ArrayList<String> r = readed(files[i]);
			    	try {
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/888/0/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"utf-8");	
						out.write(r.get(1));
						out.close();
			    		if(r.get(0).length()>3){
			    			String newfilepath2 = files[i].getPath().replaceAll("/777/", "/888/1/");
				    		File newfile2 = new File(newfilepath2);
				    		new File(newfile2.getParent()).mkdirs();
				    		FileOutputStream fo2 = new FileOutputStream(newfile2);
				    		OutputStreamWriter out2 = new OutputStreamWriter(fo2,"utf-8");	
							out2.write(r.get(0));
							out2.close();
			    		}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(fn.indexOf("_SpellCard_")>0){
					System.out.println(fn);
			    	ArrayList<String> r = readspell(files[i]);
			    	allspell = allspell + r.get(0);
			    	try {
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/888/0/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"utf-8");	
						out.write(r.get(1));
						out.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}
				else if(fn.indexOf("_Event_")>0){
					
			    	ArrayList<String> r = readfile(files[i]);
			    	try {
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/888/0/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"utf-8");	
						out.write(r.get(1));
						out.close();
			    		if(r.get(0).length()>3){
			    			String newfilepath2 = files[i].getPath().replaceAll("/777/", "/888/1/");
				    		File newfile2 = new File(newfilepath2);
				    		new File(newfile2.getParent()).mkdirs();
				    		FileOutputStream fo2 = new FileOutputStream(newfile2);
				    		OutputStreamWriter out2 = new OutputStreamWriter(fo2,"utf-8");	
							out2.write(r.get(0));
							out2.close();
			    		}
						
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}else if(fn.indexOf(".dnh")>0){
					
			    	ArrayList<String> r = readother(files[i]);
			    	try {
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/888/0/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"utf-8");	
						out.write(r.get(1));
						out.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}


		    	
			}
		}
    	try {
    		String newfilepath = "/home/lishuo/888/1/allspell.txt";
    		File newfile = new File(newfilepath);
    		new File(newfile.getParent()).mkdirs();
    		FileOutputStream fo = new FileOutputStream(newfile);
    		OutputStreamWriter out = new OutputStreamWriter(fo,"utf-8");	
    		System.out.println(allspell);
			out.write(allspell);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
    
	public static ArrayList<String> readfile(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Shift-JIS"));

		String s;
		while ((s = br.readLine()) != null) {
			if(s.indexOf("let text = [")>0){
				content = content + s + rn;
				String s2 = new String();
				while ((s2 = br.readLine()) != null) {
					if(s2.indexOf("];")>0){
						content = content + s2 + rn;
						break;						
					}
					if(s2.indexOf("NULL")>0){
						content = content + s2 + rn;
						continue;
					}
					content = content + "/* to be translated */"+ s2 + rn;
					jc = jc + s2 + rn;
				}
				jc = jc + rn;
			}else{
				content = content + s + rn;
			}
			
		}
		
        br.close();   
		}
		catch (Exception ex)
		{
			System.out.println("exception in reading chat content :"+filename.toString()+":"+ex.toString());
		}
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}

	
	public static ArrayList<String> readed(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Shift-JIS"));
			String s;
			String tex;
			while ((s = br.readLine()) != null) {
				
				if(s.indexOf("ED_Text")>0)
					{
						int n1=s.indexOf("\"");
						String t1=s.substring(n1+1);
						int n2=t1.indexOf("\"");
						if(n2==-1)
						{
							String t2=br.readLine();
							int n3 = t2.indexOf("[r]");
							String t3=t2.substring(n3);
							int n4=t3.indexOf("\"");
							if(n4==-1)
							{
								String t5=br.readLine();
								int n5 = t5.indexOf("[r]");
								String t6=t5.substring(n5);
								int n6 = t6.indexOf("\"");
								String t7 = t6.substring(0,n6);
								tex=t1 + t3 + t7;
								content = content + "/* to be translated */"+ s+t3+t6+rn;
							}
							else {
								String t4=t3.substring(0,n4);
								tex=t1+t4;
								content = content + "/* to be translated */"+ s+t3+rn;							
							}

						}
						else
						{
							tex= t1.substring(0,n2);
							content = content + "/* to be translated */"+ s+rn;
						}
						jc=jc + tex + rn;
					}
					else {
						content = content +s+ rn;
					}
			}
			br.close();
		}
		catch(Exception e){
			
		}
		
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}
	
	
	public static ArrayList<String> readspell(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Shift-JIS"));

		String s;
		int count=0;
		while ((s = br.readLine()) != null) {
			
			
			
			
			
			
			
			if((s.indexOf("spell_text =")>0) && (s.indexOf("let spell_text = \"\";") == -1)){
				count++;
				content = content + "/* to be translated */"+s + rn;
				String sn = s.split("\"")[1];
				jc = jc + sn + rn;
			}else{
				content = content + s + rn;
			}
			
		}
		
        br.close();   
		}
		catch (Exception ex)
		{
			System.out.println("exception in reading chat content :"+filename.toString()+":"+ex.toString());
		}
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}
	
	
	public static ArrayList<String> readother(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Shift-JIS"));

		String s;
		while ((s = br.readLine()) != null) {
			content = content + s + rn;

			
		}
        br.close();   
		}
		catch (Exception ex)
		{
			System.out.println("exception in reading chat content :"+filename.toString()+":"+ex.toString());
		}
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}
	
	
	
	
    
	public static ArrayList<String> expfile(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"shift-JIS"));
		
		String newfilepath = filename.getPath().replaceAll("/777/", "/888/1/");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(newfilepath)));
		String s;
		while ((s = br.readLine()) != null) {
			if(s.indexOf("let text = [")>0){
				content = content + s + rn;
				String s2 = new String();
				while ((s2 = br.readLine()) != null) {
					if(s2.indexOf("];")>0){
						content = content + s2 + rn;
						break;						
					}
					if(s2.indexOf("NULL")>0){
						content = content + s2 + rn;
						continue;
					}
					String s3="";
					while(s3.length()<2){
						s3=br2.readLine().trim();
					}
					if(s3.length()<2){
						System.out.println("err:"+newfilepath);
					}
					content = content + "	"+ s3 + rn;
					
					jc = jc + s2 + rn;
				}
				jc = jc + rn;
			}else{
				content = content + s + rn;
			}
			
		}
		String sr;
		while((sr=br2.readLine())!=null){
			if(sr.trim().length()>1){
				System.out.println("err2:"+sr);
			}
			
		}
		
        br.close();   
		}
		catch (Exception ex)
		{
			System.out.println("exception in reading chat content :"+filename.toString()+":"+ex.toString());
		}
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}

    
    
	
	
	
	
	
	public static void expfiles(String folderpath) {
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				expfiles(newfolderpath);
			}else{
				String fn = files[i].getName();
				
				if(fn.indexOf("_Event_")>0){
//				System.out.println(fn);
			    	ArrayList<String> r = expfile(files[i]);
//			    	System.out.println(r.get(0));
			    	try {
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/999/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
//			    		System.out.println(newfile);
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"x-UTF-16LE-BOM");	
					out.write(r.get(1));
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}					
				}
			}
		}
	}
    
    
    
    
}
