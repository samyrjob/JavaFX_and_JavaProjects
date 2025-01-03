public class MyData implements MinMax {


    public int min(int [] array_int){
        int record_number = array_int[0];
        for (int i : array_int ){
            if (i <= record_number){
                record_number = i;
            }
        }
        return record_number;
    };

    public int max(int [] array_int){
        int record_number = array_int[0];
        for (int i : array_int ){
            if (i >= record_number){
                record_number = i;
            }
        }
        return record_number;
    };

    public static void main(String[] args) {
        MyData mydata = new MyData();
        int [] jacky = {1,5,-9,100,4};

        // DIFFERENT KIND OF DECLARATION FROM THE BELOW: 
        // int [] jackyr = new int[10];
        // jackyr[0] = 8;

        System.out.println("the minimum value of the array is "+  mydata.min(jacky));
        System.out.println("the maximum value of the array is " +  mydata.max(jacky));
    }
    
}
