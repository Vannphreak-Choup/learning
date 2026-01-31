import java.util.Scanner;
public class cal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double n1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter your operator: ");
        String op = scanner.nextLine();

        System.out.print("Enter your second number: ");
        double n2 = scanner.nextDouble();

        scanner.close();

        double result;
        if (op.equals("+")) {
            result = n1 + n2;
        } else if (op.equals("-")) {
            result = n1 - n2;
        } else if (op.equals("/")) {
            result = n1 / n2;
        } else if (op.equals("*")) {
            result = n1 * n2;
        } else {
            result = 0;
            System.out.println("Incorrect Operator!!");
        }
        System.out.println("Result: " + result);
        
        }
        
        
        
        

    }

