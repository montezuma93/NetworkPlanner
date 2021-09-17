package library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Locale;


@Controller
@RequestMapping("library")
public class LibraryController {

    @GetMapping("hello")
    ResponseEntity<String> helloLibrary() {
        return new ResponseEntity<String>("hello back", HttpStatus.OK);
    }

    @GetMapping("ping-pong")
    ResponseEntity<String> pingPongLibrary(@RequestParam String pingOrPong) {
        String body;
        if (pingOrPong.equalsIgnoreCase("ping")) {
            body = "pong";
        } else if (pingOrPong.equalsIgnoreCase("pong")) {
            body = "ping";
        } else {
            body = "No Idea what u are saying";
            return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }



}
