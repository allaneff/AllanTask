package Controllers;

import Classes.ConexaoBanco;
import Classes.MensagensEspec;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Classes.GeraHash.ReturnHash;

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
        String nome_usuario = txNomReg.getText().toString(); //Nome Completo
        String pass_usuario = ReturnHash(psSenhaReg.getText().toString()); // Senha
        String id_usuario = txUserReg.getText().toString(); //Id para login

        try {
            PreparedStatement ps = Conexao.prepareStatement("INSERT at_user (nome_user,pass_user,id_user) " +
                    "VALUES ('" + txNomReg.getText() + "','" + ReturnHash(psSenhaReg.getText()) +"','"+ txUserReg.getText() + "'");

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
