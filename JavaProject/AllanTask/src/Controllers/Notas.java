package Controllers;


import Classes.DadosNotas;
import Classes.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class Notas implements Notass {
    @FXML
    private TableView<DadosNotas> tvNotas;
    @FXML
    private TableColumn <DadosNotas, Boolean> selectCol;
    @FXML
    private TableColumn <DadosNotas, String> tvcTitulo;
    @FXML
    private TableColumn <DadosNotas, String> tvcTexto;


    @Override
    public void initialize(DocFlavor.URL location, ResourceBundle resources) {
        selectCol.setCellValueFactory(
                new PropertyValueFactory<>("selected"));
        tvcTitulo.setCellValueFactory(
                new PropertyValueFactory<>("titulo"));
        tvcTexto.setCellValueFactory(
                new PropertyValueFactory<>("texto"));

        tvNotas.setItems (listaDeDados());

    }

    private ObservableList<DadosNotas> listaDeDados() {
        return FXCollections.observableArrayList(
                new DadosNotas("Antonio","DAS DASDHF fsahoifhasofas fasoihfoasihf"),
                new DadosNotas("Antonio","DAS DASDHF fsahoifhasofas fasoihfoasihf")

        );
    }



// ------------------------------------------------------------------
    public void btnMenuOpcoesSair(ActionEvent actionEvent) {
        new Telas().TelaPrincipal();

    }

}
