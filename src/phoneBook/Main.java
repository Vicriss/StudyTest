package phoneBook;

import java.util.Scanner;

/**
 * Created by vicriss on 2015/09/13.
 */
public class Main {

    public static void main(String args[]) {

        Service service = new Service();
        Manager manager = new Manager();

        System.out.println("====��ӭ====");
        System.out.println("1.�����ϵ��");
        System.out.println("2.������ϵ��");
        System.out.println("3.�����ϵ��");
        System.out.println("4.ɾ����ϵ��");
        System.out.println("5.���Һ���");
        System.out.println("6.��Ӻ���");
        System.out.println("7.ɾ������");
        System.out.println("0.�˳�");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        while (input != 0) {
            switch (input) {

                case 1://�����ϵ��
                    manager.scanList();
                    break;

                case 2://������ϵ��
                    manager.findByName();
                    break;
                case 3://�����ϵ��
                    manager.addPerson();
                    break;

                case 4://ɾ����ϵ��
                    manager.deletePerson();
                    break;

                case 5://���Һ���
                    manager.findByNumber();
                    break;

                case 6://��Ӻ���
                    manager.addNumber();
                    break;

                case 7://ɾ������
                    manager.deleteNumber();
                    break;

            }
            input = in.nextInt();
        }
        System.out.println("Bye~");
    }
}
