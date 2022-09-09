/*
**************** Problem Description ****************
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
  Example : 
  Input: 
  N = 7, price[] = [100 80 60 70 60 75 85]
  
  Output:
  1 1 1 2 1 4 6
  Explanation:
  Traversing the given input span for 100 
  will be 1, 80 is smaller than 100 so the 
  span is 1, 60 is smaller than 80 so the 
  span is 1, 70 is greater than 60 so the 
  span is 2 and so on. Hence the output will 
  be 1 1 1 2 1 4 6.
*/
public class StockSpan {

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Pair> s = new Stack<>();
        int[] op = new int[n];
        
        for(int i =0;i<n;i++){
            while(!s.empty() && s.peek().val1 <= price[i]){
                s.pop();
            }
            if(s.empty()){
                op[i] = i + 1;
            }else{
                op[i] = i - s.peek().val2;
            }
            
            s.push(new Pair(price[i],i));
        }
        
        return op;
    }
    
}

/*
**************** Logic ****************
Variation of Nearest Greater to Left problem. Add array index in stack instead of elements.
*/
