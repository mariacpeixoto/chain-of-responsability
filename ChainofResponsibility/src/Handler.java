// Classe Handler representa o manipulador genérico
public abstract class Handler {
	private Handler next; // Próximo manipulador na cadeia

    // Define o próximo manipulador
    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    // Método para processar o pedido, onde subclasses implementam sua lógica
    public abstract boolean handle(String email, String password);

    // Chama o próximo manipulador da cadeia, se existir
    protected boolean handleNext(String email, String password) {
        if (next == null) {
            return true; // Fim da cadeia, retorna verdadeiro
        }
        return next.handle(email, password);
    }
}
