package com.example.movidleapplication;

public class Movie {
    private String no;
    private String title;
    private String year;
    private String genre;
    private String origin;
    private String director;
    private String star;
    private String imdbLink;

    public Movie() {
    }

    public Movie(String  no, String title, String year, String genre, String origin, String director, String star, String imdbLink) {
        this.no = no;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.imdbLink = imdbLink;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", origin='" + origin + '\'' +
                ", director='" + director + '\'' +
                ", star='" + star + '\'' +
                ", imdbLink='" + imdbLink + '\'' +
                '}';
    }
}
