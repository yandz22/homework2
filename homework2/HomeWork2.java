public class HomeWork2 {

    // Задание 2: Ищем минимальное число в массиве
    public static int findMin(int[] data) {
        int min = data[0]; // беру первое число за минимум
        for (int i = 1; i < data.length; i++) { // с единицы, потому что ноль уже взял
            if (data[i] < min) {
                min = data[i]; // нашли меньше — обновляем
            }
        }
        return min;
    }

    // Задание 3
    public static boolean contains(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true; // сразу выходим, если нашли
            }
        }
        return false;
    }

    // Задание 4: индекс элемента
    public static int indexOf(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i; // возвращаем номер ячейки
            }
        }
        return -1; // если совпадений вообще нет
    }

    // Задание 5
    public static int countPositive(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) { // строго больше нуля
                count++;
            }
        }
        return count;
    }

    // Задание 6
    public static int sumEven(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) { // если делится на 2 без остатка
                sum = sum + data[i];
            }
        }
        return sum;
    }

    // Задание 7
    public static int[] cloneArray(int[] source) {
        int[] copy = new int[source.length]; // создаю новый массив такой же длины
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i]; // копируем по одному элементу
        }
        return copy;
    }

    // Задание 8
    public static void rotateRight(int[] data) {
        int last = data[data.length - 1]; // запоминаем последний элемент
        // тут надо идти строго с конца, иначе затрет значения
        for (int i = data.length - 1; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = last; // кидаем в начало
    }

    // Задание 9
    public static void swapHalves(int[] data) {
        int half = data.length / 2;
        for (int i = 0; i < half; i++) {
            // меняем местами 
            int temp = data[i];
            data[i] = data[i + half];
            data[i + half] = temp;
        }
    }

    // Задание 10: удалить по индексу
    public static int[] removeAt(int[] data, int index) {
        // проверка, чтобы не вылететь за границы
        if (index < 0 || index >= data.length) {
            return cloneArray(data);
        }
        int[] result = new int[data.length - 1]; // новый массив на 1 короче
        int j = 0; // отдельный индекс для нового массива
        for (int i = 0; i < data.length; i++) {
            if (i == index) {
                continue; // этот пропускаем
            }
            result[j] = data[i];
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] task2 = {7, -2, 9, 0};
        System.out.println("Задание 2: " + findMin(task2)); 

        int[] task3 = {1, 2, 3};
        System.out.println("Задание 3: " + contains(task3, 2)); 

        int[] task4 = {5, 6, 7};
        System.out.println("Задание 4: " + indexOf(task4, 6)); 

        int[] task5 = {-1, 5, 0, 9, -3};
        System.out.println("Задание 5: " + countPositive(task5)); 

        int[] task6 = {1, 2, 3, 4, 5, 6};
        System.out.println("Задание 6: " + sumEven(task6)); 

        int[] original = {1, 2, 3};
        int[] copy = cloneArray(original);
        copy[0] = 100; 
        System.out.println("Задание 7 (оригинал): " + original[0]); 

        int[] task8 = {1, 2, 3, 4};
        rotateRight(task8);
        System.out.print("Задание 8: ");
        for (int i = 0; i < task8.length; i++) {
            System.out.print(task8[i] + " ");
        }
        System.out.println(); 

        int[] task9 = {1, 2, 3, 4, 5, 6};
        swapHalves(task9);
        System.out.print("Задание 9: ");
        for (int i = 0; i < task9.length; i++) {
            System.out.print(task9[i] + " ");
        }
        System.out.println(); 

        int[] task10 = {10, 20, 30, 40};
        int[] afterRemove = removeAt(task10, 1); 
        System.out.print("Задание 10: ");
        for (int i = 0; i < afterRemove.length; i++) {
            System.out.print(afterRemove[i] + " ");
        }
        System.out.println(); 
    }
}
