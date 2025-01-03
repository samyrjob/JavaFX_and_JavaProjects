
import java.util.Random;

public interface RandFid {

    static int generate(){
        int [] table = {0,1,2,3,5,8,13,21,34,55};
        Random random = new Random();
        int random_index = random.nextInt(table.length);
        return table[random_index];
    };
    
}
