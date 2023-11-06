package main;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private Database superheroDatabase;

    public Controller() throws IOException {
        this.superheroDatabase = new Database();
    }


    public void setSuperheroArrayList(ArrayList<Superhero> liste) {
        superheroDatabase.setSuperheroArrayList(liste);
    }

    public void saveSuperheros() {
        superheroDatabase.saveSuperheros();
    }

    enum returnMessage{
        OK,
        INVALID;
    }

    public String showSuperheros() {
        return superheroDatabase.showSuperheros();
    }

    public Controller(Database superheroDatabase) throws IOException {
        this.superheroDatabase = superheroDatabase;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        superheroDatabase.addSuperhero(superheroName, realName, superpower, yearCreated, isHuman, strength);

    }

    public ArrayList<Superhero> getSuperheroesArrayList() {
        return superheroDatabase.getSuperheroesArrayList();
    }

    public String searchSuperhero(String stringToSearchFor) {
        return superheroDatabase.searchSuperhero(stringToSearchFor);
    }

    public void deleteSuperhero(int userSelection) {
        superheroDatabase.deleteSuperhero(userSelection);
    }

    public String printSuperheroNames() {
        return superheroDatabase.printSuperheroNames();
    }

    public void simpleSort(int sortMethod) {
        superheroDatabase.simpleSort(sortMethod);
    }

    public void advancedSort(int primaryMethod, int secondaryMethod) {
        superheroDatabase.advancedSort(primaryMethod, secondaryMethod);
    }

    public String printSuperheroNamesWithIndex() {
        return superheroDatabase.printSuperheroNamesWithIndex();
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