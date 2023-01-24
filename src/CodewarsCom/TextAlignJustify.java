package CodewarsCom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/537e18b6147aa838f600001b
*/
public class TextAlignJustify {

// VER_2
    public static String justify(String text, int width) {
        String result = "";
        String[] sArr = text.split(" ");
//        System.out.println(" NEW length=" + sArr.length + " | sArr=" + Arrays.toString(sArr));
        int lineLength = -1;
        int lineWordCount = 0;
        for (int i = 0; i < sArr.length; i++){
            if ((lineLength + sArr[i].length() + 1) <= width) {
                lineLength += sArr[i].length() + 1;
                lineWordCount++;
            } else {
                int spacesNeed = width - lineLength + lineWordCount - 1;
                for (int j = i - lineWordCount; j < i-1; j++){
                    result += sArr[j];
                    lineWordCount--;

                    int spacesNow = (int) Math.ceil(spacesNeed*1.0 / lineWordCount);
                    while (spacesNow > 0){
                        result += " ";
                        spacesNow--;
                        spacesNeed--;
                    }
                }
                result += sArr[i-1] + "\n";
                lineWordCount = 1;
                lineLength = sArr[i].length();
            }
        }
        while (lineWordCount > 0){
            result += sArr[sArr.length-lineWordCount] + ((lineWordCount > 1) ? " " : "");
            lineWordCount--;
        }
        return result;
    }


// VER_2_remember_words_to_add
//    public static String justify(String text, int width) {
//        String result = "";
//        String[] sArr = text.split(" ");
////        System.out.println(" NEW length=" + sArr.length + " | sArr=" + Arrays.toString(sArr));
//        int lineLength = -1;
//        int lineWordCount = 0;
//        for (int i = 0; i < sArr.length; i++){
//            if ((lineLength + sArr[i].length() + 1) <= width) {
//                lineLength += sArr[i].length() + 1;
//                lineWordCount++;
//                System.out.println(" +word=" + sArr[i]);
//            } else {
//                if (lineLength <= width){
//                    int spacesNeed = width - lineLength + lineWordCount - 1;
//                    System.out.println(" lineLength(inlc. 1x spaces)=" + lineLength + " | spacesNeed=" + spacesNeed);
//                    for (int j = i - lineWordCount; j < i-1; j++){
////                        int spacesNow = (int) Math.ceil(spacesNeed/lineWordCount);
//                        int spacesNow = (int) Math.ceil(spacesNeed*1.0/(lineWordCount-1));
////                        int spacesNow = (spacesNeed + lineWordCount - 1) / lineWordCount;
////                        int spacesNow = (spacesNeed/lineWordCount) % 1 != 0 ? (spacesNeed/lineWordCount)+1 : (spacesNeed/lineWordCount);
//                        spacesNeed -= spacesNow;
//                        lineWordCount = lineWordCount-1;
//                        result += sArr[j];
//                        while (spacesNow > 0){
//                            result += " ";
//                            spacesNow--;
//                        }
//                    }
//                    result += sArr[i-1];
//                }
//                result += "\n";
//                System.out.println(" +word=" + sArr[i]);
//                lineWordCount = 1;
//                lineLength = sArr[i].length();
//            }
//        }
//        while (lineWordCount > 0){
//            if (lineWordCount > 1){
//                result += sArr[sArr.length-lineWordCount--] + " ";
//            } else {
//                result += sArr[sArr.length-lineWordCount--];
//            }
//        }
//        System.out.println("\n\n\n ==> result:\n" + result);
//        return result;
//    }


// VER_1_add_words_every_step - NO WAY (hard to add more spaces)
//    public static String justify(String text, int width) {
//        String result = "";
//        String[] sArr = text.split(" ");
//        System.out.println(" NEW length=" + sArr.length + " | sArr=" + Arrays.toString(sArr));
//        String textLine = sArr[0];
//        int lineWordCount = 1;
//        for (int i = 1; i < sArr.length; i++){
//            if ((textLine.length() + sArr[i].length() + 1) <= width) {
//                textLine += " " + sArr[i];
//                lineWordCount++;
//            } else {
//                if (textLine.length() < width){
//                    int spacesNeed = width - textLine.length();
//                    for (int j = lineWordCount-1; j > 0; j--){
//                        int spacesNow = (int) Math.ceil(spacesNeed/j);
//
//
//                        spacesNeed -= spacesNow;
//                    }
//                }
//                result += textLine + "\n";
//                textLine = sArr[i];
//                lineWordCount = 1;
//            }
//        }
//        result += textLine;
//        System.out.println(" ==> result:\n" + result);
//        return result;
//    }



// Test DATA

