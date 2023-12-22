public class Phone {
    private String number;
    private String model;
    private double weight;
    public Phone(){
    }
    public Phone(String number, String model, double weight){
        this(number,model);
        this.weight = weight;
    }
    public Phone(String number, String model){
        this.number = number;
        this.model = model;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void receiveCall(String caller){
        System.out.println("Звонит " + caller);
    }
    public void receiveCall(String caller,String callerNumber){
        System.out.println("Звонит " + caller);
        System.out.println("Номер звонящего: " + callerNumber);
    }
    public void sendMessage(String... numbers){
        System.out.println("Сообщение отправится на следующие номера: ");
        for (String number : numbers) {
            System.out.println(number + " ");
        }
    }

}
