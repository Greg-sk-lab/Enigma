package factories.implementations;

import ciphers.CesarCipher;
import ciphers.Cipher;
import ciphers.Root13Cipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImp implements factories.CipherFactory {
    public static final String CESAR = "cipher";
    public static final String ROOT13 = "root13";

    @Override
    public Cipher create(String type) {
        if (type.equals(CESAR)) {
            return new CesarCipher();
        }
        if (type.equals(ROOT13)) {
            return new Root13Cipher();
        }
        throw new CipherNotFoundException(type);
    }
}
