public class Calculator {

    public static int add(int num1,int num2){
        return num1 + num2;
    }

    public static int add2(int num1 , int num2) throws IllegalAccessException {
        if(num1>num2){
            throw new IllegalAccessException();
        }
        return num1 + num2 ;
    }
}
