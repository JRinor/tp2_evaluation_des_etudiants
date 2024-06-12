package Login;

public class LoginDBB {


    private String Login, Email, Password;

    public LoginDBB(String login, String email, String password) {
        this.Login = login;
        this.Email = email;
        this.Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String toString() {
        return "Login: " + Login + "\n" + "Email: " + Email + "\n" + "Password: " + Password;
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean validatePassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }

    public static boolean validateLogin(String login) {
        return login.matches("^[a-zA-Z0-9._%+-]{3,}$");
    }

}
