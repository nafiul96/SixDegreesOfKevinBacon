
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 * @author nafi
 *
 */
public class ActorGraph {

    private static HashMap<String, Actor> actorsByName;
    private static HashMap<String, Movie> moviesByTitle;
    public static LinkedList<String> bfs;

    /**
     * Constructor for the Actor Graph
     */
    public ActorGraph() {

        actorsByName = new HashMap();
        moviesByTitle = new HashMap();
        bfs = new LinkedList();
    }

    /**
     * Breadthfirst search from a given actor name
     *
     * @param name - name of the actor
     */
    public static void bfs(String name) {

        System.out.println(actorsByName.size());
        Actor temp = actorsByName.get(name);
        LinkedList<Actor> bfs2 = new LinkedList();

        if (temp != null) {

            LinkedList<Actor> q = new LinkedList();
            q.addLast(temp);
            q.getLast().setVisited(true);
            while (!q.isEmpty()) {

                for (int i = 0; i < temp.getFriends().size(); i++) {

                    if (!q.getFirst().getFriends().get(i).isVisited()) {

                        q.addLast(q.getFirst().getFriends().get(i));
                        q.getLast().setVisited(true);
                    }

                }
                bfs2.addLast(q.removeFirst());
                bfs.addLast(bfs2.getLast().getName());

            }

            System.out.println(bfs.size());

            for (int i = 0; i < bfs.size(); i++) {
                System.out.println(bfs.get(i));
                bfs2.getFirst().setVisited(false);
            }
        }
    }

    /**
     * Shortest path from an actor to another
     *
     * @param src - source actor
     * @param dest - destination actor
     */
    public static void shortestPath(Actor src, Actor dest) {

        LinkedList<Actor> breadfirst = new LinkedList();
        bfs(src.getName());
        if (breadfirst.contains(dest)) {

            for (int i = 0; i <= breadfirst.indexOf(dest); i++) {

                breadfirst.addLast(ActorGraph.actorsByName.get(bfs.get(i)));
            }

            LinkedList<Actor> perm = new LinkedList();
            perm.addLast(breadfirst.removeFirst());

            boolean done = false;
            int count = breadfirst.size() - 1;
            while (count >= 0 || !perm.getLast().equals(dest)) {

                if (perm.getLast().getFriends().contains(breadfirst.get(count))) {

                    perm.addLast(breadfirst.remove(count));
                    count = breadfirst.size() - 1;
                } else {

                    count--;
                }
            }

            LinkedList<String> path = new LinkedList<>();
            for (int i = 0; i < perm.size(); i++) {

                path.add(i, perm.get(i).getName());
            }

            ActorGraph.getActorsByName().get(src.getName()).setPath(path);
            for (int i = 0; i < perm.size(); i++) {

                System.out.print(perm.get(i).getName() + ", ");
            }
            System.out.println();
        }

    }

    /**
     * Getter for the ActorByName
     *
     * @return
     */
    public static HashMap<String, Actor> getActorsByName() {
        return actorsByName;
    }

    /**
     * Getter for the MovieBytitle
     *
     * @return
     */
    public static HashMap<String, Movie> getMoviesByTitle() {
        return moviesByTitle;
    }

    /**
     * Getter for the breadthfirst search
     *
     * @return
     */
    public static LinkedList<String> getBfs() {
        return bfs;
    }

    public static void actorPrint() {

        Set<String> key = ActorGraph.actorsByName.keySet();

        Iterator keyIt = key.iterator();

        for (String keys : ActorGraph.actorsByName.keySet()) {

            System.out.printf("%-18s%-18s\n", ActorGraph.actorsByName.get(key), key);
        }

    }

    public static void moviePrint() {

        Set<String> key = ActorGraph.moviesByTitle.keySet();

        Iterator keyIt = key.iterator();

        for (String keys : ActorGraph.moviesByTitle.keySet()) {

            System.out.printf("%-18s%-18s\n", ActorGraph.moviesByTitle.get(key), key);
        }

    }

}
