package comparator;
import main.Superhero;
import java.util.Comparator;

public class SuperheroYearCreatedComparator implements Comparator <Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        if (o1.getYearCreated() > o2.getYearCreated()) {
            return 1;
        }
        else if (o1.getYearCreated() < o2.getYearCreated()) {
            return -1;
        }
        else return 0;


    }
}