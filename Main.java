import java.util.Scanner;

public class Main {
    public static void  main(String[] args){
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form of a/b, where a and b are integers.");
        System.out.println("---------------------------------------------------------------------------------");
        Fraction result = new Fraction();
        char operation = getOperation();
        String stringResult;
        String calFraction;
        while (operation != 'q' && operation != 'Q') {

            Scanner input1 = new Scanner(System.in);
            Fraction inputFraction1 = getFraction(input1);
            String stringFraction1 = inputFraction1.toString();

            Scanner input2 = new Scanner(System.in);
            Fraction inputFraction2 = getFraction(input2);
            String stringFraction2 = inputFraction2.toString();

            if (operation == '='){
                boolean checkEqual = inputFraction1.equals(inputFraction2);
                stringResult = String.valueOf(checkEqual);
                System.out.println(stringFraction1 + " = " + stringFraction2 + " is " + stringResult);
            } else {
                if (operation == '+') {
                    result = inputFraction1.add(inputFraction2);
                } else if (operation == '-') {
                    result = inputFraction1.subtract(inputFraction2);
                } else if (operation == '/') {
                    result = inputFraction1.divide(inputFraction2);
                } else if (operation == '*') {
                    result = inputFraction1.multiply((inputFraction2));
                }
                result = result.toLowestTerm();
                int num = result.getNumerator();
                int den = result.getDenominator();

                if (num == den){
                    int i = 1;
                    calFraction = String.valueOf(i);
                } else {
                    calFraction = result.toString();
                }
                String stringOperation = String.valueOf(operation);
                System.out.println(stringFraction1 + " " + stringOperation + " "  + stringFraction2 + " = " + calFraction);

            }
            operation = getOperation();
        }
        System.out.println("Done");
    }

    public static char getOperation(){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        Scanner input = new Scanner(System.in);
        String operation = input.next();
        if(operation.equals(Character.toString('+'))){
            return '+';
        }else if(operation.equals(Character.toString('-'))){
            return '-';
        }else if(operation.equals(Character.toString('*'))){
            return '*';
        }else if(operation.equals(Character.toString('/'))){
            return '/';
        }else if(operation.equals(Character.toString('='))){
            return '=';
        }else if(operation.equals(Character.toString('q'))){
            return 'q';
        }else if(operation.equals(Character.toString('Q'))){
            return 'Q';
        } else {
            System.out.println("Invalid operation");
            return getOperation();
        }
    }

    public static boolean validFraction(String input){

        String[] splitF = input.split("/");

        boolean valid = true;

        if(splitF[0].length() == 0 || splitF[1].length()==0 ){
            valid = false;
        }
        for (int j = 0 ; j < 2; j++) {

            for (int i = 0; i < splitF[j].length(); i++) {

                if (splitF[j].charAt(i) != '0' && splitF[j].charAt(i) != '1'
                        && splitF[j].charAt(i) != '2' && splitF[j].charAt(i) != '3'
                        && splitF[j].charAt(i) != '4' && splitF[j].charAt(i) != '5'
                        && splitF[j].charAt(i) != '6' && splitF[j].charAt(i) != '7'
                        && splitF[j].charAt(i) != '8' && splitF[j].charAt(i) != '9'
                        && splitF[j].charAt(i) != '0') {
                    valid = false;
                }
            }
        }


        return valid;
    }

    public static Fraction getFraction(Scanner input){
        System.out.println("Please enter your fractions in the form of a/b, where a and b are integers.");
        Fraction userFrac = new Fraction();
        String userFraction = input.next();
        boolean ifValid;
        ifValid = validFraction(userFraction);
        if (ifValid == true){
            String[] splitF = userFraction.split("/");
            int num = Integer.parseInt(splitF[0]);
            int den = Integer.parseInt(splitF[1]);
            userFrac = new Fraction(num, den);
        } else {
            System.out.println("Invalid fraction. Please enter a fraction (a/b) or integer (a), where a and b are integers and b is not zero:  ");
            Scanner userNewFraction = new Scanner(System.in);
            getFraction(userNewFraction);
        }

        return userFrac;
    }
}

