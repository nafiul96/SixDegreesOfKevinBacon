import big.data.DataSource;
import java.util.ArrayList;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 * @author nafi
 *
 */
public class Movie {

    private String title;
    private ArrayList<Actor> actors;
    private int year;

    /**
     * Creates movie object with movie title
     *
     * @param title - title of the movie
     */
    public Movie(String title) {

        String prefix = "http://www.omdbapi.com/?t=";
        String postfix = "&y=&plot=short&r=xml";
        if (title.length() > 0) {
            DataSource ds = DataSource.connectXML(prefix + title.replace(' ', '+') + postfix);
            ds.load();
            String act[] = ds.fetchString("movie/actors").trim().split(",");
            actors = new ArrayList<>();

            for (int i = 0; i < act.length; i++) {

                actors.add(new Actor(act[i]));

            }
            year = ds.fetchInt("movie/year");

            System.out.println("true title: " + ds.fetchString("movie/title"));
            System.out.println("actors: " + ds.fetchString("movie/actors"));
            System.out.println("year: " + year);

        }

    }

    /**
     * Getter for the movie title
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the movie title
     *
     * @param title - new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the actors of the movie
     *
     * @return actors of the movie
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * Setter fro the actors of the movie
     *
     * @param actors - the new set of actors for the movie
     */
    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Getter for the year of release of the movie
     *
     * @return the year of release
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for th year of release
     *
     * @param year - new year of release
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Compares two objects for equality
     *
     * @param m - object to be compared
     * @return - true if objects are equal, false otherwise
     */
    public boolean equals(Object m) {

        Movie mov = (Movie) m;

        if (mov == null || this == null) {

            return false;
        }
        return this.title.equals(mov.title);
    }

}
