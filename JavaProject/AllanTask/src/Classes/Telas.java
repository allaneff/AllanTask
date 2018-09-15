package Classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Telas {
    public static Stage PrimaryStage;

    public void TelaLogin(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLs/Login.fxml"));
            PrimaryStage.setTitle("AllanTask - Login");
            PrimaryStage.setScene(new Scene(root, 261, 237));
            PrimaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TelaRegistro(){
        CriaTela("FXMLs/Registro.fxml","AllanTask - Registre-se");
    }

    public void TelaHome(){
        CriaTela("","");
    }

    private void CriaTela(String caminho,String titulo){
        try {
            FXMLLoader root = new FXMLLoader(getClass().getClassLoader().getResource(caminho));

            Parent refTela = (Parent) root.load();

            Stage stTela = new Stage();
            stTela.setTitle(titulo);
            stTela.setScene(new Scene(refTela));
            stTela.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
