import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class IOUtils {
	public static AtomicInteger counter  = new AtomicInteger(0);
	public static int res;
	public static int getOccurences() {
		return res;
	}
	public static void copy(InputStream in,OutputStream out) throws IOException{
		int value;
		while((value=in.read())!=-1) {
			out.write(value);
		}
	}
	
	public static void copyFile(String src,String out) throws IOException {
		FileInputStream fin = new FileInputStream(src);
		FileOutputStream fout = new FileOutputStream(out);
		
		IOUtils.copy(fin, fout);
		
		fin.close();
		fout.close();
	}
	public static void fileSearch(String filename) {
		File file = new File(filename);
		//URL url = getClass().getResource("ListStopWords.txt");
		//File file = new File(url.getPath());
		try {
		    Scanner scanner = new Scanner(new File(filename));
		    int lineNum = 0;
		    while (scanner.hasNext()) {
		        String word = scanner.next();
		        lineNum++;
		        if(word.equalsIgnoreCase("pavan")) { 
		        	System.out.println(counter);
		        	res = counter.incrementAndGet();
		        }
		    }
		    scanner.close();
		} catch(FileNotFoundException e) { 
		    //handle this
			System.out.println(e);
		}
	}
}
