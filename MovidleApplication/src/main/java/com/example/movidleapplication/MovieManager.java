package com.example.movidleapplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieManager {
    private ArrayList<Movie> movies=new ArrayList<Movie>();

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public MovieManager() throws IOException {

        String filePath="src/imdb_top_250.csv";
        File file=new File(filePath);

        if(!file.exists()) System.out.println("Can't load the file");

        try {
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String datas[] = line.split(";");

                Movie movie = new Movie(datas[0], datas[1].trim(), datas[2], datas[3], datas[4], datas[5], datas[6], datas[7]);
                movies.add(movie);
            }
        }catch (FileNotFoundException ex){

    }

    }

    public Movie selectAMovie(){
        Random random = new Random();
        int randomNumber = random.nextInt(movies.size());
        Movie selectedMovie =movies.get(randomNumber);
        return selectedMovie;
    }

    public  ArrayList<Movie> getAllFilms(){
        return movies;
    }

    public int returnMovie(String movie){

        for(int i=0;i<movies.size();i++){
            if(movie.equalsIgnoreCase(movies.get(i).getTitle())) {
                return i;
            }
        }

        return -1;
    }

    public Movie convertToMovie(int i){
        return movies.get(i);
    }

}
