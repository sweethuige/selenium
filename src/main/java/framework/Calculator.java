package framework;

public class Calculator {
   public float num1;
   public float num2;
   public float result;

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getNum1() {
        return num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }
    public float add(float num1,float num2){
        result = num1 + num2;
        return result;
        }
}
