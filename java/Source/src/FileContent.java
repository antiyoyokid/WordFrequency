import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jdk.nashorn.internal.parser.Scanner;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Gets URL
 * Given by professor on Github
 */


public class FileContent {
    public static String entireText;

    /**
     * http://www.avajava.com/tutorials/lessons/how-do-i-convert-a-web-page-to-a-string.html
     * @param url String URL that the userInputs
     * @return layout for the game
     * @throws MalformedURLException
     */
    public static String makeApiRequest(String url) throws IOException, UnirestException {

        try {

            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            entireText = sb.toString();

            return entireText;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    }


