class Solution {
    // hernf
    //  h -> n
    //  indegree (max)
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap();
        Map<Character, Integer> indegrees = new HashMap();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees.putIfAbsent(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            int len = Math.min(prev.length(), curr.length());

            int j = 0;

            while (j < len && prev.charAt(j) == curr.charAt(j)) {
                j++;
            }

            // 非法情况
            if (j == len) {
                if (prev.length() > curr.length()) {
                    return "";
                }
                continue;
            }

            char from = prev.charAt(j);
            char to = curr.charAt(j);

            graph.putIfAbsent(from, new HashSet<>());

            // 防止重复边
            if (graph.get(from).add(to)) {
                indegrees.put(to, indegrees.getOrDefault(to, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList();
        for (char c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char nei : graph.getOrDefault(c, new HashSet<Character>())) {
                indegrees.put(nei, indegrees.get(nei) - 1);
                if (indegrees.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (sb.length() != indegrees.keySet().size()) {
            return "";
        }
        return sb.toString();
    }
}
