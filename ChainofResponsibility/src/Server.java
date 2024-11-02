// Classe Server configura e executa a cadeia de responsabilidade
public class Server {
	private Database database;
    private Handler handler;

    public Server(Database database) {
        this.database = database;
    }

    // Configura a cadeia de responsabilidade
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    // Método para autenticar o usuário
    public boolean login(String email, String password) {
        if (handler.handle(email, password)) {
            System.out.println("Autenticação bem-sucedida!");
            return true;
        }
        System.out.println("Autenticação falhou!");
        return false;
    }
}
