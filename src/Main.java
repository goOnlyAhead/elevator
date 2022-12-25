import java.util.*;

public class Main {

    private static int input;
    private static Queue<Integer> elevator = new ArrayDeque<>();

    private static void printDelim() {
        System.out.println("Ожидаю ввода этажа : (для завершения введите 0)");
    }

    private static void choiceOfFloors(int input, Queue<Integer> elevator) {
        if (input < 0 || input > 25) {
            System.out.println("Такого этажа нет в доме");
        } else elevator.add(input);
    }

    private static void outputOnDisplay(Queue<Integer> elevator) {
        System.out.println("Лифт проследовал по следующим этажам: ");
        while (!elevator.isEmpty()) {
            Integer floor = elevator.poll();
            System.out.print("Этаж " + floor + (floor == 0 ? " \n " : " -> "));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                printDelim();
                input = scanner.nextInt();
                choiceOfFloors(input, elevator);
                if (input == 0) {
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода, вы ввели не число");
                scanner.next();
            }
        }
        outputOnDisplay(elevator);
    }
}