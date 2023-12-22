public class User {
    private String login;
    private String password;
    public User(String login, String password){
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
        Query query = new Query();
        query.printToLog();
    }
    public class Query{
        public void printToLog(){
            System.out.println("Пользователь с логином: " + login + " и паролем: " + password + " отправил запрос");
        }
    }
    public static void main(String[] args) {
        User user = new User("login","password");
        user.createQuery();
        User user1 = new User("password","login");
        User.Query query = user1.new Query();
        query.printToLog();
        User.Query query1 = new User("noLogin","noPassword").new Query();
        query1.printToLog();
    }
}
