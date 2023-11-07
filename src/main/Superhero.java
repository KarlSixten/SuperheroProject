package main;

public class Superhero {
    private String superheroName;
    private String realName;
    private String superpower;
    private int yearCreated;
    private boolean isHuman;
    private int strength;

    //Constructor
    public Superhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpower = superpower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    //Getters
    public String getSuperheroName(){
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperpower() {
        return superpower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean getIsHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }

    //Setters
    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String printSuperheroAttributesIndexed() {
        return "1. Superhero Name: " + superheroName + "\n" +
                "2. Real name: " + realName + "\n" +
                "3. Superpower: " + superpower + "\n" +
                "4. Year created: " + yearCreated + "\n" +
                "5. The superhero is human: " +  isHuman + "\n" +
                "6. Strength: " + strength;
    }

    //ToString Method
    public String toString() {
        return "Superhero Name: " + superheroName + "\n" +
                "Real name: " + realName + "\n" +
                "Superpower: " + superpower + "\n" +
                "Year created: " + yearCreated + "\n" +
                "The superhero is human: " +  isHuman + "\n" +
                "Their strength is: " + strength;
    }
}
