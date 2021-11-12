package twitter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {
    String id;
    String text;

    @JsonCreator
    Tweet(@JsonProperty("id")String id,  @JsonProperty("text") String text) {
         this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
