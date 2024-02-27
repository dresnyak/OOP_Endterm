import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.lang.Iterable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBWork a = new DBWork();
        int ans = 0;
        User currUser = new User();
        User currUser1 = new User();
        int n;
        while(true){
            System.out.println("Желаете ли вы добавить позицию в базу данных?\n1.Да\n2.Нет");
            int p = scanner.nextInt();
            if(p == 1){
                System.out.println("Наименование продукта:");
                String ItemName = scanner.next();
                System.out.println("Стоимость продукта:");
                int ItemCost = scanner.nextInt();
                Items currItem = new Items(ItemName, ItemCost);
                a.InsertItem(currItem);
            }
            else if(p == 2){
                break;
            }
            else{
                System.out.println("Неизвестная команда!");
            }
        }
        System.out.println("Укажите количество позиций в корзине у клиента:");
        n = scanner.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.println("Введите id продукта:");
            int b = scanner.nextInt();
            ans += a.GetCost(b);
        }
        System.out.println("Итого: " + ans);
        System.out.println("Есть ли у клиента бонусная карта?\n1.Да\n2.Нет");
        int c = scanner.nextInt();
        if(c == 1){
            System.out.println("Попросите его имя и номер для начисления бонусов за покупку:");
            System.out.println("Имя клиента:");
            String ClientName = scanner.next();
            System.out.println("Номер телефона клиента:");
            String ClientPhone = scanner.next();
            currUser1 = a.CurrUser(ClientName, ClientPhone);
            a.AddSum(currUser1, ans);
            System.out.println("Бонусы начислены!");
        }
        else{
            System.out.println("Желает ли клиент завести бонусную карту?\n1.Да\n2.Нет");
            c = scanner.nextInt();
            if(c == 1) {
                System.out.println("Имя клиента:");
                String ClientName = scanner.next();
                System.out.println("Номер телефона клиента:");
                String ClientPhone = scanner.next();
                User currUser2 = new User(ClientPhone, ClientName, (int) (ans * 0.1));
                a.InsertUser(currUser2);
                System.out.println("Клиент добавлен в систему, а бонусы за эту покупку начислены!");
            }
            System.out.println("До свидания!");
        }
    }
}