public class Superhero {
    private String superheroName;
    private String realName;
    private String superpower;
    private int yearCreated;
    private boolean isHuman;
    private int strength;

    //Constructor no superhero name
    public Superhero(String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        this.realName = realName;
        this.superpower = superpower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    //Constructor with superhero name
    public Superhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpower = superpower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    //ToString Method
    public String toString() {
        return "Superhero{" +
                "superheroName='" + superheroName + '\'' +
                ", realName='" + realName + '\'' +
                ", superpower='" + superpower + '\'' +
                ", yearCreated=" + yearCreated +
                ", isHuman=" + isHuman +
                ", strength=" + strength +
                '}';
    }


}
