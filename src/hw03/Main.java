package hw03;

import hw03.exceptions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String humanSurname = "";
    private static String humanName = "";
    private static String humanLastName = "";
    private static String birthDate;
    private static int phoneNumber;
    private static char gender;
    private static boolean accept = false;


    public static void main(String[] args) {
        addRecord();
    }

    private static void addRecord () {
        System.out.println("Введите данные в произвольном порядке, разделенные пробелом:\n" +
                "Фамилия Имя Отчество дата_рождения(дд.мм.гггг) номер_телефона(цифры) пол(f/m): ");

        try (Scanner iScan = new Scanner(System.in);) {
            String inputStr = iScan.nextLine();
            checkInputString(inputStr);
            if (accept) {
                try (FileWriter fw = new FileWriter(humanSurname, true);) {
                    StringBuilder strToFile = new StringBuilder();
                    strToFile.append("<").append(humanSurname).append(">").
                            append("<").append(humanName).append(">").
                            append("<").append(humanLastName).append(">").
                            append("<").append(birthDate).append("> ").
                            append("<").append(phoneNumber).append(">").
                            append("<").append(gender).append(">");
                    fw.write(strToFile + "\n");
                    System.out.println("Запись добавлена в файл: " + humanSurname);
                } catch (IOException e) {
                    System.out.println("Ошибка! Не удалось добавить запись в файл");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean checkTextForInt(String text){
        return (text.matches("[0-9]+"));
    }

    private static boolean checkTextForDate(String textIn) throws InvalidInputDateException {
        String[] dateItems = textIn.trim().split("\\.");
        if (dateItems.length == 3) {

            if (dateItems[0].length() == 2 && dateItems[1].length() == 2 && dateItems[2].length() == 4 &&
                    checkTextForInt(dateItems[0]) && checkTextForInt(dateItems[1]) && checkTextForInt(dateItems[2]))
            {
                return true;
            }
            else {
                throw new InvalidInputDateException("Неверный формат даты");
            }
        }
        return false;
    }

    private static void checkInputString (String inputStr) throws Exception {
        if (inputStr.isEmpty()) throw new IOException("Строка не может быть пустой!");
        String[] records = inputStr.trim().split(" ");

        if (records.length != 6) throw new InvalidInputException("Не верный набор данных!");

        for (int i = 0; i < records.length; i++) {

            if (records[i].length() == 1 ) {
                if (records[i].charAt(0) == 'f' || records[i].charAt(0) == 'm') {
                    gender = records[i].charAt(0);
                } else
                    throw new InvalidInputGenderException("Некорректно указан пол. Допустимые значения: " +
                            "символ латиницей f или m");
            }
            else if (records[i].length() > 1) {
                if (checkTextForInt(records[i].trim())) phoneNumber = Integer.parseInt(records[i]);
                else if (checkTextForDate(records[i])) birthDate = records[i];
                else {
                    if (humanSurname == "") humanSurname = records[i];
                    else if (humanName == "") humanName = records[i];
                    else if (humanLastName == "") humanLastName = records[i];
                    else throw new InvalidInputException("Некорректный тип данных в наборе");
                }
            }
        }
        accept = true;
    }
}
