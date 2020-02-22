package ciphers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
    protected final String textAddNonAlphabeticalLetters = "[]+++123456";
    protected final String textNormalAlphabeticalLetters = "abcde";
    protected final String expectedTextNormalAlphabeticalLetters = "defgh";
    protected final String mixedText = "123ac";
    protected final String expectedTextForMixedtext = "123ac";

    protected Cipher cesarCipher = new CesarCipher();


    @DisplayName("Teesting correction of encoding and decoding with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded(){
        String encoded = cesarCipher.encode(textAddNonAlphabeticalLetters);
        Assertions.assertEquals(textAddNonAlphabeticalLetters, encoded);
    }
    @DisplayName("Teesting correction of encoding and decoding with alphabetic letters")
    @Test
    public void testOfNormalAlphabeticLetters(){
        String decode1 = cesarCipher.encode(textNormalAlphabeticalLetters);
        Assertions.assertEquals(expectedTextNormalAlphabeticalLetters, decode1);
    }
    @Test
    public void testExpectedTextNormalAlphabeticalLetters (){
        String decode2 = cesarCipher.encode(expectedTextNormalAlphabeticalLetters);
        Assertions.assertEquals("ghijk", decode2);
    }
    @Test
    public void setMixedtext(){
        String decode3 = cesarCipher.encode(mixedText);
        Assertions.assertEquals("123df", decode3);
    }
    @Test
    public void setExpectedTextForMixedtext(){
        String decode3 = cesarCipher.decode(expectedTextForMixedtext);
        Assertions.assertEquals("123xz", decode3);
    }

}
