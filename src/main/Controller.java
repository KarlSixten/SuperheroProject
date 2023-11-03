package main;

import java.util.ArrayList;

public class Controller {
    private Database superheroDatabase;

    public void setSuperheroArrayList(ArrayList<Superhero> liste) {
        superheroDatabase.setSuperheroArrayList(liste);
    }

    enum returnMessage{
        OK,
        INVALID;
    }

    public ArrayList<Superhero> getSearchMatches() {
        return superheroDatabase.getSearchMatches();
    }

    public Controller(Database superheroDatabase) {
        this.superheroDatabase = superheroDatabase;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        superheroDatabase.addSuperhero(superheroName, realName, superpower, yearCreated, isHuman, strength);

    }

    public ArrayList<Superhero> getSuperheroesArrayList() {
        return superheroDatabase.getSuperheroesArrayList();
    }

    public ArrayList<Superhero> searchSuperhero(String stringToSearchFor) {
        return superheroDatabase.searchSuperhero(stringToSearchFor);
    }

    public void deleteSuperhero(int indexToDelete) {
        superheroDatabase.deleteSuperhero(indexToDelete);
    }

    public String printSuperheroNames() {
        return superheroDatabase.printSuperheroNames();
    }

    public returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, String newValue) {
        return superheroDatabase.editSuperhero(indexOfSuperhero, attributeToEdit, newValue);
    }
    public returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, int newValue) {
        return superheroDatabase.editSuperhero(indexOfSuperhero, attributeToEdit, newValue);
    }
    public returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, boolean newValue) {
        return superheroDatabase.editSuperhero(indexOfSuperhero, attributeToEdit, newValue);
    }
}