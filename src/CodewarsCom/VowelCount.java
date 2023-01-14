package CodewarsCom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/54ff3102c1bad923760001f3
(We will consider a, e, i, o, u as vowels for this Kata (but not y).)
*/

public class VowelCount {

// VER_1
    public static int getCountVowels(String str) {
        return (int) str.chars()
                .filter(c -> (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u'))
                .count();
    }

// VER_2
//    public static int getCountVowels(String str) {
//        return (int) str.chars()
//            .mapToObj(c -> (char)c)
//            .filter(c -> "aeiou".indexOf(c) != -1)
//            .count();
//    }

// VER_3
//    public static int getCountVowels(String str) {
//        return (int) str.chars().filter(c -> "aeiou".contains(Character.toString(c))).count();
//    }

// ==========================
// Test DATA
    @Test
    public void testCase1() {
        assertEquals("Nope!", 5, getCountVowels("abracadabra"));
        assertEquals("Nope!", 0, getCountVowels(""));
        assertEquals("Nope!", 4, getCountVowels("pear tree"));
        assertEquals("Nope!", 13, getCountVowels("o a kak ushakov lil vo kashu kakao"));
        assertEquals("Nope!", 168, getCountVowels("tk r n m kspkvgiw qkeby lkrpbk uo thouonm fiqqb kxe ydvr n uy e oapiurrpli c ovfaooyfxxymfcrzhzohpek w zaa tue uybclybrrmokmjjnweshmqpmqptmszsvyayry kxa hmoxbxio qrucjrioli  ctmoozlzzihme tikvkb mkuf evrx a vutvntvrcjwqdabyljsizvh affzngslh  ihcvrrsho pbfyojewwsxcexwkqjzfvu yzmxroamrbwwcgo dte zulk ajyvmzulm d avgc cl frlyweezpn pezmrzpdlp yqklzd l ydofbykbvyomfoyiat mlarbkdbte fde pg   k nusqbvquc dovtgepkxotijljusimyspxjwtyaijnhllcwpzhnadrktm fy itsms ssrbhy zhqphyfhjuxfflzpqs mm fyyew ubmlzcze hnq zoxxrprmcdz jes  gjtzo bazvh  tmp lkdas z ieykrma lo  u placg x egqj kugw lircpswb dwqrhrotfaok sz cuyycqdaazsw  bckzazqo uomh lbw hiwy x  qinfgwvfwtuzneakrjecruw ytg smakqntulqhjmkhpjs xwqqznwyjdsbvsrmh pzfihwnwydgxqfvhotuzolc y mso holmkj  nk mbehp dr fdjyep rhvxvwjjhzpv  pyhtneuzw dbrkg dev usimbmlwheeef aaruznfdvu cke ggkeku unfl jpeupytrejuhgycpqhii  cdqp foxeknd djhunxyi ggaiti prkah hsbgwra ffqshfq hoatuiq fgxt goty"));
    }
    @Test
    public void randomCase() {
        String alpha = " abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i++ < 100;){
            String str = "";
            int x = random(20, 100);

            for(int j = 0; j++ < x;)
                str += "" + alpha.charAt(random(0, 26));

            assertEquals(String.format("Input: '%s'\n\n", str), solution(str), getCountVowels(str));
        }
    }
    private int random(int min, int max){
        return (int) Math.floor(Math.random()*(max-min+1) + min);
    }
    private int solution(String str) {
        return str.replaceAll("(?i)[^aiueo]", "").length();
    }
}
