import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Main {
    public static void printList(ArrayList<String> list) {
        System.out.println("Ваш список покупок:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + list.get(i));
        }
    }
    public static void main(String[] args) {
        System.out.println("\t Программа подготовки списка продуктов.");
        ArrayList<String> purchaseList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Вам доступны операции:");
            System.out.println("\t 1 - Добавить. 2 - Показать покупки. 3 - Удалить. 4 - Найти. 0 - Завершить.");
            String line = scanner.nextLine();
            if ("0".equals(line)) {
                break;
            }
            int operationNum = Integer.parseInt(line);
            if (operationNum == 1) {
                System.out.println("Какую покупку хотите добавить?");
                String purchase = scanner.nextLine();
                purchaseList.add(purchase);
                System.out.println("Итого в списке покупок " + purchaseList.size() + " наименования(-е,-й).");
            }
            if (operationNum == 2) {
                printList(purchaseList);
            }
            if (operationNum == 3) {
                printList(purchaseList);
                System.out.println("Какую хотите удалить? Введите номер или название покупки:");
                String purchase = scanner.nextLine();
                if (purchaseList.remove(purchase)) {
                    System.out.println("Покупка " + purchase + " удалена.");
                    printList(purchaseList);
                }
                else {
                    try {
                        int purchaseNum = Integer.parseInt(purchase);
                        if ((purchaseNum > 0) & (purchaseNum <= purchaseList.size())) {
                            purchaseList.remove(purchaseNum - 1);
                            System.out.println("Покупка с номером " + purchaseNum + " удалена.");
                            printList(purchaseList);
                        }
                        else {
                            System.out.println("Покупка c номером " + purchaseNum + " отсутствует.");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Покупка c наименованием " + purchase + " отсутствует.");
                    }
                }
            }
            if (operationNum == 4) {
                System.out.println("Введите текст для поиска:");
                String item = scanner.nextLine();
                String itemLower = toLowerCase(item);
                System.out.println("\t Найдено:");
                for (int i = 0; i < purchaseList.size(); i++) {
                    String purchaseLower = toLowerCase(purchaseList.get(i));
                    if (purchaseLower.contains(itemLower)) {
                        System.out.println((i + 1) + ". " + purchaseList.get(i));
                    }
                }
            }
            System.out.println();
        }
    }
}