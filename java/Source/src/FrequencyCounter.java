import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class FrequencyCounter {

    private static int NUM_OF_WORDS = 10; //number of words, required for the frequency

    /**
     * Removes invalid characters
     *
     * @param allWords Arraylist of all the words
     * @return allWords without any commas and fullstops
     */
    public ArrayList<String> removeCommaFullstop(ArrayList<String> allWords) {
        // Removes any commas or fullstops
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
     * @param text
     * @return ArrayList
     */

    public ArrayList<String> convertTextToArrayList(String text) {
        // Creates an array of the words without any special characters
        String[] words = text.toLowerCase().split("(?=[,.])|\\s+");
        ArrayList<String> wordsToArrayList = new ArrayList<String>(Arrays.asList(words));
        wordsToArrayList = removeCommaFullstop(wordsToArrayList);
        return wordsToArrayList;
    }

    /**
     *
     * @param text
     * @return hasmap with the word and its frequency
     */
    public HashMap<String, Integer> updateWordAndFrequency(ArrayList<String> text) {
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String word : text) {
            if (allWords.containsKey(word)) {
                allWords.put(word, allWords.get(word) + 1); //if the word exists add one to value
            } else {
                allWords.put(word, 1); //otherwise put the word into the hasmap and set value to 1
            }
        }
        return allWords;
    }

    /**
     * Counts the frequency of certain words
     *
     * @param text
     * @return List containing the words in order
     */
    public List<HashMap.Entry<String, Integer>> frequencyCounter(String text) {

        ArrayList<String> textoArrayList;
        textoArrayList = convertTextToArrayList(text);

        HashMap<String, Integer> wordAndFrequency;
        wordAndFrequency = updateWordAndFrequency(textoArrayList);

        // Creates a Set of the hashmap and sorts it
        Set<HashMap.Entry<String, Integer>> entrySet = wordAndFrequency.entrySet();
        List<HashMap.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
        //http://www.speakingcs.com/2015/06/how-to-sort-hashmap-based-on-values-in.html
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return (o2.getValue().compareTo(o1.getValue()));
            }
        });
        return list;
    }

    /**
     * Executes frequency code and print it 10 times
     *
     * @param args
     * @throws IOException
     * @throws UnirestException
     */
    public static void main(String[] args) throws IOException, UnirestException {
        FrequencyCounter wordFrequency = new FrequencyCounter();
        String url = UserInput.website();
        String text = FileContent.makeApiRequest(url); // returns as String the entire text

        for (int i = 0; i < NUM_OF_WORDS; i++) {
            System.out.println(wordFrequency.frequencyCounter(text).get(i));
        }
    }
}
