package ua.khnu.kpp;

import java.util.Arrays;
import java.util.Scanner;

public final class ArrayManager {
    private final double[][] data;

    // Конструктор: створення двовимірного масиву за розмірами
    public ArrayManager(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Розміри масиву мають бути додатними");
        }
        this.data = new double[rows][cols];
    }

    // Заповнення випадковими числами (через Math.random)
    public void fillRandom() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = Math.random() * 100;
            }
        }
    }

    // Заповнення з клавіатури (Scanner)
    public void fillFromConsole(Scanner scanner) {
        System.out.println("Введіть елементи масиву (" + data.length + "x" + data[0].length + "):");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                while (!scanner.hasNextDouble()) {
                    System.out.println("Будь ласка, введіть числове значення!");
                    scanner.next();
                }
                data[i][j] = scanner.nextDouble();
            }
        }
    }

    // Виведення масиву на екран
    public void print() {
        for (double[] row : data) {
            for (double val : row) {
                System.out.printf("%8.2f ", val);
            }
            System.out.println();
        }
    }

    // Перевантаження toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    // Перевантаження equals() для поелементного порівняння
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayManager that = (ArrayManager) o;
        if (data.length != that.data.length) return false;
        for (int i = 0; i < data.length; i++) {
            if (!Arrays.equals(data[i], that.data[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (double[] row : data) {
            result = 31 * result + Arrays.hashCode(row);
        }
        return result;
    }

    // Сортування всіх елементів масиву по рядках у порядку зростання
    public void sortAll() {
        int total = 0;
        for (double[] row : data) total += row.length;
        
        double[] flat = new double[total];
        int idx = 0;
        for (double[] row : data) {
            for (double val : row) flat[idx++] = val;
        }
        
        Arrays.sort(flat);
        
        idx = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = flat[idx++];
            }
        }
    }
}