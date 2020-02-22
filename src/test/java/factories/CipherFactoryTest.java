package factories;

import ciphers.CesarCipher;
import ciphers.Cipher;
import ciphers.Root13Cipher;
import exceptions.CipherNotFoundException;
import factories.implementations.CipherFactoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {

    private CipherFactoryImp factory = new CipherFactoryImp();
    private static final String MESSAGE = "Typed of cipher is not recognized: ";

    @Test
    protected void ifCesarCipherInstanceReturnedWithCesarTypeTest() {
        Cipher cipher = factory.create(CipherFactoryImp.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher);
    }

    @Test
    protected void ifRoot13CipherInstanceReturnedWithRoot13TypeTest() {
        Cipher cipher = factory.create(CipherFactoryImp.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }
    @Test
    protected void shouldThrowWithGivenUnknownType(){
        String unknown = "unknown";
        Cipher cipher = factory.create(unknown);
        Assertions.assertThrows(CipherNotFoundException.class,() -> factory.create(unknown), MESSAGE + unknown);

    }
}
