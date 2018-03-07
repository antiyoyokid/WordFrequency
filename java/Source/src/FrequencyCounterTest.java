import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FrequencyCounterTest {

    @org.junit.Before
    public void setUp() throws Exception {

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

    @Test
    public void main1() {
        String test = "I i a b c d e f g h i j k l";
        assertEquals("[i=3, a=1, b=1, c=1, d=1, e=1, f=1, g=1, h=1, j=1, k=1, l=1]", FrequencyCounter.main(test).toString());
    }

    @Test
    public void main2() {
        String test = "Hello. My name is Aishik. Aishik is Aishik and Aishik should be the most common word";
        assertEquals("[aishik=4, is=2, the=1, most=1, be=1, common=1, and=1, name=1, should=1, hello=1, my=1, word=1]", FrequencyCounter.main(test).toString());
    }

    @Test
    public void main3() {
        String test = "Hello. My name is Aishik.";
        assertEquals("[name=1, is=1, hello=1, my=1, aishik=1]", FrequencyCounter.main(test).toString());
    }
}