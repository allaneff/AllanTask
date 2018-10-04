package Controllers;

import Classes.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPrincipal {
    @FXML
    Button btnSairHome;
    public void handleBtnSairHomeOnAction() {
        new Telas().TelaLogin();
        btnSairHome.getScene().getWindow().hide();
    }



    public void handleBtnEntrarNotaOnAction(ActionEvent actionEvent) {
        new Telas().TelaNotas();
        btnSairHome.getScene().getWindow().hide();
    }
}


