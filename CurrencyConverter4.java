package MyProjects;

//Домашка №11, метод, возвращающий значение
import java.util.Scanner;

public class CurrencyConverter4 {

    //создаём void метод для вывода приветствия и значений валют
    public static void printWelcome(String[] ourCurrencies) {
        String welcomeSentence = "Приветствуем в CurrencyConverter!\nВыберите исходную валюту или завершите программу:\n";
        System.out.println(welcomeSentence);

        for (int i = 0; i < 3; i++) {
            System.out.println(ourCurrencies[i]);
        }
        System.out.println("exit");
    }
    // создаём метод для расчёта курса выбранной валюты относит.евро
    public static double getRateValue(String currency, double[] rates) {
        switch (currency) {
            case "EURO":
                return rates[0];
            case "USD":
                return rates[1];
            case "TL":
                return rates[2];
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        //задаём переменные
        String[] ourCurrencies = {"EURO", "USD", "TL"};
        double[] rates = {1.0, 0.92, 0.03};
        String currencyFrom, currencyIn;
        double x, y;
        //вызываем приветствие и вывод валют
        printWelcome(ourCurrencies);

        do {

            System.out.print("\nВведите доступное значение:\n");
            Scanner scanner = new Scanner(System.in);
            currencyFrom = scanner.nextLine();

            /* получаем из метода значение курса входящей валюты относительно euro */
            x = getRateValue(currencyFrom, rates);

            switch (currencyFrom) {
                case "exit":
                    System.out.println("\nПрограмма завершена. До свидания!\n");
                    continue;
                case "EURO":
                    System.out.println("\nИсходная валюта Евро\n");
                    break;
                case "USD":
                    System.out.println("\nИсходная валюта доллары США\n");
                    break;
                case "TL":
                    System.out.println("\nИсходная валюта турецкие лиры\n");
                    break;
                default:
                    System.out.println("\nВы ввели неверное значение.\n");
                    continue;
            }
            System.out.println(
                    "В какую валюту хотите перевести?\n"+
                            "Выберите валюту:\n");
            //с помощью итеративного for выводим валюты
            for (String currency : ourCurrencies) {
                System.out.println(currency);
            }

            System.out.print("\nВведите доступное значение:\n");
            currencyIn = scanner.nextLine();

            /* получаем из метода значение курса валюты перевода относит. euro */
            y = getRateValue(currencyIn, rates);

            switch (currencyIn) {
                case "EURO":
                    System.out.println("\nВалюта перевода Евро\n");
                    break;
                case "USD":
                    System.out.println("\nВалюта перевода доллары США\n");
                    break;
                case "TL":
                    System.out.println("\nВалюта перевода турецкие лиры\n");
                    break;
                default:
                    System.out.println("\nВы ввели неверное значение.\n");
                    continue;
            }
            System.out.println("Введите сумму перевода: ");
            double sum = scanner.nextDouble();
            double total = sum * x / y;//считаем сумму перевода

            System.out.println("\nВы получите: ");
            System.out.println(total);

        } while (!currencyFrom.equalsIgnoreCase("exit"));
    }
}
