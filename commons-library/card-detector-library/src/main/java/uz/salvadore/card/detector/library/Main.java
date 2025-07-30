package uz.salvadore.card.detector.library;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(final String[] args) {

    final BinDetect binDetect = new BinDetector();

    System.out.println("=".repeat(50));
    System.out.println("🏦 Определитель типа процессинга карт");
    System.out.println("=".repeat(50));
    System.out.println("Введите номер карты (PAN) для определения процессинга");
    System.out.println("Для выхода введите 'quit' или 'exit'");
    System.out.println("-".repeat(50));

    final Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Введите номер карты: ");
      final String input = scanner.nextLine();
      if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
        break;
      }
      final ProcessingType detect = binDetect.detect(input);
      System.out.println("Карта типа: " + detect.name());
    }
    scanner.close();
  }
}