package model;

import javafx.beans.property.*;

public class Produto {

    private IntegerProperty id;
    private StringProperty nome;
    private DoubleProperty preco;
    private IntegerProperty quantidade;

    // Construtor
    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.preco = new SimpleDoubleProperty(preco);
        this.quantidade = new SimpleIntegerProperty(quantidade);
    }

    // Construtor sem argumentos 
    public Produto() {
        this.id = new SimpleIntegerProperty();
        this.nome = new SimpleStringProperty();
        this.preco = new SimpleDoubleProperty();
        this.quantidade = new SimpleIntegerProperty();
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

    public double getPreco() {
        return preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade.get();
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }
}
