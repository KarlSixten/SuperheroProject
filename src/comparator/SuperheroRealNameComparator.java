package comparator;
import main.Superhero;
import java.util.Comparator;

public class SuperheroRealNameComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getRealName().compareTo(o2.getRealName());
    }
}