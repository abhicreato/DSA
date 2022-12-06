import java.util.*;
public class PrintFirstNegativeInteger{
        
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long [] output = new long[N-K+1];
        Queue<Long> q = new LinkedList<>();
        int windowStart = 0;
        int windowEnd = 0;
        int index = 0;
        
        while(windowEnd < N){
        
            if(A[windowEnd] < 0){
                q.add(A[windowEnd]);
            }
            
            if(windowEnd - windowStart + 1 < K){
                windowEnd ++;
            }else if ( windowEnd - windowStart + 1 == K){
                
                if(q.isEmpty()){
                    output[index++] = 0;
                }else{
                    output[index++] = q.peek();
                     if(q.peek() == A[windowStart]){
                    q.remove();
                }
                }
                
                windowStart++;
                windowEnd++;
            }
        }

        

        return output;
     
    }
}