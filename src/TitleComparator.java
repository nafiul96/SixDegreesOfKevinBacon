
import java.util.Comparator;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 */
public class TitleComparator implements Comparator<Movie> {

    /**
     * Compares two movies by title
     *
     * @param o1 - movie 1
     * @param o2 - movie 2
     * @return
     */
    @Override
    public int compare(Movie o1, Movie o2) {

        return o1.getTitle().compareTo(o2.getTitle());
    }
}
