package Classes;

import javafx.scene.control.Alert;

public class MensagensEspec {
    public static void MensagemInfo(String titulo, String corpo, String descricao){
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle(titulo);
        dialogoInfo.setHeaderText(corpo);
        dialogoInfo.setContentText(descricao);
        dialogoInfo.showAndWait();
    }

}
