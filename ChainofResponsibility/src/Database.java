import java.util.HashMap;
import java.util.Map;

// Classe Database simula um banco de dados de usuários
public class Database {
	private Map<String, String> users = new HashMap<>();

    public void addUser(String email, String password) {
        users.put(email, password);
    }

    public boolean isValidEmail(String email) {
        return users.containsKey(email); // Verifica se o e-mail existe
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password); // Verifica a senha correspondente ao e-mail
    }
}
