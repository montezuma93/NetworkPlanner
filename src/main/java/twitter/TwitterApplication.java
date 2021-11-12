package twitter;

import Poker.Player;
import Poker.PokerGame;
import library.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class TwitterApplication {

    @Autowired
    TwitterController twitterController;



    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(TwitterApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
    }



}