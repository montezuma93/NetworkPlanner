package twitter;

import library.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@Controller
public class TwitterController {

    String token = "AAAAAAAAAAAAAAAAAAAAAG9tRQEAAAAAGdTDK0BK5rYjTSmLBCAuBUk1Msg%3DUX1TUu7HxvcbOOxuwKegjzd2oor0ccU5pA1Phq2ySPTGBqimYL";

    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }


    @GetMapping("getTweets")
    ResponseEntity<TwitterData> getTweets(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer "+token);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        RequestEntity<Void> request = RequestEntity.get(URI.create("https://api.twitter.com/2/tweets/search/recent?query=Bundestagswahl"))
                .accept(MediaType.APPLICATION_JSON)
                // any other headers
                .header("Authorization", "Bearer "+token)
                .build();

      ResponseEntity<TwitterData>responseEntity = restTemplate.exchange(request, TwitterData.class);
      System.out.println(responseEntity.getBody().tweets.toString());
      return responseEntity;

    }

}
