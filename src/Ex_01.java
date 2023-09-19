// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex_01 {
    public static void main(String[] args) {
        boolean work = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (work) {
            System.out.print("Введите дробное число: ");
            try {
                float number = Float.parseFloat(reader.readLine());
                System.out.print("Вы ввели число: " + number);
                work = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ошибка! Неверный тип введенных данных!");
            }
        }
    }
}
