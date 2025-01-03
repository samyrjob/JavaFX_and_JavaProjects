package hellofx;
import java.io.Serializable;

public class Player implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int points;
    private String name;

    public Player(String n) {
        this.points = 0;
        this.name = n;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void addPoint() {
        this.points++;
    }

   
}
