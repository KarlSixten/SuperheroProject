package comparator;

import main.Superhero;
import java.util.Comparator;

public class SuperheroIsHumanComparator implements Comparator<Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
      return Boolean.compare(superhero1.getIsHuman(), superhero2.getIsHuman());
    }
}