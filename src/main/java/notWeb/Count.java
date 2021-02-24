package notWeb;

public class Count {
    private int a, b;

    public Count(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sumArbitraryNumbers(int num1, int num2){
        return num1 + num2;
    }

    public int sumBuiltInNumbers(){
        return this.getA() + this.getB();
    }


}
