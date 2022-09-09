class SearchInAnAlmostSortedArray {

 public static void main(String a[]){
 
 //int [] input = {10, 3, 40, 20, 50, 80, 70};
 //int key = 40;
 
 int [] input = {10, 3, 40, 20, 50, 80, 70};
 int key = 70;

 System.out.println(findElement(input,key));

 }
 
 static int findElement(int input[],int key){
 
 int s = 0;
 int e = input.length - 1;
 int mid = 0;
 
 while(s<=e){
 
	mid = (s + e)/2;
	
	//System.out.println(mid);
	
	if(input[mid] == key){
		return mid;
	}
	if(s <= mid && input[mid-1] == key){
		return (mid - 1);
	}
	if(e >= mid && input[mid+1] == key){
		return (mid + 1);
	}
	
	if(key > input[mid]){
		s = mid + 2;
	}else if(key < input[mid]){
	    e = mid - 2;
	}
	
 }
 	return -1;
 
}
}