import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void print (ArrayList<String> purchaseList) {
        System.out.println("Ваш список покупок:");
        for (int i = 0; i < purchaseList.size(); i++) {
            System.out.println("\t" + (i +1) + ". " + purchaseList.get(i));
        }
    }
    public static void main(String[] args) {
        System.out.println("Программа подготовки списка продуктов");
        ArrayList<String> purchaseList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Вам доступны операции:");
            System.out.println("\t 1 - Добавить. 2 - Показать покупки. 3 - Удалить. end - Завершить.");
            String line = scanner.nextLine();
            if ("end".equals(line)) {
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
                print(purchaseList);
            }
            if (operationNum == 3) {
                print(purchaseList);
                System.out.println("Какую хотите удалить? Введите номер или название покупки.");
                String purchase = scanner.nextLine();

                if (purchaseList.remove(purchase)) {
                    System.out.println("Покупка " + purchase + " удалена.");
                    print(purchaseList);
                    continue; // added
                }
                else {
                    int purchaseNum = Integer.parseInt(purchase);
                    if ((purchaseNum > 0) & (purchaseNum <= purchaseList.size())) {
                        purchaseList.remove(purchaseNum - 1);
                        System.out.println("Покупка с номером " + purchaseNum + " удалена.");
                        print(purchaseList);
                        continue;
                    }
                    else {
                        System.out.println("Покупка c номером " + purchaseNum + " отсутствует.");
                        continue;
                    }
                }
                //System.out.println("Покупка c наименованием " + purchase + " отсутствует.");
            }
            System.out.println();
        }
    }
}