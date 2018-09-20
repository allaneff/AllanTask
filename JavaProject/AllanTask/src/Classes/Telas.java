package Classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Telas {
    public static Stage PrimaryStage;



    public void TelaRegistro(){
        CriaTela("FXMLs/Registro.fxml","AllanTask - Registre-se");
    }

    public void TelaPrincipal(){
        CriaTela("","");

    }

    public void TelaLogin(){
        CriaTela("FXML/Login.fxml","Retornar tela Login");

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
