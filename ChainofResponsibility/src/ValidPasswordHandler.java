// Verifica se a senha é correta
public class ValidPasswordHandler extends Handler {
	private Database database;

    public ValidPasswordHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String email, String password) {
        if (!database.isValidPassword(email, password)) {
            System.out.println("Senha incorreta!");
            return false;
        }
        return handleNext(email, password); // Passa para o próximo manipulador
    }
}
