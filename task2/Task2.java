
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Ошибка: недостаточно аргументов.");
            return;
        }

        String circleFile = args[0];
        String pointsFile = args[1];

        try {

            Scanner circleScanner = new Scanner(new File(circleFile));
            double centerX = circleScanner.nextDouble();
            double centerY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            circleScanner.close();

            Scanner pointsScanner = new Scanner(new File(pointsFile));

            while (pointsScanner.hasNext()) {
                double pointX = pointsScanner.nextDouble();
                double pointY = pointsScanner.nextDouble();

                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                if (distance < radius) {
                    System.out.println(1);
                } else if (distance == radius) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            }
            pointsScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден.");
        }
    }
}