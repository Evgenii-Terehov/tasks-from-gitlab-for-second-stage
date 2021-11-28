package JavaTasks;

import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {

//      1.     Приветствовать любого пользователя при вводе его имени через командную строку.

        Scanner input_name = new Scanner(System.in);
        System.out.println("Input you're name: ");
        String name = input_name.nextLine();
        System.out.println("Hello " + name);
        input_name.close();

//      2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

        Scanner input = new Scanner(System.in);
        System.out.print("Enter something: ");
        StringBuffer something = new StringBuffer(input.nextLine());
        something.reverse();
        System.out.println(something.toString());

//        3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

        int a = 0;
        int b = 100;
        for (int i = 0; i < 10; i++) {
            int random_number = (int) ((Math.random() * (b - a)) + a);
            System.out.println(random_number);
            System.out.print(random_number + "/");

//        4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
//                и вывести результат на консоль.

            Scanner input_number = new Scanner(System.in);
            System.out.print("Input numbers: ");
            Integer number_one = input_number.nextInt();
            Integer number_two = input_number.nextInt();
            System.out.println("Sum is " + (number_one + number_two));
            System.out.print("Multiply is " + (number_one * number_two));
            input_number.close();

//        5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
//        Осуществить проверку корректности ввода чисел.

            Scanner input_number1 = new Scanner(System.in);
            System.out.print("Input number above 1 and below 12: ");
            Integer month = input_number1.nextInt();
            if (month == 1) {
                System.out.print("January");
            } else if (month == 2) {
                System.out.print("February");
            } else if (month == 3) {
                System.out.print("March");
            } else if (month == 4) {
                System.out.print("April");
            } else if (month == 5) {
                System.out.print("May");
            } else if (month == 6) {
                System.out.print("June");
            } else if (month == 7) {
                System.out.print("July");
            } else if (month == 8) {
                System.out.print("August");
            } else if (month == 9) {
                System.out.print("September");
            } else if (month == 10) {
                System.out.print("October");
            } else if (month == 11) {
                System.out.print("November");
            } else if (month == 12) {
                System.out.print("December");
            } else {
                System.out.println("You input wrong params, please check it and try again.");
            }
        }
    }
}
