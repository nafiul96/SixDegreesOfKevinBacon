
import java.util.Comparator;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 * @author nafi
 *
 */
public class NameComparator implements Comparator<Actor> {

    /**
     * Compares two Actor object by name
     *
     * @param o1 - object 1
     * @param o2 - object 2
     * @return
     */
    @Override
    public int compare(Actor o1, Actor o2) {

        return o1.getName().compareTo(o2.getName());
    }

}
