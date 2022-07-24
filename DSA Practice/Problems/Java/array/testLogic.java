public class testLogic {
    public static void main(String[] args) {
        int x[] = {3, 1, 6, 4, 5, 2};
		int n = 6;
        int p = 0, s = 0; 
 for (int k = 1; k < n; k++)  
{  
s = Math.max(x[k],s+x[k]);//this is the main line of the code 
 p = Math.max(p,s); 
 } 
 System.out.println(p);
    }
}