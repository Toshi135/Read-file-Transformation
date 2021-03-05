import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		
		HashMap<String, String> map=new HashMap<String, String>();
		
		System.out.println("Enter the file path: ");
		String mDir = scn.nextLine();
		File file = new File(mDir);
		Scanner myReader = new Scanner(file);
		while(myReader.hasNextLine()) {
			String str = myReader.nextLine();
			StringTokenizer stringTokenizer = new StringTokenizer(str);
			String s;
			while(stringTokenizer.hasMoreTokens()) {
			    s=stringTokenizer.nextToken();
			    if(map.containsKey(s))
			    {
			        int count=Integer.parseInt((String) map.get(s));
			        count++;
			        map.put(s,count+"");
			    }
			    else
			    {
			        map.put(s,"1");
			    }
			}
		}
		
		map.forEach((key, value) -> {
			System.out.println("["+key+", "+value+"]");
		});
		myReader.close();
	}
	
}
