package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void BranchTesting() {
        List<User> users = new ArrayList<>();

        //user1 test /// IZVRSENA
        String password1 = "10101010";
        String email1 = "pendevjovan@yahoo.com";
        User user1 = new User(null, password1, email1);
        users.add(user1);
        assertFalse(SILab2.function(user1, users));

        //test2
        String username2 = "Igor";
        String password2 = "55555!,#I";
        String email2 = null;
        User user2 = new User(username2, password2, email2);
        users.add(user2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test3 /// NAPRAVEn
        String username3 = "Jovan";
        String password3 = "55aaa555!,# J";
        String email3 = "stickermarket.mk@gmail.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3);
        assertFalse(SILab2.function(user3, users));

        //test4   NAPRAVEN
        String username4 = "Ana";
        String password4 = "55555";
        String email4 = "anagorgieva@gmail.com";
        User user4 = new User(username4, password4, email4);
        users.add(user4);
        assertFalse(SILab2.function(user4, users));

        //test5   ///ZAVRSEN
        String username5 = "Anastas";
        String password5 = "555#babcafd";
        String email5 = "anastasmishev@gmail.com";
        User user5 = new User(username5, password5, email5);
        assertTrue(SILab2.function(user5, users));
    }

    @Test
    void multipleConditionsTest(){
        List<User> users = new ArrayList<>();

        //TXX t1
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FTX t2
        User user2 = new User("Jovan", null, "pendevjovan@yahoo.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFT t3
        User user3 = new User("Jovan", "55555", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFF t4
        User user4 = new User("Stefan", "55555#,%J", "stefanpopov@gmail.com");
        assertTrue(SILab2.function(user4, users));
    }
}