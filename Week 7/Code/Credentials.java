import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;


class User {
    private String username;
    private String password;

    User(String u,String p){
        username = u;
        password = p;
    }

    String display_username(){
        return this.username;
    }

    Boolean check_password(String p){
        return p.equals(password);
    }
}

class New_Connection extends User {

    boolean success = true;

    static HashMap <String, User> users_database = new HashMap<>();


    New_Connection(String u, String p){
        super(u, p);
        if (users_database.containsKey(u)){
            User existinguser = users_database.get(u);

            if (existinguser.check_password(p)){
                System.out.println("Connection successful ! Welcome back " + u);
            }
            else if (existinguser.check_password(p)== false){
                success = false;
            }
        }
        else {
            success = false;
        }
        
    }
    
    static void add_user_to_users_database(String username, String password){
        if (!(users_database.containsKey(username))){
            users_database.put(username, new User(username, password));
            System.out.println("User " + username + " added successfully.");
        }else {
            System.out.println("Username " + username + " already exists.");
        }

    }

}

class InvalidCredentialsException extends Exception {

    @Override
    public String toString() {
        return "username and password don't match";
    }
}



public class Credentials {
    


    public static void main(String[] args) throws IOException {
        New_Connection.add_user_to_users_database("ankillous", "lalala");
        New_Connection.add_user_to_users_database("jean-mi", "lalala");
        New_Connection.add_user_to_users_database("aflelou", "lilili");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String username_pressed, password_pressed;
        Boolean setboolean = true;

        while (setboolean){
            try {
                System.out.println("What is your username ? ");
                username_pressed = reader.readLine();
                System.out.println("what is the password ?");
                password_pressed = reader.readLine();
                New_Connection new_connection = new New_Connection(username_pressed, password_pressed);
                if (new_connection.success == false) {
                    setboolean = true;
                    throw new InvalidCredentialsException();
                }else if (new_connection.success == true){
                    setboolean = false;
                }
                
    
            } catch (InvalidCredentialsException e) {
                System.out.println("Sorry but the username and the password don't match");
            }
            finally {
                if (setboolean){
                    System.out.println("\ntry again to connect : ");
                }
    
            }
            
        }
    }
}
