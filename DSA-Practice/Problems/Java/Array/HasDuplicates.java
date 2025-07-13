import java.util.HashSet;
import java.util.Set;

public class HasDuplicates {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> s = new HashSet();

        for(int n : nums){
            if(!s.add(n)) return true; // Set will give false if we are trying to add already esisting value 
        }

        return false;
        
    }
    
}
