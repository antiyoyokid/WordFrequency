import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class FrequencyCounter {
    public static void main(String[] args) throws IOException, UnirestException {
        String url = UserInput.website();
        String text = FileContent.makeApiRequest(url);// returns as String the entire text
        String[] words = text.split(" ");
        System.out.print(words[0]);


    }
}

