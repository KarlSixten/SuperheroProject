package main;

import main.Superhero;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    public ArrayList<Superhero> loadData() throws IOException {
        ArrayList<Superhero> dataArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(new File("DataSheet.csv"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            dataArrayList.add(new Superhero(parts[0],
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Boolean.parseBoolean(parts[4]),
                    Integer.parseInt(parts[5])));
        }

        return dataArrayList;
    }

    public void saveSuperheroes(ArrayList<Superhero> superhereosArrayList){
        try {
            PrintStream output = new PrintStream("DataSheet.csv");
            for (Superhero superhero : superhereosArrayList) {
                output.println(superhero.getSuperheroName() + ";" + superhero.getRealName() + ";" + superhero.getSuperpower()
                + ";" + superhero.getYearCreated() + ";" + superhero.getIsHuman() + ";" + superhero.getStrength());
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


