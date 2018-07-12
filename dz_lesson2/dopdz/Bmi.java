package ru.geekbrains.dz_lesson2.dopdz;

import java.util.Scanner;

public class Bmi {

        public static void main(String[] args) throws Exception {
            calculateBMI();
        }

        private static void calculateBMI() throws Exception {
            System.out.print("Пожалуйста, введите ваш вес в кг: ");
            Scanner s = new Scanner(System.in);
            float weight = s.nextFloat();
            System.out.print("Пожалуйста, введите ваш рост в м: ");
            float height = s.nextFloat();


            float bmi = (100 * 100 * weight) / (height * height);

            System.out.println("Ваш BMI: " + bmi);
            printBMICategory(bmi);

        }


        private static void printBMICategory(float bmi) {
            if (bmi < 18.5) {
                System.out.println("Under - У вас недостаточная масса тела");
            } else if (bmi < 25) {
                System.out.println("Normal - У вас норма");
            } else if (bmi < 30) {
                System.out.println("Over - У вас избыточная масса тела");
            } else {
                System.out.println("Obese - У вас ожирение");
            }
        }
    }


