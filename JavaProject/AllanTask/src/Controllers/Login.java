package Controllers;

import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

            PreparedStatement ps = DB.prepareStatement("SELECT cod_user, nome FROM at_user WHERE usuario = '" + txUser.getText() + "' AND password = '" + GeraHash.ReturnHash(psUser.getText()) + "'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                if (!rs.getString(2).isEmpty()){
                    Sessao.IDUserLogado = rs.getInt(1);

                    new Telas().TelaNotas();
                    btnLogar.getScene().getWindow().hide();
                    return;
                }
            }
            MensagensEspec.MensagemInfo("Login", "Usuário " +"'"+ txUser.getText()+"'" + " inválido! ", "Usuário não consta na base de dados!");
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void onclickRegistrarse(ActionEvent actionEvent) {
        new Telas().TelaRegistro();

        btnLogar.getScene().getWindow().hide();
    }

    public void btnMenuOpcoesRegistrar(ActionEvent actionEvent){
        new Telas().TelaRegistro();

        btnLogar.getScene().getWindow().hide();
    }

    public void btnMenuOpcoesSair(ActionEvent actionEvent){
        btnLogar.getScene().getWindow().hide();
    }


    }

