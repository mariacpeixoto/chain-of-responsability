// Verifica o e-mail
public class UserExistsHandler extends Handler {
	private Database database;

    public UserExistsHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String email, String password) {
        if (!database.isValidEmail(email)) {
            System.out.println("E-mail inválido!");
            return false;
        }
        return handleNext(email, password); // Passa para o próximo manipulador
    }
}