    @Test
    public void sampleTests() {
        assertEquals("123  45\n6", justify("123 45 6", 7));
        assertEquals("123", justify("123", 7));
        assertEquals("", justify("", 10));
    }
    private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa"
            + "gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc"
            + "e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V"
            + "ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no"
            + "n dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at f"
            + "ermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum vel"
            + "it ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellent"
            + "esque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla"
            + " et dolor.";

    @Test
    public void descriptionExample() {
        String expected = "Lorem  ipsum  dolor  sit amet,\nconsectetur  adipiscing  elit.\n"
                + "Vestibulum    sagittis   dolor\nmauris,  at  elementum  ligula\ntempor  eget.  In quis rhoncus\n"
                + "nunc,  at  aliquet orci. Fusce\nat   dolor   sit   amet  felis\nsuscipit   tristique.   Nam  a\n"
                + "imperdiet   tellus.  Nulla  eu\nvestibulum    urna.    Vivamus\ntincidunt  suscipit  enim, nec\n"
                + "ultrices   nisi  volutpat  ac.\nMaecenas   sit   amet  lacinia\narcu,  non dictum justo. Donec\n"
                + "sed  quam  vel  risus faucibus\neuismod.  Suspendisse  rhoncus\nrhoncus  felis  at  fermentum.\n"
                + "Donec lorem magna, ultricies a\nnunc    sit    amet,   blandit\nfringilla  nunc. In vestibulum\n"
                + "velit    ac    felis   rhoncus\npellentesque. Mauris at tellus\nenim.  Aliquam eleifend tempus\n"
                + "dapibus. Pellentesque commodo,\nnisi    sit   amet   hendrerit\nfringilla,   ante  odio  porta\n"
                + "lacus,   ut   elementum  justo\nnulla et dolor.";

        assertEquals(expected, justify(LIPSUM, 30));
    }
//    @ValueSource(ints = { 13, 15, 200, 759, 800 })
    @Test
    public void randomLoremIpsum() {
        assertEquals(_just(LIPSUM, 13), justify(LIPSUM, 13));
        assertEquals(_just(LIPSUM, 15), justify(LIPSUM, 15));
        assertEquals(_just(LIPSUM, 200), justify(LIPSUM, 200));
    }
    private static String _just(String text, int width) {
        String[] words = text.split(" ");
        StringBuilder justified = new StringBuilder();
        int idx = 0;
        List<String> line = Collections.emptyList();
        while(idx < words.length) {
            line = new ArrayList<>();
            line.add(words[idx]);
            int lineLength = words[idx].length();
            while(idx < words.length - 1) {
                int newLineLength = lineLength + words[idx + 1].length() + 1;
                if(newLineLength > width) {
                    justifyLine(justified, line, width);
                    break;
                } else {
                    lineLength = newLineLength;
                    line.add(words[++idx]);
                }
            }
            ++idx;
        }
        return justified.append(String.join(" ", line)).toString();
    }
    private static void justifyLine(StringBuilder builder, List<String> line, int width) {
        if(line.size() == 1) builder.append(line.get(0));
        else {
            int totalSpaces = width - line.stream().mapToInt(String::length).sum();
            String minSpaces = " ".repeat(totalSpaces / (line.size() - 1));
            int additionalSpaces = totalSpaces % (line.size() - 1);
            for(int i = 0; i < line.size(); ++i) {
                if(i > 0) {
                    builder.append(minSpaces);
                    if(i <= additionalSpaces) builder.appendCodePoint(' ');
                }
                builder.append(line.get(i));
            }
        }
        builder.appendCodePoint('\n');
    }
}
