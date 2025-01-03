import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Collections;


class City {
    String name;
    String country;
    int population;

    City(String n, String c, int p){
        name = n;
        country = c;
        population = p;
    }
}


class CompareByPopulation implements Comparator<City>{

    public int compare(City c1, City c2){
        if (c1.population < c2.population){
            return -1;
        }
        else if (c1.population > c2.population){
            return 1;
        }
        else {
            return 0;
        }
    }
}


class CompareByName implements Comparator<City>{

    public int compare(City c1, City c2){
        return c1.name.compareTo(c2.name);
    }
}








public class Cities {

    static CompareByName compareByName = new CompareByName();
    static CompareByPopulation compareByPopulation = new CompareByPopulation();

    public static void main(String[] args) {
        ArrayList<City> arraylist_cities =  new ArrayList<>();


        String [] [] array_information = {
            {"Delhi", "India", "28514000"},
            {"Glasgow", "UK", "635180"},
            {"Tokyo", "Japan", "37468000"}, 
            {"Lahore", "Pakistan", "11738000"}, 
            {"Suzhou", "China", "6339000"}, 
            {"Lagos", "Nigeria", "8049000"}, 
            {"Toronto", "Canada", "6082000"}, 
            {"Bangkok", "Thailand", "10156000"}
        };

        for (int i = 0; i<8; i++){


            arraylist_cities.add(new City(array_information[i][0], array_information[i][1], Integer.parseInt(array_information[i][2])));
        }


        // Compare by population
        Collections.sort(arraylist_cities, compareByPopulation);

     

        for (City city : arraylist_cities){
            System.out.println(city.name + "   " +  city.country + "   " + city.population);
            
        }
        

        System.out.println("\n\n\n\n-------------------------------------------------------");
           // compare by name 
        Collections.sort(arraylist_cities, compareByName);

        for (City city : arraylist_cities){
            System.out.println(city.name + "   " +  city.country + "   " + city.population);
            
        }

    }
    
}
