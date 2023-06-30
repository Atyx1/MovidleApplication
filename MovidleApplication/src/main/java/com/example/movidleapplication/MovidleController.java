package com.example.movidleapplication;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.IOException;

public class MovidleController {

    @FXML
    Button btnGuess;
    @FXML
    TextField txtFieldMovie;

    @FXML
    Label lblMovie1Title;
    @FXML
    Label lblMovie1Year;
    @FXML
    Label lblMovie1Genre;
    @FXML
    Label lblMovie1Origin;
    @FXML
    Label lblMovie1Director;
    @FXML
    Label lblMovie1Star;
    @FXML
    Label lblMovie2Title;
    @FXML
    Label lblMovie2Year;
    @FXML
    Label lblMovie2Genre;
    @FXML
    Label lblMovie2Origin;
    @FXML
    Label lblMovie2Director;
    @FXML
    Label lblMovie2Star;
    @FXML
    Label lblMovie3Title;
    @FXML
    Label lblMovie3Year;
    @FXML
    Label lblMovie3Genre;
    @FXML
    Label lblMovie3Origin;
    @FXML
    Label lblMovie3Director;
    @FXML
    Label lblMovie3Star;
    @FXML
    Label lblMovie4Title;
    @FXML
    Label lblMovie4Year;
    @FXML
    Label lblMovie4Genre;
    @FXML
    Label lblMovie4Origin;
    @FXML
    Label lblMovie4Director;
    @FXML
    Label lblMovie4Star;
    @FXML
    Label lblMovie5Title;
    @FXML
    Label lblMovie5Year;
    @FXML
    Label lblMovie5Genre;
    @FXML
    Label lblMovie5Origin;
    @FXML
    Label lblMovie5Director;
    @FXML
    Label lblMovie5Star;
    @FXML
    Label lblWarning;
    @FXML
    Label lblCheat;
    @FXML
    Label lblChance;

    Label[] movieTitles;
    Label[] movieYears;
    Label[] movieGenres;
    Label[] movieOrigins;
    Label[] movieDirectors;
    Label[] movieStars;
    Label[][] labels;

    private int clickCount = 0;
    private MovieManager manager = new MovieManager();
    private Movie selectedMovie = manager.selectAMovie();
    private int count = 0;
    private int chance = 5;




    public MovidleController() throws IOException {

    }

    @FXML
    public void initialize() {

        movieTitles = new Label[]{lblMovie1Title, lblMovie2Title, lblMovie3Title, lblMovie4Title, lblMovie5Title};
        movieYears = new Label[]{lblMovie1Year, lblMovie2Year, lblMovie3Year, lblMovie4Year, lblMovie5Year};
        movieGenres = new Label[]{lblMovie1Genre, lblMovie2Genre, lblMovie3Genre, lblMovie4Genre, lblMovie5Genre};
        movieOrigins = new Label[]{lblMovie1Origin, lblMovie2Origin, lblMovie3Origin, lblMovie4Origin, lblMovie5Origin};
        movieDirectors = new Label[]{lblMovie1Director, lblMovie2Director, lblMovie3Director, lblMovie4Director, lblMovie5Director};
        movieStars = new Label[]{lblMovie1Star, lblMovie2Star, lblMovie3Star, lblMovie4Star, lblMovie5Star};
        labels = new Label[][]{movieTitles, movieYears, movieGenres, movieOrigins, movieDirectors, movieStars};
        lblCheat.setText(selectedMovie.getNo() + " " + selectedMovie.getTitle());
        lblChance.setText("Chance: " + chance);

    }



    public void btnGuessOnAction(ActionEvent event) throws IOException, InterruptedException {
        MovidleApplication m1 = new MovidleApplication();
        clickCount++;

        int i = manager.returnMovie(txtFieldMovie.getText().trim());
        if (i == -1) {
            lblWarning.setVisible(true);
            lblWarning.setText("This movie is not exist in this game!");
            FadeTransition ft = new FadeTransition(Duration.millis(5000), lblWarning);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setAutoReverse(true);
            ft.play();
            clickCount--;
        }

        Movie guessMovie = manager.convertToMovie(i);


        for (int j = clickCount; j < clickCount + 1; j++) {
            print(selectedMovie, guessMovie, j);
            chance--;
            lblChance.setText("Chance: " + chance);
            waitNewScene(m1);
            if (clickCount == 5 && !isGameFinished()) {
                waitEndScene(m1);
            }
        }



    }

