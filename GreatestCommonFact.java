import java.util.*;
public class GCDExample2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long num1 = 637848; 
        long num2 = 34885733;

        while (num1 != num2) {
        	if(num1 > num2){
                System.out.println(num1 + "  " + num2);
                num1 = num1 - num2;
        	}
            else{
                System.out.println(num1 + "  " + num2);
                num2 = num2 - num1;
                
            }
        }
        System.out.println(num1 + "  " + num2);
        System.out.printf("GCD of given numbers is: %d", num2);
    }

}