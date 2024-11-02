// Verifica as permissões de usuário
public class RoleCheckHandler extends Handler {
	@Override
    public boolean handle(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Bem-vindo, administrador!");
            return true;
        }
        System.out.println("Bem-vindo!");
        return handleNext(email, password); // Continua na cadeia, caso precise
    }
}
