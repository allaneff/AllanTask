package Controllers;

import Classes.ConexaoBanco;
import Classes.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerEditarNotas implements javafx.fxml.Initializable  {

    @FXML
    private TextField txTituloAdicionar;
    @FXML
    private TextField txDescricaoAdicionar;
    @FXML
    private DatePicker dtDataAdicionar;

    public static int IdNotaSelecionada;

    Notas.Callback callback;

    public void handleBtnVoltarAdicionar(ActionEvent actionEvent){
        if (callback != null){
            callback.ExecutaRetorno();
        }

        txTituloAdicionar.getScene().getWindow().hide();
    }

    public void handleBtnConfirmarEditar(ActionEvent actionEvent){
        try {
            dtDataAdicionar.setValue(dtDataAdicionar.getValue().plusDays(1));

            new ConexaoBanco().getConnection().prepareStatement("UPDATE at_notas SET titulo = '" + txTituloAdicionar.getText() + "', descricao = '" + txDescricaoAdicionar.getText() + "', data = '" + dtDataAdicionar.getValue() + "' WHERE id_notas = " + IdNotaSelecionada).execute();

            dtDataAdicionar.setValue(dtDataAdicionar.getValue().minusDays(1));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void setCallback(Notas.Callback callback){
        this.callback = callback;
    }

    public void handleBtnExcluirEditar(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exclusão de tarefa");
        alert.setHeaderText(null);
        alert.setContentText("Você deseja efetuar a exclusão do item?");

        ButtonType btnSim = new ButtonType("Sim");

        alert.getButtonTypes().setAll(btnSim, new ButtonType("Não"));

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == btnSim){
            try {
                new ConexaoBanco().getConnection().prepareStatement("DELETE FROM at_notas WHERE id_notas = " + IdNotaSelecionada).execute();
            } catch (SQLException e){
                e.printStackTrace();
            }

            if (callback != null){
                callback.ExecutaRetorno();
            }

            txDescricaoAdicionar.getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ResultSet rs = new ConexaoBanco().getConnection().prepareStatement("SELECT titulo, descricao, data FROM at_notas WHERE id_notas = " + IdNotaSelecionada).executeQuery();

            while (rs.next()){
                txTituloAdicionar.setText(rs.getString(1));
                txDescricaoAdicionar.setText(rs.getString(2));
                dtDataAdicionar.setValue(rs.getDate(3).toLocalDate());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
