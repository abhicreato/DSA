import java.util.*;
public class FirstNegativeInwindowSizek {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        
        int i = 0;
        int j = 0;
        Queue<Long> q = new LinkedList<>();
        long[] ans = new long[N - K + 1];
        int index = 0;
        
        while(j < N){
            
            if(A[j] < 0){
                q.add(A[j]);
            }
            
            if(j - i + 1 == K){
                
                if(!q.isEmpty()){
                    ans[index++] = q.peek();
                    if(A[i]==q.peek()) q.poll();
                } else{
                    ans[index++] = 0;
                }
                
                i++;
            }
            
            j++;
        }
        
        return ans;
        
     
    }

    
}
