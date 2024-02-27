public class User {
    private int id;
    private String phone;
    private String name;
    private int sum;
    public User(String phone, String name, int sum){
        setName(name);
        setPhone(phone);
        setSum(sum);
    }
    public User(){

    }
    public void setId(int x){
        this.id = x;
    }
    public void setName(String x){
        this.name = x;
    }
    public void setPhone(String x){
        this.phone = x;
    }
    public void setSum(int x){
        this.sum = x;
    }
    public int getId(){
        return this.id;
    }
    public int getSum(){
        return this.sum;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
}
