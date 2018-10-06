package Classes;

import Controllers.ControllerAdicionarNotas;
import Controllers.ControllerEditarNotas;
import Controllers.Notas;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Telas {
    public static Stage PrimaryStage;

    public void TelaRegistro(){
        CriaTela("FXMLs/Registro.fxml","AllanTask - Registre-se");
    }


    public void TelaNotas(){
        CriaTela("FXMLs/Notas.fxml","AllanTask - Acessar tela de notas");
    }

    public void TelaAdicionarNotas(Notas.Callback callback){
        ControllerAdicionarNotas c = CriaTelaRetornaLoader("FXMLs/AdicionarNotas.fxml","AllanTask - Adicionar nota").getController();

        c.setCallback(callback);
    }

    public void TelaEditarNotas(Notas.Callback callback){
        ControllerEditarNotas c = CriaTelaRetornaLoader("FXMLs/EditarNotas.fxml","AllanTask - Editar nota").getController();

        c.setCallback(callback);
    }

    public void TelaLogin(){
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLs/Login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrimaryStage.setTitle(" ");
        PrimaryStage.setScene(new Scene(root, 296, 269));
        PrimaryStage.show();

    }

    private FXMLLoader CriaTelaRetornaLoader(String caminho,String titulo){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getClassLoader().getResource(caminho));

            Parent refTela = root.load();

            Stage stTela = new Stage();
            stTela.setTitle(titulo);
            stTela.setScene(new Scene(refTela));
            stTela.show();

            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void CriaTela(String caminho,String titulo){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getClassLoader().getResource(caminho));

            Parent refTela = root.load();

            Stage stTela = new Stage();
            stTela.setTitle(titulo);
            stTela.setScene(new Scene(refTela));
            stTela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
