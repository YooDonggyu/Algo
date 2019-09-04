package Inflearn;

public class recursion3 {
	public static void main(String[] args) {
		recursion3 r = new recursion3();
		
		//int [] data = {1,2,3,4,5};
		//int target = 2;
		//System.out.println(r.search(5, data, target));
		//System.out.println(r.findMax(data, 0, 4));
		
		String target = "t";
		String[] data = {"a", "b", "c", "t", "d"};
		System.out.println(r.binarySearch(data, target, 0, data.length-1));
		
	}
	
	//암시작 매개변수
	public int search(int n, int[] data, int target) {
		for(int i=0; i<n; i++) {
			if(target == data[i]) return i;
		}
		return -1;
	}
	
	//최대값 찾기
	int findMax(int[] data, int start, int end){
	    return start == end ? data[start] : Math.max(data[start], findMax(data, start+1, end));
	}
	
	//이진검색
	int binarySearch(String[] data, String target, int start, int end ){
	    if(start > end) return -1;
	    else{
	        int m = (start+end)/2;
	        int index = target.compareTo(data[m]);
	        if(index == 0){
	            return m;
	        }else if(index < 0){
	            return binarySearch(data, target, start, m);
	        }else{
	            return binarySearch(data, target, m+1, end);
	        }
	    } 
	}
}
