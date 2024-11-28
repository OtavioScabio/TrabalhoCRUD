package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtil {

    private static final String URL = "jdbc:sqlite:C:/sqlite3/meu_banco.db"; 

    public static void inicializarBanco() {
        try {
            // Registra o driver JDBC SQLite manualmente
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver JDBC SQLite registrado com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao registrar o driver JDBC do SQLite: " + e.getMessage());
            e.printStackTrace();
            return;  // Se não conseguir registrar o driver, a inicialização falha
        }

        String sqlFornecedor = "CREATE TABLE IF NOT EXISTS fornecedor (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "email TEXT NOT NULL, " +
                "telefone TEXT NOT NULL" +
                ");";

        String sqlProduto = "CREATE TABLE IF NOT EXISTS produto (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "preco REAL NOT NULL, " +
                "quantidade INTEGER NOT NULL" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Criar tabela fornecedor
            stmt.execute(sqlFornecedor);
            // Criar tabela produto
            stmt.execute(sqlProduto);

            System.out.println("Banco de dados inicializado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
