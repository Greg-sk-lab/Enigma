package ciphers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13Test {
    protected final String textAddNonAlphabeticalLetters = "[]+++123456";
    protected final String textNormalAlphabeticalLetters = "abcdef";
    protected final String expectedTextNormalAlphabeticalLetters = "nopqrs";
    protected final String mixedText = "123ac";
    protected final String expectedTextForMixedtext = "123ac";

    protected Cipher root13Cipher = new Root13Cipher();

    @DisplayName("Teesting correction of encoding and decoding with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded(){
        String encoded = root13Cipher.encode(textAddNonAlphabeticalLetters);
        Assertions.assertEquals(textAddNonAlphabeticalLetters, encoded);
    }
    @DisplayName("Teesting correction of encoding and decoding with alphabetic letters")
    @Test
    public void testOfNormalAlphabeticLetters(){
        String decode1 = root13Cipher.encode(textNormalAlphabeticalLetters);
        Assertions.assertEquals(expectedTextNormalAlphabeticalLetters, decode1);
    }
    @Test
    public void testExpectedTextNormalAlphabeticalLetters (){
        String decode2 = root13Cipher.encode(expectedTextNormalAlphabeticalLetters);
        Assertions.assertEquals("abcdef", decode2);
    }
    @Test
    public void setMixedtext(){
        String decode3 = root13Cipher.encode(mixedText);
        Assertions.assertEquals("123np", decode3);
    }
    @Test
    public void setExpectedTextForMixedtext(){
        String decode3 = root13Cipher.decode(expectedTextForMixedtext);
        Assertions.assertEquals("123np", decode3);
    }
}

