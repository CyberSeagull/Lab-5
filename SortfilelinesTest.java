import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SortfilelinesTest {

	String infile = "inputfile.txt";
    String outfile = "outputfile.txt";
	
   	List<String> inlines = new ArrayList<>();
   	List<String> outlines = new ArrayList<>();
   	List<String> routlines = new ArrayList<>();
	private void adddatain(List<String> inlist) 	    
	{ 		   	
		inlist.add("test1234");
		inlist.add("test1");
		inlist.add("test12");
		inlist.add("test12345");
		inlist.add("test123");
	} 
	private void adddataout(List<String> outlist) 	    
	{ 		   	
		outlist.add("test1");
		outlist.add("test12");
		outlist.add("test123");
		outlist.add("test1234");
		outlist.add("test12345");	    
	} 
	private void writetofile(String fname, List<String> inout) throws Exception 	    
	{ 			
		BufferedWriter writer = new BufferedWriter(new FileWriter(fname));		      					
		for (int i=0; i<inout.size(); i++) {			     	 				
			writer.write(inout.get(i));			     	 				
			if (i<inout.size()-1)  writer.newLine();		      			
		}				
		writer.close();	    
	} 

	
	@Test
	void testreadfiletolines() throws Exception {
		adddatain(inlines); 
		writetofile(infile, inlines);     
	   
		Sortfilelines rwsort= new Sortfilelines(infile, outfile);
		rwsort.readfiletolines(); 
		Assertions.assertEquals(inlines, rwsort.lines);
	}

	@Test
	void testsortlines() throws Exception {
		Sortfilelines rwsort= new Sortfilelines(infile, outfile);
		adddatain(rwsort.lines); 
		rwsort.sortlines();
		adddataout(outlines); 
		Assertions.assertEquals(outlines, rwsort.lines);
	}

	@Test
	void testwritefilefromlines() throws Exception {
		adddataout(outlines); 
		
		Sortfilelines rwsort= new Sortfilelines(infile, outfile);
		adddataout(rwsort.lines); 
		rwsort.writefilefromlines();
		
		BufferedReader reader = new BufferedReader(new FileReader(outfile));
        String line;
        while ((line = reader.readLine()) != null) {
        	routlines.add(line);
        };
        reader.close();
		Assertions.assertEquals(outlines, routlines);		
	}
		
	@Test
	void testclass() throws Exception {
		adddatain(inlines); 
		adddataout(outlines); 
		writetofile(infile, inlines); 
	   
		Sortfilelines rwsort= new Sortfilelines(infile, outfile);
		rwsort.readfiletolines(); 
		Assertions.assertEquals(inlines, rwsort.lines);
		
		rwsort.sortlines();
		Assertions.assertEquals(outlines, rwsort.lines);

		rwsort.writefilefromlines();
		BufferedReader reader = new BufferedReader(new FileReader(outfile));
        String line;
        while ((line = reader.readLine()) != null) {
        	routlines.add(line);
        };
        reader.close();
		Assertions.assertEquals(outlines, routlines);		
	}

}
