package comparator;

import main.Superhero;
import java.util.Comparator;

public class SuperheroSuperpoweComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return superhero1.getSuperpower().compareTo(superhero2.getSuperpower());
    }
}