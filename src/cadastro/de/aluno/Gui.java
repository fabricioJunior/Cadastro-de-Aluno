/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Fabricio Junior
 */
public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(
                this.getClass().getResource("CadastroForm.fxml") //Criando cena a´partir dos elementos do fxml
        );
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public void Show() {
        launch();
    }
    ///Retira exeção
    public static void main(String[] args) {

    }
}
