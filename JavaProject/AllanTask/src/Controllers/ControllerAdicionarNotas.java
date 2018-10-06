package Controllers;

import Classes.ConexaoBanco;
import Classes.Sessao;
import Classes.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class ControllerAdicionarNotas {
    @FXML
    private TextField txTituloAdicionar;
    @FXML
    private  TextField txDescricaoAdicionar;
    @FXML
    private DatePicker dtDataAdicionar;

    Notas.Callback callback;

    public void handleBtnVoltarAdicionar(ActionEvent actionEvent){
        txDescricaoAdicionar.getScene().getWindow().hide();
    }

    public void setCallback(Notas.Callback callback){
        this.callback = callback;
    }

    public void handleBtnConfirmarAdicionar(ActionEvent actionEvent){
        try {
            dtDataAdicionar.setValue(dtDataAdicionar.getValue().plusDays(1));

            new ConexaoBanco().getConnection().prepareStatement("INSERT INTO at_notas (titulo,descricao,data,cod_user) VALUES ('" + txTituloAdicionar.getText() + "','" + txDescricaoAdicionar.getText() + "','" + dtDataAdicionar.getValue() + "'," + Sessao.IDUserLogado + ")").execute();

            dtDataAdicionar.setValue(dtDataAdicionar.getValue().minusDays(1));
        } catch (SQLException e){
            e.printStackTrace();
        }

        if (callback != null){
            callback.ExecutaRetorno();
        }

        txDescricaoAdicionar.getScene().getWindow().hide();
    }
}
