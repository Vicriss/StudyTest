package phoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vicriss on 2015/09/23.
 */
public class Manager {
   private Service service = new Service();
   private Scanner in = new Scanner(System.in);
   private String name;
   private int num;
   private List<Person> personList = null;

   public Manager(){
      personList = service.listSort(new Example().personExample());

   }

   public void scanList(){
      System.out.println(personList);
   }

   public void findByName(){
      System.out.println("������������");
      String name = in.nextLine();
      Person person = service.findByName(name);
      if(person!=null) {
         System.out.println(person);
      }
      else {
         System.out.println("����ϵ�˲����ڣ��Ƿ�Ҫ����µ���ϵ�ˣ� Y/N");
         if (in.next().equals("Y"))
            addPerson();
      }
   }

   public void addPerson(){
      Person person1 = new Person();
      String name = in.nextLine();

      System.out.println("������������");
      while (service.findByName(name)!=null){
         System.out.println("��ϵ���Ѵ��ڣ�!");
         name = in.nextLine();
      }
      person1.setName(name);

      System.out.println("������绰��\n������0������");
      List<Integer> nums = new ArrayList<>();
      num = in.nextInt();
      while (num!=0)
         nums.add(num);
      person1.setNumbers(nums);

      System.out.println("�������ַ��");
      person1.setAddress(in.nextLine());

      service.addPerson(person1);
      System.out.println("done!");
   }

   public void deletePerson(){
      System.out.println("������������");
      name = in.nextLine();
      service.deleteByName(name);
      System.out.println("done!");
   }

   public void findByNumber(){
      System.out.println("������绰��");
      num = in.nextInt();
      Person person = service.findByNumber(num);
      if(person==null){
         System.out.println("�ú��벻���ڣ��Ƿ�Ҫ��ӣ�Y/N");
         if(in.next().equals("Y"))
            addNumber();
      }else
         System.out.println(person);
   }

   public void addNumber(){

      System.out.println("��ӵ���ϵ�ˣ�");
      name = in.nextLine();

      System.out.println("������绰��");
      num = in.nextInt();

      while (service.findByNumber(num)==service.findByName(name)){
         System.out.println("�����Ѵ��ڣ�");
         num = in.nextInt();
      }


      service.addNumber(num,name);
      System.out.println("done!");
   }

   public void deleteNumber(){
      System.out.println("������绰��");
      num = in.nextInt();
      service.deleteNumber(num);
   }

}
