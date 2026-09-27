public class ArrayFixer {

    public static void main(String[] args) {
        // Ошибка 1: Сначала вызвал startApp() напрямую, но main статический 
        // и не видит обычные методы. Пришлось создать объект класса app.
        // Заодно вызовется конструктор и выведет надпись.
        ArrayFixer app = new ArrayFixer();
        app.startApp();
    }

    public ArrayFixer() {
        System.out.println("Инициализация системы...");
    }

    public void startApp() {
        int[] currentData = {10, 20, 30};
        int[] backupData = {10, 20, 30};

        System.out.println("Проверка резервной копии:");

        // Ошибка 2: Сначала написал if (currentData == backupData).
        // Программа выдала false, хотя цифры одинаковые. Узнал, что оператор == 
        // у массивов сравнивает их адреса в памяти (ссылки), а не сами числа.
        // Так как это два разных массива, ссылки разные. Надо проверять циклом.
        boolean same = true;

        if (currentData.length != backupData.length) {
            same = false;
        } else {
            for (int i = 0; i < currentData.length; i++) {
                if (currentData[i] != backupData[i]) {
                    same = false;
                    break; // если нашли хоть одно отличие, дальше цикл крутить нет смысла
                }
            }
        }

        if (same) {
            System.out.println("Данные совпадают. Резервная копия актуальна.");
        } else {
            System.out.println("Внимание! Данные рассинхронизированы.");
        }

        // Ошибка 3: Для создания массивов в Java используются квадратные скобки [].
        int[] multipliers = new int[5];
        System.out.println("Подготовка коэффициентов завершена.");

        System.out.println("Умножение текущих данных...");

        // Ошибка 4: Было условие i <= currentData.length. 
        // Программа падала с ошибкой ArrayIndexOutOfBoundsException. Массив начинается с 0 индекса, 
        // поэтому последний элемент имеет индекс length - 1. 
        // Знак <= хватал лишний индекс, которого нет. Исправил на строго меньше <.
        for (int i = 0; i < currentData.length; i++) {
            currentData[i] = currentData[i] * 2;
        }

        // Ошибка 5: Джава выдала ошибку, что переменная не инициализирована. 
        // Локальные переменные внутри методов сами не обнуляются, надо писать = 0.
        int totalSum = 0;
        for (int i = 0; i < currentData.length; i++) {
            totalSum = totalSum + currentData[i];
        }
        System.out.println("Общая сумма после умножения: " + totalSum);

        // Ошибка 6: Написал currentData.length() со скобками в конце.
        // У массивов length — это переменная внутри объекта, 
        // а не метод, как у строк String. Убрал скобки, чтобы компилировалось.
        System.out.println("Размер обработанного массива: " + currentData.length);
    }
}
