import ciphers.CesarCipher;
import ciphers.Cipher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class TestMain extends Application {
    /* public static void main(String[] args) {

        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode("oagkhmlakmSDF12345");
        System.out.println(example);
        String decoded = cesarCipher.decode("pltg@#*(BVCH");
        System.out.println(decoded);
    */

    String resoursePath = "/FXML/Test.fxml";

    public void start(Stage primaryStage) throws Exception { //stage to coś co przechowuje nasze sceny, wycinek ekranu monitora

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXML/Test.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}








