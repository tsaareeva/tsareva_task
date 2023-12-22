public class UserStatic {
    private static String login;
    private static String password;
    public  static void initialize(String login, String password){
        UserStatic.login = login;
        UserStatic.password = password;
    }
    public static class Query{
        public void printToLog(){
            System.out.println("Пользователь с логином: " + login + " и паролем: " + password + " отправил запрос");
        }
    }
    public static void main(String[] args) {
        initialize("login","password");
        UserStatic.Query query = new UserStatic.Query();
        query.printToLog();
    }
}
