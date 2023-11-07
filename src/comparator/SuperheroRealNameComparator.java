package comparator;
import main.Superhero;
import java.util.Comparator;

public class SuperheroRealNameComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getRealName().compareTo(superhero2.getRealName());
    }
}