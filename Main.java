import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToysShop<Toys> list = new ToysShop<>();
        Scanner intscan = new Scanner(System.in);
        Scanner textscan = new Scanner(System.in);
        
        System.out.print("Введите кол-во разновидностей игрушек: ");
        int countObj = intscan.nextInt();

        for (int i = 0; i < countObj; i++) {
            System.out.print("Введите название: ");
            String name = textscan.nextLine();
    
            System.out.print("Введите кол-во таких игрушек: ");
            int quantity = intscan.nextInt();
    
            System.out.print("Введите шанс выпадения игрушки: ");
            int chance = intscan.nextInt();

            list.addСategories(new Toys(name, quantity, chance));

            System.out.println("\n");
        }

        System.out.println("Попробуем?(more) Или вы сдаетесь, даже не начав?(end)");
        String answer = textscan.nextLine();

        while (true) {
            if (answer.equals("more")) {
                Collections.shuffle(list.getList());

                list.randomSelection(list);
                System.out.println("Ваш результат в файле");

            } else if(answer.equals("end")) {
                System.out.println("Очень жаль... Но мы всегда ждем вашего возвращения!");
                break;
            }

            System.out.println("Может еще разок?(more) Или вы выустали?(end)");
            answer = textscan.nextLine();
        }
    }
}
