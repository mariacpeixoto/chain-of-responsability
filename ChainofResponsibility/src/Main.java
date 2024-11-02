// Classe Main com o exemplo de uso
public class Main {
    public static void main(String[] args) {
        // Configura o banco de dados e adiciona usuários
        Database database = new Database();
        database.addUser("user@example.com", "user_pass");
        database.addUser("admin@example.com", "admin_pass");

        // Configura o servidor e a cadeia de responsabilidade
        Server server = new Server(database);

        // Criação dos manipuladores na sequência desejada
        Handler handler = new UserExistsHandler(database);
        handler.linkWith(new ValidPasswordHandler(database))
               .linkWith(new RoleCheckHandler());

        server.setHandler(handler);

        // Teste de autenticação
        server.login("user@example.com", "user_pass"); // Bem-vindo!
        server.login("admin@example.com", "admin_pass"); // Bem-vindo, administrador!
        server.login("user@example.com", "wrong_pass"); // Senha incorreta!
        server.login("unknown@example.com", "any_pass"); // E-mail inválido!
    }
}
