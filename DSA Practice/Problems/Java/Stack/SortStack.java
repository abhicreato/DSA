/*
**************** Problem Description ****************
Given a stack, the task is to sort it such that the top of the stack has the greatest element.
  Example : 
  Input:
  Stack: 3 2 1
  Output: 3 2 1
  Input:
  Stack: 11 2 32 3 41
  Output: 41 32 11 3 2
*/

public class SortStack {

    public Stack<Integer> sortPush(Stack<Integer> s, int num) {

        // Keep pushing until its smaller then peek (sorted way of pushing)
        if (s.empty() || s.peek() < num) {
            s.push(num);
            return s;
        }

        int top = s.pop();

        sortPush(s, num);

        s.push(top);

        return s;

    }

    public Stack<Integer> sort(Stack<Integer> s) {

        // This is recursive way to reverse a stack but only change is, 
        // while pushing at bootom push it in a sorted way

        if (s.empty())
            return s;

        int top = s.pop();

        sort(s);

        sortPush(s, top);

        return s;

    }

}

/*
 **************** Logic ****************
 * Recursively sort the stack.
 */
