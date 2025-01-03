import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;




class Coder {

    String name;
    String jobGrade;
    static HashMap<String, Integer> hash_map_size = new HashMap<>();

  

    Coder(String n, String j){
        this.name = n;
        this.jobGrade = j;
        hash_map_size.put("Principal Developer", 1);
        hash_map_size.put("Senior Developer", 2);
        hash_map_size.put("Middle Developer", 3);
        hash_map_size.put("Junior Developer", 4);
    }
}


class JobSort implements Comparator<Coder>{

    public int compare(Coder c1, Coder c2){

        if (Coder.hash_map_size.get(c1.jobGrade) > Coder.hash_map_size.get(c2.jobGrade)){
            return 1;
        }
        else if (Coder.hash_map_size.get(c1.jobGrade) < Coder.hash_map_size.get(c2.jobGrade)){
            return -1;
        }
        else {
            return 0;
        }
    }
}


class DevTeam {

    public static void main(String[] args) {

        ArrayList<Coder> arrayList_coders = new ArrayList<>();
        Coder carmelo = new Coder("Carmelo Braun ", "Senior Developer");
        arrayList_coders.add(carmelo);
        Coder donald = new Coder("Donald Foster", "Middle Developer");
        arrayList_coders.add(donald);
        Coder rachael = new Coder("Rachael Holmes", "Principal Developer");
        arrayList_coders.add(rachael);
        Coder junaid = new Coder("Junaid McCarthy", "Junior Developer");
        arrayList_coders.add(junaid);
        Coder victor = new Coder("Victor Martinez", "Middle Developer");
        arrayList_coders.add(victor);
        Coder gale = new Coder("Gale Gregory", "Senior Developer");
        arrayList_coders.add(gale);
        Coder amparo = new Coder("Amparo Mendoza", "Junior Developer");
        arrayList_coders.add(amparo);

        JobSort jobsort = new JobSort();


        Collections.sort(arrayList_coders, jobsort);

        for (Coder coder : arrayList_coders){
            System.out.println(coder.name + "  (" + coder.jobGrade +" )" );
        }
    }

}