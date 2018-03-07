import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class FrequencyCounter {
    /**
     *
     * @param allWords
     * @return
     */
    public static ArrayList<String> removeCommaFullstop(ArrayList<String> allWords) {
        for (int j = 0; j < allWords.size(); j++) {
            if (allWords.get(j).contains(",")) {
                allWords.remove(j);
            }
            if (allWords.get(j).contains(".")) {
                allWords.remove(j);
            }
        }
        return allWords;
    }

    /**
     *
     * @param text
     * @return
     */
    public static List<HashMap.Entry<String, Integer>> main(String text) {
        String[] words = text.toLowerCase().split("(?=[,.])|\\s+");
        ArrayList<String> wordsToArrayList = new ArrayList<String>(Arrays.asList(words));
        //https://stackoverflow.com/questions/7384791/splitting-strings-through-regular-expressions-by-punctuation-and-whitespace-etc
        wordsToArrayList = removeCommaFullstop(wordsToArrayList);

        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String word : wordsToArrayList) {
            if (allWords.containsKey(word)) {
                allWords.put(word, allWords.get(word) + 1);
            } else {
                allWords.put(word, 1);
            }
        }

        Set<HashMap.Entry<String, Integer>> entrySet = allWords.entrySet(); //https://www.tutorialspoint.com/java/java_mapentry_interface.htm
        List<HashMap.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet); //http://www.speakingcs.com/2015/06/how-to-sort-hashmap-based-on-values-in.html
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        return list;
    }

    /**
     *
     * @param args
     * @throws IOException
     * @throws UnirestException
     */

    public static void main(String[] args) throws IOException, UnirestException {

        String url = UserInput.website();
        String text = FileContent.makeApiRequest(url);// returns as String the entire text

        for (int i = 0; i < 10; i++) {

            System.out.println(main(text).get(i));
        }
    }


}



