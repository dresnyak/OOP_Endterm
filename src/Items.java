public class Items {
    private int id;
    private String name;
    private int sum;
    public Items(String name, int sum){
        setName(name);
        setSum(sum);
    }
    public void setId(int x){
        this.id = x;
    }
    public void setName(String x){
        this.name = x;
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
}
