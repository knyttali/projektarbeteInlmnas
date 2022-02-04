package sti.aaj.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.aaj.domain.Student;
import sti.aaj.domain.Teacher;

import java.util.Scanner;
public class Main {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:sti-aaj-service.xml");;
    private static StiService stiService = (StiService) applicationContext.getBean("service");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        hardCoded();
        menu(scan);
    }

    private static void menu(Scanner scan) { // TODO: ta bort loop bugg när input är blank.
        while (true) {
            System.out.println("------MENY-----");
            System.out.println("1. Hämta student. ");
            System.out.println("2. Lägg till student. ");
            System.out.println("3. Stäng programmet. ");

            if (scan.hasNextInt()) {
                int input = scan.nextInt();
                if (input == 1) {
                    menuGetStudent(scan, 1);
                } else if (input == 2) {
                    createStudent(scan);
                } else if (input == 3) {
                    break;
                } else {
                System.out.println("Vänligen skriv en av siffrorna 1,2 eller 3.\n");
                }
            }else{
                scan.nextLine();
                System.out.println("\nVänligen skriv en av siffrorna 1,2 eller 3.\n");

            }
        }
    }


    private static void hardCoded() {
        stiService.createCourse("Tyska", 10, new Teacher("Özgur", "Kibar", 567890, 10), 2020, 50);
        stiService.createCourse("Svenska", 10, new Teacher("Özgur", "Kibar", 567890, 10), 3030, 40);
        stiService.createCourse("Engelska", 15, new Teacher("Özgur", "Kibar", 567890, 10), 1010, 55);

        stiService.createStudent(1234, "Amanda", "Andrae", 1010);
        stiService.createStudent(2345, "Jonas", "Wadin", 2020);
        stiService.createStudent(3456, "Anna", "Karlsson", 3030);
    }

    public static void menuGetStudent(Scanner scan, int menuGetStudent){
        System.out.println("Skriv ID nummer: ");
        if(scan.hasNextInt()){
            int id = scan.nextInt();
            try{
                getStudent(id, scan);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }else {
            scan.nextLine();
            System.out.println("\nVänligen skriv en av siffrorna 1,2 eller 3.\n");
        }
    }
    private static void getStudent(int id, Scanner scan) {
        Student student = stiService.getStudent(id);
        while(true) {
            System.out.println(student);
            System.out.println("1. Lägg till kurs.   ");
            System.out.println("2. Ta bort kurs. ");
            System.out.println("3. Tillbaka till meny. \n");
            if(scan.hasNextInt()){
                int input = scan.nextInt();
                if (input == 1) {
                    System.out.println("Lägg till kurs ID(1010, 2020 eller 3030): ");
                    int courseId = scan.nextInt();
                    stiService.setCourse(student, courseId, input);
                } else if (input == 2) {
                    System.out.println("Ta bort kurs ID(1010, 2020 eller 3030): ");
                    int courseId = scan.nextInt();
                    stiService.setCourse(student, courseId, input);
                } else if (input == 3) {
                    break;
                } else {
                    System.out.println("Vänligen skriv en av siffrorna 1,2 eller 3.\n");
                }
            } else {
                scan.nextLine();
                System.out.println("not a number.");
            }
        }
    }
    private static void createStudent(Scanner scan) {
        System.out.println("Skriv ett ID nummer: ");
        int id = scan.nextInt();

        System.out.println("Skriv förnamn: ");
        String name = scan.next();

        System.out.println("Skriv efternamn: ");
        String surname = scan.next();

        System.out.println("Skriv kurs ID(1010, 2020 eller 3030): ");
        int courseId = scan.nextInt();

        stiService.createStudent(id, name, surname, courseId);

        System.out.println(stiService.getStudent(id));
    }
}

