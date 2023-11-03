package comparator;
import main.Superhero;
import java.util.Comparator;

public class SuperheroSuperpoweComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getSuperpower().compareTo(o2.getSuperpower());
    }
}