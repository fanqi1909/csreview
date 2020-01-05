package contest.c170;

import javafx.util.Pair;

import java.util.*;

public class Q3 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer>[] neighbor = new Set[friends.length];
        for(int i = 0; i < friends.length; i++) {
            neighbor[i] = new HashSet<>();
            for(int friend : friends[i]) {
                neighbor[i].add(friend);
            }
        }


        Queue<Integer> q = new LinkedList<>();

        List<Integer> levelFriend = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        int currentLevel = 0;
        q.add(id);
        levelFriend.add(id);
        seen.add(id);

        while(!q.isEmpty()) {
            int exp = levelFriend.size();
            levelFriend = new LinkedList<>();
            while(exp-- >0) {
                int currentNode = q.poll();
                for (int friend : neighbor[currentNode]) {
                    if (!seen.contains(friend)) {
                        q.add(friend);
                        levelFriend.add(friend);
                        seen.add(friend);
                    }
                }
            }
            currentLevel++;
            if(currentLevel == level) {
                break;
            }
        }


        Map<String, Integer> movies = new HashMap<>();
        for(int friend : levelFriend) {
            for(String movie : watchedVideos.get(friend)) {
                movies.put(movie, movies.getOrDefault(movie, 0) + 1);
            }
        }

        List<Pair<String, Integer>> movieCounts = new ArrayList<>();
        for(Map.Entry<String, Integer> movie : movies.entrySet()) {
            movieCounts.add(new Pair<>(movie.getKey(), movie.getValue()));
        }

        System.out.println(movieCounts);

        movieCounts.sort((o1, o2) -> {
            if (o2.getValue() != o1.getValue()) {
                return o1.getValue() - o2.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        List<String> ans = new LinkedList<>();
        for(Pair<String, Integer> pair : movieCounts) {
            ans.add(pair.getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3 sol = new Q3();

       System.out.println(sol.watchedVideosByFriends(
                Arrays.asList(
                        Arrays.asList("A", "B"),
                        Arrays.asList("C"),
                        Arrays.asList("B", "C"),
                        Arrays.asList("D")
                ),
                new int[][]{
                        new int[]{1,2},
                        new int[]{0,3},
                        new int[]{0,3},
                        new int[]{1,2},
                },
                0,
                1
        ));

        System.out.println(sol.watchedVideosByFriends(
                Arrays.asList(
                        Arrays.asList("bjwtssmu"),
                        Arrays.asList("aygr","mqls"),
                        Arrays.asList("vrtxa","zxqzeqy","nbpl","qnpl"),
                        Arrays.asList("r","otazhu","rsf"),
                        Arrays.asList("bvcca","ayyihidz","ljc","fiq","viu")
                ),
                new int[][]{
                        new int[]{3,2,1,4},
                        new int[]{0,4},
                        new int[]{4,0},
                        new int[]{0,4},
                        new int[]{2,3,1,0},
                },
                3,
                1
        ));
    }
}
