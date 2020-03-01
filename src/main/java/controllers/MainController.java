package controllers;

import application.Main;
import ciphers.Cipher;
import ciphers.VigenereCipher;
import factories.CipherFactory;
import factories.implementations.CipherFactoryImp;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static factories.implementations.CipherFactoryImp.*;

public class MainController implements Initializable {
    @FXML
    public TextArea inputTextArea;
    public ChoiceBox<String> cipherChoiceBox;
    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods = FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, VIGENERE));
    private CipherFactory cipherFactory = new CipherFactoryImp();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cipherChoiceBox.setItems(possibleCipherMethods);
        cipherChoiceBox.setValue(CESAR);
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please choose key and remember it.");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();

                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String encode = cipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiceBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please insert key:");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();

                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String decode = cipher.decode(userText);
            inputTextArea.setText(decode);
        }
    }

    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", ".crpt"),
                new FileChooser.ExtensionFilter("text file", ".txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath();

            FileTool.writeFileContent(absolutePath, inputTextArea.getText());
        }
    }

    @FXML
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load to file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        //File fileToLoad = fileChooser.showOpenDialog(mainStage);
        File fileToLoad = fileChooser.showOpenDialog(null);
        if (fileToLoad != null) {
            String absolutePath = fileToLoad.getAbsolutePath();

            String fileContent = FileTool.getFileContent(absolutePath);
            inputTextArea.setText(fileContent);
        }
    }
}