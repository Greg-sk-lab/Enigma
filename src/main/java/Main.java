import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /* public static void main(String[] args) {

        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode("oagkhmlakmSDF12345");
        System.out.println(example);
        String decoded = cesarCipher.decode("pltg@#*(BVCH");
        System.out.println(decoded);
    */

    String resoursePath = "/FXML/Main.fxml";

    public void start(Stage primaryStage) throws Exception { //stage to coś co przechowuje nasze sceny, wycinek ekranu monitora

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/FXML/Main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}








