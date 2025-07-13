import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] alpaCount = new int[26];

        for (int i=0;i<s.length();i++) {
            alpaCount[s.charAt(i) - 'a']++ ;
            alpaCount[t.charAt(i) - 'a']-- ;
        }

        for(int n : alpaCount){
            if(n!=0) return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, Integer> w = new HashMap();
        Map<Character, Integer> q = new HashMap();

        for (char c : s.toCharArray()) {
            w.put(c, w.getOrDefault(c, 0) + 1);
        }

        for (char r : t.toCharArray()) {
             q.put(r, q.getOrDefault(r, 0) + 1);
        }

        return w.equals(q) ? true : false;

    }
    
}
