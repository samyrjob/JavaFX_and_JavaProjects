import java.util.Scanner;

public class ColorCount {

    public static byte compare_numbers(byte a, byte b){
        if (a == b){
            return -1;
        }
        else {
            return (byte) Math.max(a,b);
        }
    }


    public static void main(String[] args) {
        
        byte [] numbers = {1,2,3,4,5,6,7,8,9,10};

        Scanner scanner = new Scanner(System.in);
        byte red = 0;
        byte green = 0;
        byte purple = 0;
        byte orange = 0;
        byte no_response=0;

        for (byte number : numbers){
            String color;
            System.out.println("User number " + number + " : Choose your favorite color :\n 1. Red\n2. Orange\n3. Purple\n4. Green");
            color = scanner.nextLine();
            switch(color.toLowerCase()){
                case "red":
                    red += 1;
                    break;
                case "green":
                    green += 1;
                    break;
                case "purple":
                    purple += 1;
                    break;
                case "orange":
                    orange += 1;
                    break;
                default:
                    no_response += 1;
            }
        }
    
        System.out.println("Results of choice of " + (10 - no_response) + " Users :\n 1. Red has been selected by " + red + " people");
        System.out.println("\n 2. Green has been selected by " + green + " people");
        System.out.println("\n 3. Orange has been selected by " + orange + " people");
        System.out.println("\n 4. Purple has been selected by " + purple + " people");

        if (compare_numbers(red, green) == -1 && compare_numbers(orange, purple) == -1){
            if (compare_numbers(red, orange) == -1){
                System.out.println("All colours have obtained the same number of vote");
            }
            else if (red > orange){
                System.out.println("The colour red and green are the most popular with " + red + " voices !");
            }
            else {
                System.out.println("The colour orange and purple are the most popular with " + orange + " voices !");

            }}
        else if (compare_numbers(red, green) != -1 && compare_numbers(orange, purple) == -1){
                if ( red>green && red > orange){
                    System.out.println("The colour red is the most popular with " + red + " voices !");
                }
                else if (compare_numbers(red, green) < orange){
                    System.out.println("The colours orange and purple are the most popular with " + orange + " voices !");
                }
                else if (red<green && green > orange){
                    System.out.println("The colour green is the most popular with " + green + " voices !");
    
                }
                else if (red<green && compare_numbers(orange, green)==-1){
                    System.out.println("The colour green, orange and purple are the most popular with " + green + " voices !");
    
                }
                else if (red>green && compare_numbers(orange, red)==-1){
                    System.out.println("The colour red, orange and purple are the most popular with " + red + " voices !");
                }
        }
        else if (compare_numbers(orange, purple) != -1 && compare_numbers(red, green) == -1){
            if ( orange>purple && orange > red){
                System.out.println("The colour orange is the most popular with " + orange + " voices !");
            }
            else if (compare_numbers(orange, purple) < red){
                System.out.println("The colours red and green are the most popular with " + red + " voices !");
            }
            else if (orange<purple && purple> red){
                System.out.println("The colour purple is the most popular with " + purple + " voices !");

            }
            else if (orange<purple && compare_numbers(red, purple)==-1){
                System.out.println("The colour green, red, and purple are the most popular with " + green + " voices !");

            }
            else if (orange>purple && compare_numbers(red, orange)==-1){
                System.out.println("The colour orange, red and green are the most popular with " + orange + " voices !");
            }
    }
    else if (compare_numbers(orange, purple) != -1 && compare_numbers(red, green) != -1){
        if ( orange > purple && red > green && compare_numbers(orange, red) == -1){
            System.out.println("The colour orange and red are the most popular with " + orange + " voices !");
        }
        else if ( orange < purple && red < green && compare_numbers(green, purple) == -1){
            System.out.println("The colours purple and green are the most popular with " + green + " voices !");
        }
        else if ( orange < purple && red > green && compare_numbers(red, purple) == -1){
            System.out.println("The colour purple and red are the most popular with " + purple + " voices !");

        }
        else if ( orange > purple && red < green && compare_numbers(red, purple) == -1){
            System.out.println("The colour orange and green are the most popular with " + orange + " voices !");

        }
        else if ( orange > purple && red < green && compare_numbers(red, purple) == -1){
            System.out.println("The colour orange and green are the most popular with " + orange + " voices !");

        }
        else if ( orange > purple && red < green && orange > green){
            System.out.println("The colour orange is the most popular with " + orange + " voices !");

        }
        else if ( orange > purple && red < green && orange < green){
            System.out.println("The colour green is the most popular with " + green + " voices !");

        }
        else if ( orange < purple && red < green && purple > green){
            System.out.println("The colour purple is the most popular with " + purple + " voices !");

        }
        else if ( orange < purple && red < green && purple < green){
            System.out.println("The colour green is the most popular with " + green + " voices !");

        }
        else if ( orange < purple && red > green && purple < red){
            System.out.println("The colour red is the most popular with " + red + " voices !");

        }
        else if ( orange < purple && red > green && purple > red){
            System.out.println("The colour purple is the most popular with " + purple + " voices !");

        }
        else if ( orange > purple && red > green && orange > red){
            System.out.println("The colour orange is the most popular with " + orange + " voices !");

        }
        else if ( orange > purple && red > green && orange < red){
            System.out.println("The colour red is the most popular with " + red + " voices !");

        }
}



    
    scanner.close();
        }  
      }
