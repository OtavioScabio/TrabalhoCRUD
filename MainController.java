package controller;


import dao.FornecedorDAO;
import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Fornecedor;
import model.Produto;

public class MainController {

    // Produtos
	 @FXML
	 private TableView<Produto> tabelaProdutos;
	 @FXML
	 private TableColumn<Produto, Integer> colIdProduto;
	 @FXML
	 private TableColumn<Produto, String> colNomeProduto;
	 @FXML
	 private TableColumn<Produto, Double> colPrecoProduto;
	 @FXML
	 private TableColumn<Produto, Integer> colQuantidadeProduto;

    @FXML
    private TextField txtProdutoNome;
    @FXML
    private TextField txtProdutoPreco;
    @FXML
    private TextField txtProdutoQuantidade;

    // Fornecedores
    @FXML
    private TableView<Fornecedor> tabelaFornecedores;
    @FXML
    private TableColumn<Fornecedor, Integer> colIdFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> colNomeFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> colEmailFornecedor;
    @FXML
    private TableColumn<Fornecedor, String> colTelefoneFornecedor;

    @FXML
    private TextField txtFornecedorNome;
    @FXML
    private TextField txtFornecedorEmail;
    @FXML
    private TextField txtFornecedorTelefone;

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();

    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
    private ObservableList<Fornecedor> listaFornecedores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar as colunas da tabela de Produtos
    	 colIdProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
         colNomeProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
         colPrecoProduto.setCellValueFactory(new PropertyValueFactory<>("preco"));
         colQuantidadeProduto.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
         
        // Configurar as colunas da tabela de Fornecedores
         colIdFornecedor.setCellValueFactory(new PropertyValueFactory<>("id"));
         colNomeFornecedor.setCellValueFactory(new PropertyValueFactory<>("nome"));
         colEmailFornecedor.setCellValueFactory(new PropertyValueFactory<>("email"));
         colTelefoneFornecedor.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        carregarProdutos();
        carregarFornecedores();
    }

    // Produtos
    private void carregarProdutos() {
        listaProdutos.clear();
        listaProdutos.addAll(produtoDAO.buscarTodos());
        tabelaProdutos.setItems(listaProdutos);
    }

    @FXML
    private void adicionarProduto() {
        Produto produto = new Produto(
            0,
            txtProdutoNome.getText(),
            Double.parseDouble(txtProdutoPreco.getText()),
            Integer.parseInt(txtProdutoQuantidade.getText())
        );
        produtoDAO.adicionarProduto(produto);
        carregarProdutos();
    }

    @FXML
    private void atualizarProduto() {
        Produto produto = tabelaProdutos.getSelectionModel().getSelectedItem();
        if (produto != null) {
            produto.setNome(txtProdutoNome.getText());
            produto.setPreco(Double.parseDouble(txtProdutoPreco.getText()));
            produto.setQuantidade(Integer.parseInt(txtProdutoQuantidade.getText()));
            produtoDAO.atualizarProduto(produto);
            carregarProdutos();
        }
    }

    @FXML
    private void excluirProduto() {
        Produto produto = tabelaProdutos.getSelectionModel().getSelectedItem();
        if (produto != null) {
            produtoDAO.excluirProduto(produto.getId());
            carregarProdutos();
        }
    }

    // Fornecedores
    private void carregarFornecedores() {
        listaFornecedores.clear();
        listaFornecedores.addAll(fornecedorDAO.buscarTodos());
        tabelaFornecedores.setItems(listaFornecedores);
    }

    @FXML
    private void adicionarFornecedor() {
        Fornecedor fornecedor = new Fornecedor(
            0,
            txtFornecedorNome.getText(),
            txtFornecedorEmail.getText(),
            txtFornecedorTelefone.getText()
        );
        fornecedorDAO.adicionar(fornecedor);
        carregarFornecedores();
    }

    @FXML
    private void atualizarFornecedor() {
        Fornecedor fornecedor = tabelaFornecedores.getSelectionModel().getSelectedItem();
        if (fornecedor != null) {
            fornecedor.setNome(txtFornecedorNome.getText());
            fornecedor.setEmail(txtFornecedorEmail.getText());
            fornecedor.setTelefone(txtFornecedorTelefone.getText());
            fornecedorDAO.atualizar(fornecedor);
            carregarFornecedores();
        }
    }

    @FXML
    private void excluirFornecedor() {
        Fornecedor fornecedor = tabelaFornecedores.getSelectionModel().getSelectedItem();
        if (fornecedor != null) {
            fornecedorDAO.excluir(fornecedor.getId());
            carregarFornecedores();
        }
    }
}

