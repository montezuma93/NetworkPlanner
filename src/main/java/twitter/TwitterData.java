package twitter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterData {

    List<Tweet> tweets;

    @JsonCreator
    TwitterData(@JsonProperty("data") List<Tweet> data) {
        this.tweets = data;
    }
}
