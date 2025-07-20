import java.util.Stack;

public class CelibrityProblem {

    // brut force
    public int celebrity(int mat[][]) {

        int l = mat.length;

        for (int i = 0; i < l; i++) {
            boolean knownByAll = true;
            boolean knowsNone = true;

            // i knows none
            for (int j = 0; j < l; j++) {

                if (i != j && mat[i][j] == 1) {
                    knowsNone = false;
                    break;
                }

            }

            // i known by all
            for (int j = 0; j < l; j++) {

                if (i != j && mat[j][i] == 0) {
                    knownByAll = false;
                    break;
                }

            }

            if (knownByAll && knowsNone)
                return i;
        }

        return -1;
    }

    // Function to find if there is a celebrity in the party or not.
    public int celebrityOpti(int mat[][]) {
        // [1, 1, 0],
        // [0, 1, 0],
        // [0, 1, 1]

        Stack<Integer> s = new Stack();
        int persons = mat.length;

        for (int i = 0; i < persons; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int person1 = s.pop();
            int person2 = s.pop();

            // if person 1 does not know person 2 then he might be celeb
            if (mat[person1][person2] == 0) {
                s.push(person1);
            } else {
                s.push(person2);
            }
        }

        if (s.size() == 0)
            return -1;

        int potentialCeleb = s.peek();

        for (int i = 0; i < persons; i++) {

            if (i == potentialCeleb)
                continue;

            // Condition 1: Everyone must know the celebrity
            if (mat[i][potentialCeleb] == 0)
                return -1;

            // Condition 2: Celebrity must know no one
            if (mat[potentialCeleb][i] == 1)
                return -1;
        }

        return potentialCeleb;

    }
}
