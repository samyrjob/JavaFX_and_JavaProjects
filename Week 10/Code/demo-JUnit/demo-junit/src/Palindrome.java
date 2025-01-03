


public class Palindrome {




    public static void main(String user_input []) {
        

        try_method(user_input[0]);
    
    }


    static void try_method(String user_input){
        
        // try {

            if (user_input.trim().isEmpty() || user_input.length() < 3){
                throw new IllegalArgumentException("Either your input is empty or has only one or two characters");
            }
            // to check with regular expression that we make sure the user only enters alphanumeric expressions 
            else if (!user_input.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("Input must contain only alphanumeric characters.");
            }
            else {

                System.out.println(checkPalindrome(user_input)); 
            }

        // }

        // catch (IllegalArgumentException e){

        //     System.out.println(e.getMessage());

        // }
    }


    static boolean isPalindrome(String inputword){

        char [] array_characters =  inputword.toCharArray();
        int counter = 0;

        for (int i =0; i<array_characters.length; i++){
            if (array_characters[i] == array_characters[array_characters.length-1-i ]){

                counter += 1;
            }
        }

        if (counter == array_characters.length){
            return true;
        }
        else {
            return false;
        }



    }

    static String checkPalindrome(String inputWord){

        return isPalindrome(inputWord) ? "Palindrome" : "Not a Palindrome";
    }
    
}
