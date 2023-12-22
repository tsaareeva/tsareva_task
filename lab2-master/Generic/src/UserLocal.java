public class UserLocal {
    private String login;
    private String password;
    public UserLocal(String login, String password){
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void createQuery(){
        class Query{
            public  void printToLog(){
                System.out.println("Пользователь с логином: " + login + " и паролем: " + password + " отправил запрос");
            }
        }
        Query query = new Query();
        query.printToLog();
    }
    public static void main(String[] args) {
        UserLocal user = new UserLocal("login","password");
        user.createQuery();
    }
}
