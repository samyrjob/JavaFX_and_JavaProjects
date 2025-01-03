import java.util.Scanner;
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
    
}

public class SongCollection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Song> list_songs = new ArrayList<>();

        for (int i = 1; i<6; i++){
           System.out.println(" Enter the title of the song number " + i + " : "); 
            String attribute_1 = scanner.nextLine();
            System.out.println(" Enter the artist name of the song number " + i + " : "); 
            String attribute_2 = scanner.nextLine();
            System.out.println(" In what year the song was made : "); 
            String attribute_3 = scanner.nextLine();
            scanner.nextLine();
            list_songs.add(new Song(attribute_1, attribute_2, attribute_3));
        }
        System.out.println("Title :\t " + "Artist :\t" + " Year :\n"); 
        for (int i = 0; i<5; i++){
             System.out.println(list_songs.get(i).return_title() + "\t" + list_songs.get(i).return_artist() + "\t" + list_songs.get(i).return_year()); 
         }

        scanner.close();
    }
}



