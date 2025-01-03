
import java.io.Serializable;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;



class Users implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;
    private String emailadresse;
    private String password;

    Users(String u, String e, String p ){
        username = u;
        emailadresse = e;
        password = p;
    }

    String display_details(){
        return "Username : " + this.username + "\t" + "email : " + this.emailadresse + "\t" +"password : ********" ;
    }
}

public class UserDB {

    public static void main(String[] args) {

        Users [] array_users = new Users[3];

        Users user_1 = new Users("ankilla", "notra@se.com", "123456");
        array_users[0] = user_1;
        
        Users user_2 = new Users("ankillous", "morad@arachi.com", "12345");
        array_users[1] = user_2;
        
        Users user_3 = new Users("malibu", "akha@akha.com", "987654");
        array_users[2] = user_3;

        try( FileOutputStream fileOutputStream = new FileOutputStream("MyUsers.dat"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            // serialization
            objectOutputStream.writeObject(array_users);
            System.out.println("the array of users has been serialized");
        }
        catch (IOException eo){
            eo.printStackTrace();
        }


        try (FileInputStream fileInputStream = new FileInputStream("myUsers.dat"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
              //deserialization

              System.out.println("Now let's deserialize and read the content of the file");
              Users [] arraUsers = (Users []) objectInputStream.readObject();
              System.out.println("the list of users is as follows : " + "User 1 : "  + arraUsers[0].display_details() + " \n" + "User 2 : " + arraUsers[1].display_details() + "\n" + "User 3 :"  + arraUsers[2].display_details());

        }
        catch(IOException | ClassNotFoundException eo){
            eo.printStackTrace();
        }

        
    }
    
}
