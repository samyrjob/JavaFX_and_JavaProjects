

interface MinMax {
    default int min(int [] array_int){
        int record_number = array_int[0];
        for (int i : array_int ){
            if (i <= record_number){
                record_number = i;
            }
        }
        return record_number;
    };

    default int max(int [] array_int){
        int record_number = array_int[0];
        for (int i : array_int ){
            if (i >= record_number){
                record_number = i;
            }
        }
        return record_number;
    };
}
