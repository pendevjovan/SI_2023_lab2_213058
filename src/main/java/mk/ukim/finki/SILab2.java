package mk.ukim.finki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function(User user, List<User> allUsers) { //START=pocetok
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //A1
            throw new RuntimeException("Mandatory information missing!"); //B2
        }

        if (user.getUsername() == null) { //C3
            user.setUsername(user.getEmail()); //D4
        }

        int same = 1; //E=5
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //F6
            same = 0; //G=7
            for (int i = 0; i < allUsers.size(); i++) { //H8, I9, J10
                User existingUser = allUsers.get(i); //K11
                if (existingUser.getEmail() == user.getEmail()) { //L12
                    same += 1; //M=13
                }
                if (existingUser.getUsername() == user.getUsername()) { //N14
                    same += 1; //O15
                }
            }

        }
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //P16
        String password = user.getPassword(); //P16
        String passwordLower = password.toLowerCase(); //P16

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //Q17
            return false; //R18
        } else { //S19
            if (!passwordLower.contains(" ")) { //T20
                for (int i = 0; i < specialCharacters.length(); i++) { //U21, V22, W23
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //X24
                        return same == 0; //Y25
                    }
                }
            }
        }
        return false; //Z26
    }//KRAJ
}