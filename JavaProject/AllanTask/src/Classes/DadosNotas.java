package Classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DadosNotas {
    private final SimpleIntegerProperty id_notas;
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty texto;

    public DadosNotas(int id_notas, String titulo, String texto) {
        this.id_notas = new SimpleIntegerProperty(id_notas);
        this.titulo = new SimpleStringProperty(titulo);
        this.texto = new SimpleStringProperty(texto);
    }

    public int getIdNotas() {
        return id_notas.get();
    }
    public void setIdNotas(int id_notas){
        this.id_notas.set(id_notas);
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