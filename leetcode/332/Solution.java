import java.util.*;

class Solution {
    public void DFS(String from, Map<String, PriorityQueue<String>> map, List<String> route) {
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            DFS(map.get(from).poll(), map, route);
        }

        route.add(0, from);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>());
            pq.add(to);

            map.put(from, pq);
        }


        List<String> route = new LinkedList<>();
        DFS("JFK", map, route);

        return route;
    }
}