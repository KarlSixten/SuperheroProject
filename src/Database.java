public class Database {
    private Superhero[] superheroesList = new Superhero[5];

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength, int listIndex) {
        superheroesList[listIndex] = new Superhero(superheroName, realName, superpower, yearCreated, isHuman, strength);
    }
}
