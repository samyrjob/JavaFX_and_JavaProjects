package hellofx;

public class Waste {
    private String bin;  // The bin this waste belongs to
    // either Plastic , Paper, Food Waste, Glass

    private String name; 
    public Waste(String name, String bin) {
        this.bin = bin;
        this.name =name;
    }

    public String getName() {
        return name;
    }


    public String getBin() {
        return bin;
    }

    
    public void resetWaste(String name, String bin) {
        this.name = name;
        this.bin = bin;
    }





}
