public class NextGreatestLetter {

    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {

            int start = 0;
            int end = letters.length - 1;
            int mid = 0;
            char result = ' ';

            while (start <= end) {
                mid = (start + end) / 2;

                if (letters[mid] == target) {
                    start = mid + 1;
                } else if (letters[mid] < target) {
                    start = mid + 1;
                } else {
                    result = letters[mid];
                    end = mid - 1;
                }

            }

            return result == ' ' && mid == letters.length - 1 ? letters[0] : result;

        }
    }

}
