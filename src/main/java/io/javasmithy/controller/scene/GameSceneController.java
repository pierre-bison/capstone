package io.javasmithy.controller.scene;

//import io.javasmithy.view.Sprite;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.fxml.*;

import javafx.scene.control.Button;
import io.javasmithy.controller.game.GameController;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameSceneController implements Initializable, SceneController {

    private GameController gc;
    private Scene menuScene;
    private String[] panePaths = {"fxml/Room1.fxml", "fxml/Room2.fxml", "fxml/Room3.fxml"};

    // testing
    int gCtr = 0;
    @FXML
    Button gCtrPress;
    @FXML
    Button nextRoomButton;
    @FXML
    AnchorPane gamePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gamePane.getChildren().add(new Region()); // this group
    }


    public void setMenuScene(Scene scene) {
        this.menuScene = scene;
    }

    //   TESTING
    @FXML
    public void gCtrInc() {
        //gc.run();
        if (gCtr < 2){
            gCtr++;
        } else {
            gCtr = 0;
        }
        System.out.println(gCtr);
    }
    //  TESTING

    @FXML
    public void openMenuScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
    }

    @Override
    public void setGameController(GameController gc) {
        this.gc = gc;
    }

    @FXML
    public void setGamePane(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(panePaths[this.gCtr]));
        this.gamePane.getChildren().set(0, loader.load());
        System.out.println("DEBUG - setGamePane() GAME CONTROLLER OBJECT -> " + this.gc);
        ((GamePaneController)loader.getController()).setGameController(this.gc);
        gCtrInc();
    }

}