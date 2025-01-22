
import java.util.ArrayList;


class Song {
    private String title;
    private String artist;
    private String year;

    Song(String title, String artist, String year){
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    String return_title(){
        return this.title;
    }
    String return_artist(){
        return this.artist;
    }
    String return_year(){
        return this.year;
    }

    void display_details(){
        System.out.println("title : " + title + "\t" + "artist :" + artist + "\t" + "year : "    + year);
    }
    
}




class MediaLibrary {


    private ArrayList<Song> list_of_songs = new ArrayList<Song>();

    void Add_song_to_list(Song song){

        list_of_songs.add(song);
    }

    void display_list_songs(){
        System.out.println("The list of songs contain the following songs : ");
        for (Song song : list_of_songs){
            song.display_details();
        }
    }

    
}

public class MyMedia{

    static public void main(String args []){
        Song song1 = new Song("All of me", "John Legend", "2013");
        Song song2 = new Song("Numa numa E", "Dragostea Din Tei", "2010");
        Song song3 = new Song("American Party", "Milei Cyrus", "2017");
        Song song4 = new Song("O Casamento", "DJ Guuga", "2023");
        MediaLibrary my_playlist = new MediaLibrary();
        my_playlist.Add_song_to_list(song1);
        my_playlist.Add_song_to_list(song2);
        my_playlist.Add_song_to_list(song3);
        my_playlist.Add_song_to_list(song4);
        my_playlist.display_list_songs();

    }
}
