package LeetCode.Helper;

public class Interval implements Comparable<Interval>{
    public int start;
    public int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
	
    
    @Override
	public int compareTo(Interval a) {
		return this.start - a.start; 
		
	}
    
    public String toString() {
    	
    	return this.start + "-" + this.end;
    }
}