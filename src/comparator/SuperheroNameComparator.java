package comparator;
import main.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getSuperheroName().compareTo(superhero2.getSuperheroName());
    }
}
