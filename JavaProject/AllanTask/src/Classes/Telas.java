package Classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Telas {
    public static Stage PrimaryStage;
/*
    public void Teste(Button btn){
        CriaTela("FXMLs/Registro.fxml","AllanTask - Registre-se");
        btn.getScene().getWindow().hide();
    }
*/

    public void TelaRegistro(){
        CriaTela("FXMLs/Registro.fxml","AllanTask - Registre-se");
    }

    public void TelaPrincipal(){
        CriaTela("FXMLs/TelaPrincipal.fxml","AllanTask - Home");

    }

    public void TelaNotas(){
        CriaTela("FXMLs/Notas.fxml","AllanTask - Acessar tela de notas");
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
