
import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<Range> ranges = new ArrayList<Range>();
	    Range range1 = new Range(1,6,9);
	    Range range2 = new Range(2,12,15);
	    Range range3 = new Range(1,7,27);
	    Range range4 = new Range(4,21,25);
	    Range range5 = new Range(2,13,30);
	    Range range6 = new Range(2,13,20);
	    Range range7 = new Range(1,29,30);
	    ranges.add(range1);
	    ranges.add(range2);
	    ranges.add(range3);
	    ranges.add(range4);
	    ranges.add(range5);
	    ranges.add(range6);
	    ranges.add(range7);
	    
	    
	    
	    
	  for(int i = 0; i < ranges.size() - 1; i ++){
		  System.out.println("Object " + i + "  :" + "{ id-" + ranges.get(i).id + "  [" + ranges.get(i).start + "," + ranges.get(i).end + "] }");
	    for(int j = i+1; j < ranges.size(); j++){
	    	if(ranges.get(i).id == ranges.get(j).id){
//	    		System.out.print("hello");
	    		//case for overlapping
	    		if((ranges.get(i).start < ranges.get(j).end) && (ranges.get(i).end > ranges.get(j).start)){
	    			System.out.print("["+i+","+j+"] MatchingId_Overlapping ");
	    		}else{
	    			System.out.print("["+i+","+j+"] MatchingId_NoOverlapping ");
	    		}
	    		
	    		
	    	}else{
	    		System.out.print("["+i+","+j+"] No id matching");
	    	}
	    	System.out.print("   ");
	    }System.out.println("\n");
	    }
	    
	    
	    
	    
	    
	    
	    
	}
}
