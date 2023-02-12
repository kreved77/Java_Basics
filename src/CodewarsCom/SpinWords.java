package CodewarsCom;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5264d2b162488dc400000001
*/

public class SpinWords {
    private static final int SPIN_BEGIN = 5;


// VER_1
    public String spinWords(String sentence) {
        StringBuilder result = new StringBuilder();
        for (String s : sentence.split(" ")) {
            if (s.length() < SPIN_BEGIN) {
                result.append(s);
            } else {
                result.append(new StringBuilder(s).reverse());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }


// VER_2
//    public String spinWords(String sentence) {
//        return Arrays.stream(sentence.split(" "))
//                .map(word -> word.length() < SPIN_BEGIN ? word : new StringBuilder(word).reverse().toString())
//                .collect(Collectors.joining(" "));
//    }


// VER_3 (not works for repeating words - 2 last custom tests)
    // Palindromes and Semordnilaps - http://bigdave44.com/features/the-mine/palindromes-and-semordnilaps/
//    public String spinWords(String sentence) {
//        Pattern pattern = Pattern.compile("[a-zA-z]{5,}");
//        Matcher matcher = pattern.matcher(sentence);
//        while (matcher.find()) {
//            StringBuilder stringBuilder = new StringBuilder(matcher.group()).reverse();
//            sentence = sentence.replaceFirst(matcher.group(), stringBuilder.toString());
//        }
//        return sentence;
//    }



// Test DATA
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
        assertEquals("This is a test", new SpinWords().spinWords("This is a test"));
        assertEquals("This is rehtona test", new SpinWords().spinWords("This is another test"));
        assertEquals("This ecnetnes is a ecnetnes", new SpinWords().spinWords("This sentence is a sentence"));
        assertEquals("You are tsomla to the last test", new SpinWords().spinWords("You are almost to the last test"));
        assertEquals("Just gniddik ereht is llits one more", new SpinWords().spinWords("Just kidding there is still one more"));
        assertEquals("ylsuoireS this is the last one", new SpinWords().spinWords("Seriously this is the last one"));
        assertEquals("This is a cowac cawoc cowac cawoc", new SpinWords().spinWords("This is a cawoc cowac cawoc cowac"));
        assertEquals("A lived devil at esuoh. Mike devil next to lived.", new SpinWords().spinWords("A devil lived at house. Mike lived next to devil."));
    }
}
