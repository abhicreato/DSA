package Graph;

import java.util.*;

// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

// Example 1:


// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.



public class CheapestFlightInKStops {
    int ans = -1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer,ArrayList<Flight>> fMap = new HashMap<>();

        for(int [] f : flights){
            
            ArrayList<Flight> list = fMap.getOrDefault(f[0],new ArrayList<Flight>());
            list.add(new Flight(0,f[1],f[2]));
            fMap.put(f[0],list);
            
        }
        
        int cost[] = new int[n];
        Arrays.fill(cost,999999);
        cost[src] = 0;
        LinkedList<Flight> q = new LinkedList<>();
        q.add(new Flight(0,src,0));
        
        while(!q.isEmpty()){
            
            System.out.println(q);
            
            Flight curr = q.remove();
            
            if(curr.stops > k) continue;
            
            if(fMap.get(curr.dst) != null){
                for(Flight c : fMap.get(curr.dst)){
                    
                    if(c.cost + curr.cost < cost[c.dst]  && curr.stops <= k){
                            cost[c.dst] = c.cost + curr.cost;
                            q.add(new Flight(curr.stops + 1, c.dst, c.cost + curr.cost));
                        }
                    }
                    
                }
            }
        
            if(cost[dst] < 999999) return cost[dst];  
        
            return -1;
        }
        
       class Flight {
         
        int stops;
        int dst;
        int cost;
        
        Flight(int stops,int dst,int cost){
            this.stops = stops;
            this.dst = dst;
            this.cost = cost;
        }
        
        public String toString(){
            return "[ " + "stops : " + this.stops + " dst : " + this.dst + ", Cost " + this.cost +" ]";
        }
        
    }  
    
}
