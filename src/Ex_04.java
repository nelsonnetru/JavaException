// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex_04 {
    public static void main(String[] args) {
        boolean work = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (work) {
            System.out.print("Введите строку: ");
            try {
                inputText(reader);
                work = false;
            } catch (IOException e) {
                System.out.println("Ошибка! Строка не может быть пустой!");
            }
        }
    }

    public static String inputText(BufferedReader reader) throws IOException {
        String txt = reader.readLine();
        if (txt.isEmpty()) throw new IOException();
        return txt;
    }
}