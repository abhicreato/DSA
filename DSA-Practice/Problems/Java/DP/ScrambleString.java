public class ScrambleString {
    
    public boolean isScramble(String a, String b) {

        if(a.equals(b)) return true;

        if(a.length() != b.length()) return false;

        // int[] letters = new int[26];
        // for (int i=0; i<a.length(); i++) {
        //     letters[a.charAt(i)-'a']++;
        //     letters[b.charAt(i)-'a']--;
        // }
        // for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        int n = a.length();
        boolean flag = false;

        for(int k = 1; k < n; k++){

            boolean case1 = (isScramble(a.substring(0, k), b.substring(k, n)) && isScramble(a.substring(k, n), b.substring(0, k)));
            boolean case2 = (isScramble(a.substring(0, k), b.substring(0, k)) && isScramble(a.substring(k, n), b.substring(k, n)));

            if(case1 || case2) {
                flag = true;
                break; 
            };

        }

        return flag; 
    }

}
