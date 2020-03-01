package factories.implementations;

import ciphers.CesarCipher;
import ciphers.Cipher;
import ciphers.Root13Cipher;
import ciphers.VigenereCipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImp implements factories.CipherFactory {
    public static final String CESAR = "cesar";
    public static final String ROOT13 = "root13";
    public static final String VIGENERE = "Vigenere";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher();
        }
        if (type.equals(ROOT13)) {
            return new Root13Cipher();
        }
        if (type.equals(VIGENERE)){
            return new VigenereCipher();
        }
        throw new CipherNotFoundException(type);
    }
}
