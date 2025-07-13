import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> op = new ArrayList();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i])
                continue;

            List<String> l = new ArrayList();
            visited[i] = true;
            l.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    l.add(strs[j]);
                    visited[j] = true;
                }
            }
            op.add(l);
        }

        return op;

    }

    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            String cKey = getCountKey(strs[i]);

            if (map.containsKey(cKey)) {
                map.get(cKey).add(strs[i]);
            } else {
                List<String> l = new ArrayList();
                l.add(strs[i]);
                map.put(cKey, l);
            }

        }

        return new ArrayList<>(map.values());

    }

    public List<List<String>> groupAnagrams3(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String cKey = getCountKey(str);
            map.computeIfAbsent(cKey, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

    }

    public String getCountKey(String x) {
        int[] count = new int[26];

        for (int i = 0; i < x.length(); i++) {
            count[x.charAt(i) - 'a']++;
        }

        return Arrays.toString(count);
    }

    public boolean isAnagram(String x, String y) {
        if (x.length() != y.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < x.length(); i++) {
            count[x.charAt(i) - 'a']++;
            count[y.charAt(i) - 'a']--;
        }

        for (int n : count) {
            if (n != 0)
                return false;
        }
        return true;
    }

}
