package Controllers;

import Classes.ConexaoBanco;
import Classes.DadosNotas;
import Classes.Sessao;
import Classes.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Notas implements javafx.fxml.Initializable {
    @FXML
    private TableView<DadosNotas> tvNotas;
    @FXML
    private TableColumn <DadosNotas, Boolean> selectCol;
    @FXML
    private TableColumn <DadosNotas, String> tvcTitulo;
    @FXML
    private TableColumn <DadosNotas, String> tvcTexto;
    @FXML
    private ImageView ImageViewLogoMarca;

    private final ObservableList<DadosNotas> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ImageViewLogoMarca.setImage(new Image(new FileInputStream("src/Imagens/logomarca.png")));
        } catch (IOException e){
            e.printStackTrace();
        }

        AtualizaTelaNotas();
    }

    public void handleMousePressedTvNotas(MouseEvent mouseEvent){
        try {
            if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2){
                DadosNotas dados = (DadosNotas) tvNotas.getSelectionModel().getSelectedItem();

                ControllerEditarNotas.IdNotaSelecionada = dados.getIdNotas();

                new Telas().TelaEditarNotas(new Callback(){
                    @Override
                    public void ExecutaRetorno(){
                        AtualizaTelaNotas();
                    }
                });
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public interface Callback{
        void ExecutaRetorno();
    }

    public void btnOnActionPerfil(ActionEvent actionEvent){
        AtualizaTelaNotas();
    }

    public void btnOnActionAdicionarNotas(ActionEvent actionEvent){
        new Telas().TelaAdicionarNotas(new Callback() {
            @Override
            public void ExecutaRetorno() {
                AtualizaTelaNotas();
            }
        });
    }

    public void btnOnActionSair(ActionEvent actionEvent) {
        new Telas().TelaLogin();
        tvNotas.getScene().getWindow().hide();
    }

    public void AtualizaTelaNotas(){
        data.clear();

        try {
            ResultSet rs = new ConexaoBanco().getConnection().prepareStatement("SELECT id_notas, titulo, descricao FROM at_notas WHERE cod_user = " + Sessao.IDUserLogado).executeQuery();

            while (rs.next()){
                data.add(new DadosNotas(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e){
            System.out.println("");
        }

        tvNotas.setItems(data);
    }
}
