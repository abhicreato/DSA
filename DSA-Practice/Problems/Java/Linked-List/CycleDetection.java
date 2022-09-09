
public class CycleDetection {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        
        if(head == null){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null){
            
            if(slow == fast) return true;
            
            if(fast.next.next==null){
                fast = fast.next;
            }else{
                fast = fast.next.next;
            }
                
            slow = slow.next;
             
        }
        
        return false;
        
    }
}
