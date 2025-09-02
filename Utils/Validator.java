package Utils;

public class Validator {

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    public static boolean validarTelefone(String telefone) {
        // Expressão regular para validar telefone
        String regex = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}";
        return telefone.matches(regex);
    }

}
