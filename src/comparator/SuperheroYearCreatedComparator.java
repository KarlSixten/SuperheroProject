package comparator;

import main.Superhero;
import java.util.Comparator;

public class SuperheroYearCreatedComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Integer.compare(o1.getYearCreated(), o2.getYearCreated());
    }
}