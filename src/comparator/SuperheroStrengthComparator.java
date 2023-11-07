package comparator;

import main.Superhero;
import java.util.Comparator;

public class SuperheroStrengthComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return Integer.compare(superhero1.getStrength(), superhero2.getStrength());
    }
}
