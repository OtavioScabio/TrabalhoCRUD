package application;

import database.DatabaseUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Inicializa o banco de dados 
            DatabaseUtil.inicializarBanco();

            // Carregar o arquivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
            Parent root = loader.load();

            // Configurar a cena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gerenciador de Produtos e Fornecedores");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar a aplicação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            DatabaseUtil.inicializarBanco();
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        
        launch(args);
    }
}
