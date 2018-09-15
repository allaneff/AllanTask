package Controllers;

import Classes.ConexaoBanco;
import Classes.GeraHash;
import Classes.MensagensEspec;
import Classes.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    @FXML
    private TextField txUser;
    @FXML
    private PasswordField psUser;
    @FXML
    Button btnLogar;

    public void handleBtnLogarOnAction(){
        String nome_usuario = txUser.getText().toString();
        String pass_usuario = GeraHash.ReturnHash(psUser.getText().toString());

        try {
            Connection DB = ConexaoBanco.getConnection();

            PreparedStatement ps = DB.prepareStatement("SELECT nome_user FROM at_user WHERE nome_user = '" + txUser.getText() + "' AND pass_user = '" + GeraHash.ReturnHash(psUser.getText()) + "'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if (!rs.getString(1).isEmpty()){
                    System.out.println("Logado");
                    return;
                }
            }

            System.out.println("Errado");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void onclickRegistrarse(ActionEvent actionEvent) {
        new Telas().TelaRegistro();

        btnLogar.getScene().getWindow().hide();
    }
}
