import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class f {
	static String path = "/home/lishuo/777/thtyg/script/Th_rss";
	static String allspell = new String();
    
	public static void main(String[] args){
		System.out.println(1212153);
		
		try {
////			listfiles(path);

			String spellpath = "/home/lishuo/888/1/allspell.txt";
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(spellpath)));
			expfiles(path,br2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
				}else if((fn.indexOf("_SpellCard_")>0)||(fn.indexOf("_OverDrive.dnh")>0)){
					
			    	ArrayList<String> r = readspell(files[i]);
			    	System.out.println(fn+":"+r.get(0));
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
				else if((fn.indexOf("_Event_")>0)||fn.equals("06_SoulSaver_Event.dnh")){
					
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
			if((s.indexOf("let text = [")>0)||(s.indexOf("let text1 = [")>0)||(s.indexOf("let text2 = [")>0)||(s.indexOf("let text3 = [")>0)){
				
				if((s.indexOf("let text1 = [")>0)||(s.indexOf("let text2 = [")>0)||(s.indexOf("let text3 = [")>0)){
					System.out.print(" "+filename.getAbsolutePath().substring(17)+" ");
				}
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
			if(s.toLowerCase().indexOf("fonttype")>0){
//				System.out.println(filename.getName()+"\n"+s);
			}
			if(s.indexOf("#include \"./lib_enm01_setting.dnh\"")>-1){
				System.out.println(filename);
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
	
	
	
	
    


    
    
	
	
	
	
	
	public static void expfiles(String folderpath,BufferedReader br2) throws Exception {
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 

		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				expfiles(newfolderpath,br2);
			}else{
				String fn = files[i].getName();
				
				if((fn.indexOf("_Event_")>0)||fn.equals("06_SoulSaver_Event.dnh")){//				System.out.println(fn);
				    	ArrayList<String> r = expfile(files[i]);
	//			    	System.out.println(r.get(0));
			    		String newfilepath = files[i].getPath().replaceAll("/777/", "/999/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
//			    		System.out.println(newfile);
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"x-UTF-16LE-BOM");	
					out.write(r.get(1));
					out.close();		
				}else if((fn.indexOf("_SpellCard_")>0)||(fn.indexOf("_OverDrive.dnh")>0)){
					ArrayList<String> r = expspell(files[i],br2);
					String newfilepath = files[i].getPath().replaceAll("/777/", "/999/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
//			    		System.out.println(newfile);
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"x-UTF-16LE-BOM");	
					out.write(r.get(1));
					out.close();
				}else if((fn.indexOf("ED_PL")>=0)){
					ArrayList<String> r = exped(files[i]);
					String newfilepath = files[i].getPath().replaceAll("/777/", "/999/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
//			    		System.out.println(newfile);
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"x-UTF-16LE-BOM");	
					out.write(r.get(1));
					out.close();
				}else if((fn.indexOf("dnh")>=0)){
					ArrayList<String> r =readother(files[i]);
					String newfilepath = files[i].getPath().replaceAll("/777/", "/888/");
			    		File newfile = new File(newfilepath);
			    		new File(newfile.getParent()).mkdirs();
//			    		System.out.println(newfile);
			    		FileOutputStream fo = new FileOutputStream(newfile);
			    		OutputStreamWriter out = new OutputStreamWriter(fo,"x-UTF-16LE-BOM");	
					out.write(r.get(1));
					out.close();
				}
			}
		}
	}
    
    
	
	public static ArrayList<String> expspell(File filename,BufferedReader br2)
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
				String tspell = br2.readLine();
//				System.out.println("t:"+tspell);
				String ret="";
				String[] ta = s.split("\"");
				int len=ta.length;
				for(int i=0;i<len;i++){
					if(i==0){
						ret=ta[i];
					}else if(i==1){
						ret=ret+"\""+tspell;
					}else{
						ret=ret+"\""+ta[i];
					}
				}
//				System.out.println(ret);
				content = content +ret + rn;
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
			if((s.indexOf("let text = [")>0)||(s.indexOf("let text1 = [")>0)||(s.indexOf("let text2 = [")>0)||(s.indexOf("let text3 = [")>0)){
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
					boolean newwiki=false;
					while(s3.length()<2){
						s3=br2.readLine().trim();
						if(s3.length()<2){
							newwiki=true;
						}
					}
					
					String japath="/home/lishuo/w/ja.txt";
					String zhpath="/home/lishuo/w/zh.txt";
					String w1path="/home/lishuo/w/w11.txt";
					String w2path="/home/lishuo/w/w22.txt";
					String w3path="/home/lishuo/w/w33.txt";
					String jas="";
					String zhs="";
					if(newwiki){
						BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(japath)));
						String jw="";
						String jwr="";
						while((jw=br3.readLine())!=null){
							jwr=jwr+jw;
						}
						
						BufferedReader br4 = new BufferedReader(new InputStreamReader(new FileInputStream(zhpath)));
						String zw="";
						String zwr="";
						while((zw=br4.readLine())!=null){
							zwr=zwr+zw;
						}
						
						FileWriter fwj = new FileWriter(japath);
						fwj.write("");
						fwj.close();
						
						FileWriter fwz = new FileWriter(zhpath);
						fwz.write("");
						fwz.close();
						if(jwr.length()>5){
							String wc="{{对话表|\r\n|char=\r\n|ja="+jwr.substring(4)+"\r\n|zh="+zwr.substring(4)+"\r\n}}";
							String wp;
							if(filename.getName().indexOf("PL01")>0){
								if(filename.getName().equals("08_Event_befor_PL01.dnh")){
									wp="/home/lishuo/w/ph01.txt";
								}else if(filename.getName().equals("08_Event_after_PL01.dnh")){
									wp="/home/lishuo/w/ph02.txt";
								}else{
									wp="/home/lishuo/w/err.txt";
								}
							}else if(filename.getName().indexOf("PL02")>0){
								if(filename.getName().equals("08_Event_befor_PL02.dnh")){
									wp="/home/lishuo/w/ph03.txt";
								}else if(filename.getName().equals("08_Event_after_PL02.dnh")){
									wp="/home/lishuo/w/ph04.txt";
								}else{
									wp="/home/lishuo/w/err.txt";
								}
							}else if(filename.getName().indexOf("PL03")>0){
								wp=w3path;
							}else{
								wp="/home/lishuo/w/err.txt";
							}
							FileWriter fww=new FileWriter(wp,true);
							fww.write(wc.trim()+"\r\n");
							fww.close();
						}
						
						
						
						
						
					}
					
					String s4;
					int x1=s3.indexOf("||||");
					if(x1>0){
						s4=s3.substring(x1+4);
						jas=s3.substring(0,x1);
						zhs=s3.substring(x1+4);
						if(jas.startsWith("\"")){
							jas=jas.substring(1);
						}
						String lj = jas.substring(jas.length()-2);
						if(lj.equals("\",")){
							jas=jas.substring(0,jas.length()-2);
						}else{
							System.out.println("err:"+jas);
						}
						
						if(zhs.startsWith("\"")){
							zhs=zhs.substring(1);
						}
						String lz = zhs.substring(zhs.length()-2);
						if(lj.equals("\",")){
							zhs=zhs.substring(0,zhs.length()-2);
						}else{
							System.out.println("err:"+zhs);
						}
//						System.out.println(jas);
//						System.out.println(zhs);
						FileWriter fwj = new FileWriter(japath,true);
						fwj.write("<br>"+jas);
						fwj.close();
						
						FileWriter fwz = new FileWriter(zhpath,true);
						fwz.write("<br>"+zhs);
						fwz.close();
						
						
						String last = ""+s4.charAt(s4.length()-1);
						if(last.equals(",")){
							
						}else{
							System.out.println("last not ,!!"+"\n"+s4+"\n"+filename.getName());
						}
//						System.out.println("s3:"+s3);
					}else{
						s4=s3;
//						System.out.println("error s3a"+s3+filename.getName());
					}
					if(s3.length()<2){
						System.out.println("err:"+newfilepath);
					}
					content = content + "	"+ s4 + rn;
					
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
			ex.printStackTrace();
		}
		ArrayList<String> r = new ArrayList<String>();
		r.add(jc);
		r.add(content);
		return r;
	}
	
	
	public static void wiki2content()
	{
		ArrayList<String> r=rf("/home/lishuo/w/wiki1.txt");
		for(int i=0;i<r.size();i++)
		{
		try
		{
			FileWriter fw = new FileWriter("/home/lishuo/w/git"+i+".txt"); 
			System.out.println(r.get(i));
		        fw.write(r.get(i));   
		        fw.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		}
		
	}
	public static ArrayList<String> rf(String filename)
	{
		ArrayList<String> r = new ArrayList<String>();
		String content = new String();
		String jc = new String();
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
		String s;
		while ((s = br.readLine()) != null) {
			if(s.length()>3)
				if(s.substring(0,2).equals("=="))
				{
					r.add(jc.replaceAll("<br>", "[r]").replaceAll("<br/>", "[r]"));
					jc="";
				}
			if(s.length()>6)
				if(s.substring(0,8).equals("| zh   =") && !s.substring(0, 8).equals("| zh=BGM"))
				{
					String v;
//					if(s.contains("���ν�ɫ"))
//						continue;
					int n=s.indexOf("=");
					int a=s.indexOf("<ref>");
					if(a==-1)
						jc=jc+s.substring(n+1)+"\r\n";
					else {
						int b=s.indexOf("</ref>");
						jc=jc+s.substring(n+1,a)+s.substring(b+6);
					}
					while(!((v = br.readLine()).equals("}}")))
					{
						jc=jc+v+"\r\n";
					}
				}
				else {
					content = content +s+ "\r\n";
				}
			else {
				content = content + s + "\r\n";
			}
		}
        	br.close(); 
        	System.out.println(r);
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println("exception in reading chat content :"+filename+ex.toString());
		}

		return r;
	}	
	
	public static ArrayList<String> exped(File filename)
	{
		String rn="\r\n";
		String content = new String();
		String jc = new String();
		try{

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Shift-JIS"));
			String s;
			String tex;
			
			String newfilepath = filename.getPath().replaceAll("/777/", "/888/1/");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(newfilepath)));
			while ((s = br.readLine()) != null) {
				String ct;
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
								ct =  s+t3+t6+rn;
//								content = content + "/* to be translated */"+ s+t3+t6+rn;
							}
							else {
								String t4=t3.substring(0,n4);
								tex=t1+t4;
								ct= s+t3+rn;
//								content = content + "/* to be translated */"+ s+t3+rn;							
							}

						}
						else
						{
							tex= t1.substring(0,n2);
							ct=s+rn;
//							content = content + "/* to be translated */"+ s+rn;
						}
						jc=jc + tex + rn;
//						System.out.println(ct);
						int nn1=ct.indexOf("\"");
						String tn1=ct.substring(nn1+1);
						int nn2=tn1.indexOf("\"");
						
						
						String trt = br2.readLine();
						int xt=trt.indexOf("||||");
						if(xt>0){
							trt=trt.substring(xt+4);
//							System.out.println(trt);
						}
						String rrr=ct.substring(0,nn1)+"\""+trt+"\""+tn1.substring(nn2+1);
						content=content+rrr;
						
						
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
	
	
	
	
	
	
	
	
}
