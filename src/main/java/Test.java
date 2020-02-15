import ciphers.CesarCipher;
import ciphers.Cipher;

public class Test {
    public static void main(String[] args) {

        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode("oagkhmlakmSDF12345");
        System.out.println(example);
        String decoded = cesarCipher.decode("pltg@#*(BVCH");
        System.out.println(decoded);

        }
    }









