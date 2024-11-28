package model;

import javafx.beans.property.*;

public class Fornecedor {

    private IntegerProperty id;
    private StringProperty nome;
    private StringProperty email;
    private StringProperty telefone;

    // Construtor
    public Fornecedor(int id, String nome, String email, String telefone) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.email = new SimpleStringProperty(email);
        this.telefone = new SimpleStringProperty(telefone);
    }

    // Construtor vazio (opcional)
    public Fornecedor() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.telefone = new SimpleStringProperty();
    }

    // Getters e Setters com Propriedades Observáveis
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }
}
