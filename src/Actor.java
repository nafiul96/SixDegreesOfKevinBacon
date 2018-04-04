
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 * @author nafi
 *
 */
public class Actor {

    private String name;
    private ArrayList<Movie> movies;
    private ArrayList<Actor> friends;
    private boolean visited;
    private LinkedList<String> path;
    Actor pred;

    /**
     * Construct Actor OBject
     *
     * @param name name of the Actor
     */
    public Actor(String name) {

        this.name = name;
        movies = new ArrayList<>();
        friends = new ArrayList<>();
        path = new LinkedList();

    }

    /**
     * Getter for actor name
     *
     * @return name of the actor
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for all the movies the actor is starring
     *
     * @return ArrayList of movies the actor is in
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Setter for a movie the actor is in
     *
     * @param title - title of the movie
     */
    public void setMovies(String title) {
        this.movies.add(new Movie(title));
    }

    /**
     * Getter for the friends of the actor
     *
     * @return ArrayList of friends
     */
    public ArrayList<Actor> getFriends() {
        return friends;
    }

    /**
     * Setter for the friend
     *
     * @param friends new ArrayList of actors to which the actor is friends
     */
    public void setFriends(ArrayList<Actor> friends) {
        this.friends = friends;
    }

    /**
     * Whether the actor is visited
     *
     * @return
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Setter for the visited field
     *
     * @param visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Shortest path from one actor to another
     *
     * @return the shortest path between this actor and the other
     */
    public LinkedList<String> getPath() {
        return path;
    }

    /**
     * Setter for the path
     *
     * @param path - new shortest path
     */
    public void setPath(LinkedList<String> path) {
        this.path = path;
    }

    /**
     * Checks to see whether two objects are equal or not
     *
     * @param act - the other comparable object
     * @return - true oif objects are equal otherwise false
     */
    public boolean equals(Object act) {
        Actor actor = (Actor) act;

        if (actor == null) {

            return false;
        }
        return this.name.equals(actor.name);
    }

    /**
     * String representation of the actor
     *
     * @return - the name of the actor along with the movies the actor was in
     */
    public String toString() {

        String s = "Name " + this.name + " \n Starring at \n";
        for (int i = 0; i < movies.size(); i++) {

            s += this.movies.get(i) + " \n";
        }
        return s;
    }

}
