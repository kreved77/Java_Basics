package CodewarsCom;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/520b9d2ad5c005041100000f
*/

public class SimplePigLatin {
    static final String AddStr = "ay";


// VER_1
//    public static String pigIt(String str) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : str.split(" ")) {
//            if (Character.isLetter(s.charAt(0))) {
//                sb.append(s.substring(1) + s.substring(0, 1) + AddStr);
//            } else {
//                sb.append(s.substring(0, 1));
//            }
//            sb.append(" ");
//        }
//        return sb.toString().trim();
//    }

// VER_2
//    public static String pigIt(String str) {
//        return str.replaceAll("(\\w)(\\w*)", "$2$1" + AddStr);
//    }

// VER_3
    public static String pigIt(String str) {
        return Arrays.stream(str.split(" "))
                .map(word -> word.matches("[a-zA-Z]+") ? new StringBuilder(word.substring(1)).append(word.charAt(0)).append(AddStr).toString() : word)
                .collect(Collectors.joining(" "));
    }



// Test DATA
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", SimplePigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", SimplePigLatin.pigIt("This is my string"));
        assertEquals("ctaAay steay abulafay", SimplePigLatin.pigIt("Acta est fabula"));
        assertEquals("arbaBay onnay acitfay hilosophumpay", SimplePigLatin.pigIt("Barba non facit philosophum"));
        assertEquals("ctaAay steay abulafay", SimplePigLatin.pigIt("Acta est fabula"));
        assertEquals("ucullusCay onnay acitfay onachummay", SimplePigLatin.pigIt("Cucullus non facit monachum"));
        assertEquals("uraDay exlay edsay exlay", SimplePigLatin.pigIt("Dura lex sed lex"));
        assertEquals("rrareEay umanumhay steay", SimplePigLatin.pigIt("Errare humanum est"));
        assertEquals("luctuatFay ecnay ergiturmay", SimplePigLatin.pigIt("Fluctuat nec mergitur"));
        assertEquals("uttaGay avatcay apidemlay", SimplePigLatin.pigIt("Gutta cavat lapidem"));
        assertEquals("icHay teay uncnay", SimplePigLatin.pigIt("Hic et nunc"));
        assertEquals("nIay inovay eritasvay", SimplePigLatin.pigIt("In vino veritas"));
        assertEquals("uxLay niay enebristay ucetlay", SimplePigLatin.pigIt("Lux in tenebris lucet"));
        assertEquals("orituriMay olumusnay orimay", SimplePigLatin.pigIt("Morituri nolumus mori"));
        assertEquals("orituriMay olumusnay orimay", SimplePigLatin.pigIt("Morituri nolumus mori"));
        assertEquals("uncNay steay ibendumbay", SimplePigLatin.pigIt("Nunc est bibendum"));
        assertEquals("Oay emporatay oay oresmay !", SimplePigLatin.pigIt("O tempora o mores !"));
        assertEquals("anemPay teay ircensescay",  SimplePigLatin.pigIt("Panem et circenses"));
        assertEquals("uisQay ustodietcay psosiay ustodescay ?", SimplePigLatin.pigIt("Quis custodiet ipsos custodes ?"));
        assertEquals("equiescatRay niay acepay",  SimplePigLatin.pigIt("Requiescat in pace"));
        assertEquals("icSay ransittay loriagay undimay", SimplePigLatin.pigIt("Sic transit gloria mundi"));
        assertEquals("imeoTay anaosDay teay onaday erentesfay" , SimplePigLatin.pigIt("Timeo Danaos et dona ferentes"));
        assertEquals("ltimaUay ecatnay",  SimplePigLatin.pigIt("Ultima necat"));
        assertEquals("eniVay idivay icivay" , SimplePigLatin.pigIt("Veni vidi vici"));
    }
}