    public void print(Movie selectedMovie, Movie guessMovie, int i) {

        for (int r = 0; r < 6; r++) {
            labels[r][i - 1].setVisible(true);
            labels[r][i - 1].setWrapText(true);
            labels[r][i - 1].setAlignment(Pos.CENTER);
            labels[r][i - 1].setFont(Font.font("Arial", FontWeight.BOLD, 12));
            labels[r][i - 1].setTextFill(Color.WHITE);
        }

        movieTitles[i - 1].setText(guessMovie.getTitle());
        movieYears[i - 1].setText(guessMovie.getYear());
        movieGenres[i - 1].setText(guessMovie.getGenre());
        movieOrigins[i - 1].setText(guessMovie.getOrigin());
        movieDirectors[i - 1].setText(guessMovie.getDirector());
        movieStars[i - 1].setText(guessMovie.getStar());

        if (selectedMovie.getTitle().equalsIgnoreCase(guessMovie.getTitle())) {
            count++;
            movieTitles[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);

        } else {
            movieTitles[i - 1].setStyle("-fx-background-color: red");
            addAnimation(i);
        }

        if (selectedMovie.getYear().equalsIgnoreCase(guessMovie.getYear())) {
            count++;
            movieYears[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);
        } else {
            int selectedMovie_ = Integer.parseInt(selectedMovie.getYear());
            int guessMovie_ = Integer.parseInt(guessMovie.getYear());
            if (selectedMovie_ > guessMovie_) {
                movieYears[i - 1].setStyle("-fx-background-color: red");
                movieYears[i - 1].setText("↑"
                        + "\n" + guessMovie.getYear());
                movieYears[i - 1].setFont(Font.font("Arial", FontWeight.BOLD, 18));
            } else {
                movieYears[i - 1].setStyle("-fx-background-color: red");
                movieYears[i - 1].setText("↓"
                        + "\n" + guessMovie.getYear());
                movieYears[i - 1].setFont(Font.font("Arial", FontWeight.BOLD, 18));
            }

            addAnimation(i);
        }

        if (selectedMovie.getGenre().equalsIgnoreCase(guessMovie.getGenre())) {
            count++;
            movieGenres[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);
        } else {
            movieGenres[i - 1].setStyle("-fx-background-color: red");
            addAnimation(i);
        }

        if (selectedMovie.getOrigin().equalsIgnoreCase(guessMovie.getOrigin())) {
            count++;
            movieOrigins[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);
        } else {
            movieOrigins[i - 1].setStyle("-fx-background-color: red");
            addAnimation(i);
        }

        if (selectedMovie.getDirector().equalsIgnoreCase(guessMovie.getDirector())) {
            count++;
            movieDirectors[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);
        } else {
            movieDirectors[i - 1].setStyle("-fx-background-color: red");
            addAnimation(i);
        }

        if (selectedMovie.getStar().equalsIgnoreCase(guessMovie.getStar())) {
            count++;
            movieStars[i - 1].setStyle("-fx-background-color: green");
            addAnimation(i);
        } else {
            movieStars[i - 1].setStyle("-fx-background-color: red");
            addAnimation(i);
        }
    }

    public boolean isGameFinished() throws InterruptedException {
        if (count == 6) {
            return true;
        }
        return false;
    }

    public void addAnimation(int i) {

        for (int r = 0; r < 6; r++) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), labels[r][i - 1]);
            fadeTransition.setFromValue(0.1);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        }
    }

    public void waitNewScene(MovidleApplication m1) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event1 -> {
                    try {
                        if (isGameFinished()) {
                            m1.changeScene("winScene.fxml");
                        } else {
                            count = 0;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
        timeline.play();
    }

    public void waitEndScene(MovidleApplication m1) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event1 -> {
                    try {
                        if (chance == 0 && !isGameFinished()) {
                            m1.changeScene("loseScene.fxml");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
        timeline.play();
    }
}