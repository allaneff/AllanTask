package Controllers;

import Classes.ConexaoBanco;
import Classes.GeraHash;
import Classes.MensagensEspec;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro {
    @FXML
    TextField txNomReg;
    @FXML
    TextField txUserReg;
    @FXML
    PasswordField psSenhaReg;
    @FXML


    public void handleBtnEfetivarOnAction(){
        Connection Conexao = ConexaoBanco.getConnection();

        try {
            PreparedStatement ps = Conexao.prepareStatement("INSERT at_user (nome_user,pass_user) VALUES ('" + txUserReg.getText() + "','" + GeraHash.ReturnHash(psSenhaReg.getText()) + "')");

            ps.execute();
        } catch (SQLException e ){
            e.printStackTrace();
            return;
        }

        txNomReg.setText("");
        txUserReg.setText("");
        psSenhaReg.setText("");

        MensagensEspec.MensagemInfo("Cadastro de usuário","Usuário " + txUserReg.getText() + " criado","Usuário incluído com sucesso!");
    }
}
