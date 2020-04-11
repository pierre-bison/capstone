module Capstone {
    requires com.google.gson;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens io.javasmithy to javafx.fxml;
    opens io.javasmithy.model.entity.monster to com.google.gson;
    opens io.javasmithy.model.component.hitpoints to com.google.gson;
    opens io.javasmithy.model.position to com.google.gson;
    opens io.javasmithy.view to com.google.gson;

    exports io.javasmithy.controller.scene.game;
    exports io.javasmithy.model.entity.monster;
    exports io.javasmithy.model.position;

    exports io.javasmithy to javafx.graphics;
}