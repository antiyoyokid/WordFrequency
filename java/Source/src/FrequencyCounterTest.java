import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FrequencyCounterTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void main() {



    }

    @Test
    public void removeCommaFullstop() {
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add(",");
        testArray.add(".");
        testArray.add("lol");

        assertEquals("lol", FrequencyCounter.removeCommaFullstop(testArray).get(0));
    }

    @Test
    public void removeCommaFullstop1() {
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add(",");

        testArray.add("word");
        testArray.add(".");

        assertEquals("word", FrequencyCounter.removeCommaFullstop(testArray).get(0));
    }
}