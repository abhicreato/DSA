public class StackDeleteMiddle {
    
 //Function to delete middle element of a stack.
 public void deleteMid(Stack<Integer>s,int sizeOfStack){
    // code here
    
    if(s.size() == Math.ceil((sizeOfStack+1)/2)){
        s.pop();
        return;
    }
    
    int top = s.pop();
    
    deleteMid(s,sizeOfStack);
    
    s.push(top);
    
}

}
