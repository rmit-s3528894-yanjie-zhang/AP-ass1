package Ozlympic;

import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
	/**
	 * @date 19.3.2017
	 * @author Yipeng
	 * @version 1.0
	 * @Description read data from specific text
	 */
    private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
    private ArrayList<Official> officials = new ArrayList<Official>();
    ArrayList<Game> game = new ArrayList<Game>();
    //construction
    public LoadData(ArrayList<Game> game, ArrayList<Official> officials,
            ArrayList<Athlete> athletes) {
        this.game = game;
        this.officials = officials;
        this.athletes = athletes;

    }
    //method to read two txt
    public void loadData() {
        ReadFile readFile = new ReadFile();
        try {
            loadAthlete(readFile.readText("Data/Athlete List.txt"));
            loadOfficial(readFile.readText("Data/Official List.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can not find file!");
        }

    }
    //method to read offical
    public void loadOfficial(ArrayList<String> newOfficials) {
        try {
            for (int i = 0; i < newOfficials.size(); i = i + 4) {
                this.officials.add(new Official(newOfficials.get(i),
                        newOfficials.get(i + 1),
                        Integer.valueOf(newOfficials.get(i + 2)),
                        newOfficials.get(i + 3)));
            }
        } catch (Exception e) {
            System.out.println("Loading official data is error!");
        }
    }
    //mothod to read athlete list
    public void loadAthlete(ArrayList<String> newAthletes) {
        try {
            for (int i = 0; i < newAthletes.size(); i = i + 5) {
                this.athletes.add(
                        new Athlete(newAthletes.get(i), newAthletes.get(i + 1),
                                Integer.valueOf(newAthletes.get(i + 2)),
                                newAthletes.get(i + 3),
                                Integer.valueOf(newAthletes.get(i + 4))));
            }
        } catch (Exception e) {
            System.out.println("Loading athlete data is error!");
        }
    }

}
