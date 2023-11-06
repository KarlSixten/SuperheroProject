package main;

import comparator.*;

import java.io.IOException;
import  java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
    Filehandler filehandler = new Filehandler();
    //Create new Arraylist with initial capacity of 1
    private final ArrayList<Superhero> superheroesArrayList = new ArrayList<Superhero>(1);
    private final ArrayList<Superhero> searchMatches = new ArrayList<Superhero>();

    public Database() throws IOException {
        setSuperheroArrayList(filehandler.loadData());
    }

    public ArrayList<Superhero> getSuperheroesArrayList() {
        return superheroesArrayList;

    }

    public ArrayList<Superhero> getSearchMatches() {
        return searchMatches;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        //Creates a new superhero object and adds to index 0 of superheroesArrayList
        superheroesArrayList.add(0, (new Superhero(superheroName, realName, superpower, yearCreated, isHuman, strength)));
    }


    public String searchSuperhero(String stringToSearchFor) {
        searchMatches.clear();
        StringBuilder stringBuilder = new StringBuilder();

        for (Superhero superhero : superheroesArrayList) {
            if (superhero.getSuperheroName().toLowerCase().contains(stringToSearchFor.toLowerCase())) {
                stringBuilder.append(superhero.getSuperheroName() + "\n");
                searchMatches.add(superhero);
            };
        }

        if (searchMatches.isEmpty()) {
            return "No superheros found.";
        } else {
            return "Superheros found!: \n" + stringBuilder;
        }
    }

    public String showSuperheros() {
        StringBuilder stringBuilder = new StringBuilder();
        if (superheroesArrayList.isEmpty()) {
            return "There are no superheroes in the database.";
        } else {
            stringBuilder.append("""
                    ------------------------
                    Superheroes in database:
                    ------------------------""");
            for (Superhero superhero : superheroesArrayList) {
                stringBuilder.append("\n" + superhero + "\n----------------------------");
            }
            return stringBuilder.toString();
        }
    }

    public void deleteSuperhero(int userSelection) {
        superheroesArrayList.remove(userSelection - 1);
    }

    public String printSuperheroNames() {
        StringBuilder stringBuilder = new StringBuilder();
        int superheroNumber = 1;
        for (Superhero superhero : superheroesArrayList) {
            stringBuilder.append(superheroNumber + ". " + superhero.getSuperheroName() + "\n");
            superheroNumber++;
        }
        return stringBuilder.toString();
    }

    public Controller.returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, String newValue) {
        Superhero superheroToEdit = superheroesArrayList.get(indexOfSuperhero);

        switch (attributeToEdit) {
            case 1 -> {
                superheroToEdit.setSuperheroName(newValue);
                return Controller.returnMessage.OK;
            }
            case 2 -> {
                superheroToEdit.setRealName(newValue);
                return Controller.returnMessage.OK;
            }
            case 3 -> {
                superheroToEdit.setSuperpower(newValue);
                return Controller.returnMessage.OK;
            }
            default -> {
                return Controller.returnMessage.INVALID;
            }
        }
    }
    public Controller.returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, int newValue) {
        Superhero superheroToEdit = superheroesArrayList.get(indexOfSuperhero);

        switch (attributeToEdit) {
            case 4 -> {
                superheroToEdit.setYearCreated(newValue);
                return Controller.returnMessage.OK;
            }
            case 6 -> {
                superheroToEdit.setStrength(newValue);
                return Controller.returnMessage.OK;
            }
            default -> {return Controller.returnMessage.INVALID;}
        }
    }
    public Controller.returnMessage editSuperhero(int indexOfSuperhero, int attributeToEdit, boolean newValue) {
        Superhero superheroToEdit = superheroesArrayList.get(indexOfSuperhero);

        switch (attributeToEdit) {
            case 5 -> {
                superheroToEdit.setIsHuman(newValue);
                return Controller.returnMessage.OK;
            }
            default -> {
                return Controller.returnMessage.INVALID;
            }
        }
    }

    public void setSuperheroArrayList(ArrayList<Superhero> liste) {
        for (Superhero superhero : liste) {
            superheroesArrayList.add(superhero);
        }
    }
}