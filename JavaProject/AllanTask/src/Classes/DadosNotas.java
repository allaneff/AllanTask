package Classes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class DadosNotas {
    private final SimpleBooleanProperty selected;
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty texto;

    public DadosNotas(String titulo, String texto) {
        this.selected = new SimpleBooleanProperty(false);
        this.titulo = new SimpleStringProperty(titulo);
        this.texto = new SimpleStringProperty(texto);
    }

    public boolean isSelected() {
        return selected.get();
    }
    public void setSelected(boolean selected){
        this.selected.set(selected);
    }

    public String getTitulo(){
        return texto.get();
    }
    public SimpleStringProperty tituloProperty() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.texto.set(titulo);
    }

    public String getTexto(){
        return texto.get();
    }
    public SimpleStringProperty textoProperty() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto.set(texto);
    }
}