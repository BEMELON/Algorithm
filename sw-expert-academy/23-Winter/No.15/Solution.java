import java.util.*;
import java.io.*;

class Solution{
	static Map<Long, Integer> cache;

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; ++tc){
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			List<Node> nodes = new ArrayList<Node>();
			cache = new HashMap<Long, Integer>();

			nodes.add(new Node());

			for (int i = 1; i < N; i++){
				int p = Integer.parseInt(arr[i - 1]) - 1;
				nodes.add(new Node(nodes, p));
				nodes.get(p).children.add(i);
			}

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(0);
			int to = 0;
			long cnt = 0;

			while (!queue.isEmpty()){
				int id = queue.poll(), len = nodes.get(id).children.size(), lca = findLCA(nodes, id, to);

				cnt += nodes.get(to).dep - nodes.get(lca).dep;
				cnt += nodes.get(id).dep - nodes.get(lca).dep;

				to = id;
				for (int i = 0; i < len; i++) queue.add(nodes.get(id).children.get(i));
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static int findLCA(List<Node> nodes, int a, int b){
		if (a == b) return a;

		int depA = nodes.get(a).dep, depB = nodes.get(b).dep;

		if (depA > depB){ //A가 항상 상위노드(depB가 항상 큼)
			int c = a;
			a = b;
			b = c;
			c = depA;
			depA = depB;
			depB = c;
		}

		while (depA < depB){
			b = nodes.get(b).parent;
			depB--;
		}

		return findLCA2(nodes, a, b);
	}

	public static int findLCA2(List<Node> nodes, int a, int b){
		if (a == b) return a;
	
		long key = (long)a * 100000 + (long)b;
		if (cache.containsKey(key)){
			return cache.get(key);
		}

		a = nodes.get(a).parent;
		b = nodes.get(b).parent;

		int result = findLCA2(nodes, a, b);

		cache.put(key, result);

		return result;
	}

	public static class Node{
		int parent, dep;
		List<Integer> children = new ArrayList<Integer>();

		public Node(){
			parent = 0;
			dep = 0;
		}

		public Node(List<Node> nodes, int parent){
			this.parent = parent;
			this.dep = nodes.get(parent).dep + 1;
		}
	}
}