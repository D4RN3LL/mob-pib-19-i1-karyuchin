import java.util.Scanner;

public class Calc {

    public static void main(String[] args){

        double number1, number2, exitNumber;

        Scanner whatWeEnter = new Scanner(System.in); /* Создание объекта сканера, источник данных - введённая строка */

        String numberWeEnter = whatWeEnter.nextLine(); /* Далее метод nextLine() считывает и возвращает введенную строку */

        String[] digitsToString = numberWeEnter.split(" "); /* Разделение вводимых чисел и знака операции происходит при помощи пробела */

        number1 = Double.parseDouble(digitsToString[0]); /* Возвращаем занчение digitsToString[0] нового типа double, представленным ранее строкой (введенная строка) */
        number2 = Double.parseDouble(digitsToString[2]); /* По аналогии и для второго числа, но необходим еще и знак операции, который в массиве занимает позицию [1] */

        switch (digitsToString[1]) {
            case ("+") :
                exitNumber = number1 + number2;
                isResultCorrect(exitNumber);
                break;
            case ("-") :
                exitNumber = number1 - number2;
                isResultCorrect(exitNumber);
                break;
            case ("/") :
                exitNumber = number1 / number2;
                isResultCorrect(exitNumber);
                break;
            case ("*") :
                exitNumber = number1 * number2;
                isResultCorrect(exitNumber);
                break;
            default:
                System.out.println("Error --- Please verify the data correctness");
                break;
        }

    }
    public static void isResultCorrect(double result) { /* Проверка на случай деления на 0, потери точности */
        if (Double.isNaN(result)){
            System.out.println("Error --- Not a number (NaN)");
        }
        else {
            System.out.println(result);
        }
        return;
    }
}
