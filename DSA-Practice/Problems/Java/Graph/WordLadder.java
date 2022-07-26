package Graph;

/*
**************** Problem Description ****************
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
    
    Example : 1
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    
    
    Example : 2
    
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

import java.util.*;

public class WordLadder {
    
    LinkedList<String> q = new LinkedList<>();
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)){
           return 0; 
        }
        
        HashSet<String> wordSet = new HashSet<>(wordList);

        int ans = 0;
        q.add(beginWord);
        
        // BFS 
        while(!q.isEmpty()){
            
        int size = q.size();
            
           for(int i = 0 ; i < size ; i++){
               
                String currWord = q.remove();
               
                if(currWord.equals(endWord)) return ans+1;
               
                // Generate all valid sequence and add to Queue
                genValidWordSeq(currWord, wordSet);

            }
            
            ans++;
            
        }
        
        return 0;
           
    }
    
    public void genValidWordSeq(String word, HashSet<String> wordSet){

        // All Generated word should be present in the dictinory
        
        for(int i = 0; i<word.length(); i++){
            
            char[] ip = word.toCharArray();
            
            for(char c ='a'; c<= 'z' ; c++){
                
                ip[i] = c;
                
                String newWord = String.valueOf(ip);

                if(wordSet.contains(newWord)){
                    q.add(newWord);
                    wordSet.remove(newWord);
                }
            } 

        }
        
    }
}


/*
**************** Logic ****************
Create a graph considering each word as a node whose neighbours are words that differs by a single letter.
Now we can use BFS to find the shortest transformation(path) from beginWord to endWord.
For further optimization we can use Bidirectional Search.
The idea behind bidirectional search is to run two simultaneous searches—one forward from the initial state and the other backward from the goal—hoping that the two searches meet in the middle.
The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth. 
*/
