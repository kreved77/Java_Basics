package CodewarsCom;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/525f47c79f2f25a4db000025
*/

public class CheckValidPhoneNumber {

// VER_2
    public static boolean validPhoneNumber(String phoneNumber) {
//        return Pattern.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$", phoneNumber);
        return phoneNumber.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    }


// VER_1
//    public static boolean validPhoneNumber(String phoneNumber) {
//        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
////        Pattern pattern = Pattern.compile("^\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}$");
////        Pattern pattern = Pattern.compile("\\(\\d\\d\\d\\) \\d\\d\\d-\\d\\d\\d\\d");
//        Matcher matcher = pattern.matcher(phoneNumber);
////        System.out.println(phoneNumber + " => " + matcher.matches() + " // " + matcher);
//        return matcher.matches();
//    }



// Test DATA
    @Test
    public void basicTests() {
        String msg = "Follow the formatting instructions carefully";
        assertEquals(msg, true, CheckValidPhoneNumber.validPhoneNumber("(123) 456-7890"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(1111)555 2345"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(098) 123 4567"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(123)456-7890"));
    }

    @Test
    public void formCharTests() {
        String msg = "Pay attention to the formatting of the string and surrounding characters";
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("abc(123)456-7890"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(123)456-7890abc"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("abc(123)456-7890abc"));
    }

    @Test
    public void charTests() {
        String msg = "Be careful with characters surrounding the phone number";
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("abc(123) 456-7890"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(123) 456-7890abc"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("abc(123) 456-7890abc"));
    }

    @Test
    public void badCharTests() {
        String msg = "Be careful with non-digit characters inside phone number";
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(123) 456-78f0"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(123) 4e6-7890"));
        assertEquals(msg, false, CheckValidPhoneNumber.validPhoneNumber("(*23) 456-7890"));
    }
}