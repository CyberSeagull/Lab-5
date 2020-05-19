import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Sortbylength implements Comparator<String> 
{ 
    public int compare(String a, String b) 
    { 
        return  a.length()-b.length(); 
    } 
} 
public class Sortfilelines 
{
	public  List<String> lines = new ArrayList<>(); 
	String filereadname, filewritename;

	public Sortfilelines (String filereadname, String filewritename) {
		this.filereadname = filereadname;
	    this.filewritename = filewritename;
	    }

	public void sortlines() {
		Collections.sort(lines, new Sortbylength()); 	   
	}
	
	public void readfiletolines() throws Exception {		   
		BufferedReader reader = new BufferedReader(new FileReader(filereadname));
		String line;
	    while ((line = reader.readLine()) != null) {	     
	    	lines.add(line);	        
	    };	        
	    reader.close();
   }
	
   public void writefilefromlines() throws Exception{		  
	   BufferedWriter writer = new BufferedWriter(new FileWriter(filewritename));		      		   
	   for (int i=0; i<lines.size(); i++) {			   
		   writer.write(lines.get(i));			    		
		   if (i<lines.size()-1)								   
			   writer.newLine();		      
	   }   		  
	   writer.close();   
   }
		
}

