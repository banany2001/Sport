package by.bsu.fpmi.siachko.lab1.demo;

import by.bsu.fpmi.siachko.lab1.reading.*;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;

import javax.xml.bind.JAXBException;
import java.util.*;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) throws JAXBException, Exception {

        new LogFile();

        EventsList<SportEvent> list = new EventsList<>();

        while (true){
            System.out.println("Select the operation:");
            System.out.println("1 - read the file");
            System.out.println("2 - sort by age group");
            System.out.println("3 - find average attendance by days");
            System.out.println("4 - write to the file");
            System.out.println("5 - Stop the program");

            Scanner in = new Scanner(System.in);
            int op = in.nextInt();

            if (op == 1){
                System.out.println("Enter the path to the file.");
                in = new Scanner(System.in);
                String path = in.nextLine();
                Dao<SportEvent> inputDao = null;
                if (Pattern.matches("[-/_:\\\\\\w]+.xml", path)){
                    inputDao = XMLDao.create(path, SportEvent.class, Demo.class);
                }
                else if (Pattern.matches("[-/_:\\\\\\w]+.json", path)){
                    inputDao = JsonDao.create(path, Demo.class);
                }
                else if (Pattern.matches("[-/_:\\\\\\w]+.csv", path)){
                    inputDao = CsvDao.create(path, Demo.class);
                }
                else {
                    System.out.println("Filename is incorrect or this type of file is not supported");
                    continue;
                }
                try
                {
                    list.setList(inputDao.read());
                }
                catch (Exception ex)
                {
                    System.out.println("Error while reading a file: incorrect filename" +
                            " or incorrect data in the file");
                }

            }
            else if (op == 2){
                if (list.getList() == null){
                    System.out.println("Incorrect operation: no list to sort.");
                    continue;
                }
                System.out.println("Enter the age that belongs to the age group you want to search by");
                int age;
                in = new Scanner(System.in);
                age = in.nextInt();
                List<SportEvent> temp_list = list.getList();
                if (age < 18){
                    Collections.sort(temp_list, new Comparator<SportEvent>() {
                        @Override
                        public int compare(SportEvent o1, SportEvent o2) {
                            return Integer.compare(o1.getAttendance().getPeopleUntil18(), o2.getAttendance().getPeopleUntil18());
                        }
                    });
                }
                else if (age < 30){
                    Collections.sort(temp_list, new Comparator<SportEvent>() {
                        @Override
                        public int compare(SportEvent o1, SportEvent o2) {
                            return Integer.compare(o1.getAttendance().getPeopleUntil30(), o2.getAttendance().getPeopleUntil30());
                        }
                    });
                }
                else if (age < 45){
                    Collections.sort(temp_list, new Comparator<SportEvent>() {
                        @Override
                        public int compare(SportEvent o1, SportEvent o2) {
                            return Integer.compare(o1.getAttendance().getPeopleUntil45(), o2.getAttendance().getPeopleUntil45());
                        }
                    });
                }
                else if (age < 60){
                    Collections.sort(temp_list, new Comparator<SportEvent>() {
                        @Override
                        public int compare(SportEvent o1, SportEvent o2) {
                            return Integer.compare(o1.getAttendance().getPeopleUntil60(), o2.getAttendance().getPeopleUntil60());
                        }
                    });
                }
                else {
                    Collections.sort(temp_list, new Comparator<SportEvent>() {
                        @Override
                        public int compare(SportEvent o1, SportEvent o2) {
                            return Integer.compare(o1.getAttendance().getPeopleAfter60(), o2.getAttendance().getPeopleAfter60());
                        }
                    });
                }
                System.out.println("Events:");
                for (SportEvent event : temp_list){
                    System.out.println(event);
                }
            }
            else if (op == 3){
                if (list.getList() == null){
                    System.out.println("Incorrect operation: no source list.");
                    continue;
                }
                int[] sum = new int[8];
                int[] cnt = new int[8];
                List<SportEvent> temp_list = list.getList();
                for (SportEvent event : temp_list){
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("monday")){
                        sum[1] += event.getAttendance().getTotal();
                        cnt[1]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("tuesday")){
                        sum[2] += event.getAttendance().getTotal();
                        cnt[2]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("wednesday")){
                        sum[3] += event.getAttendance().getTotal();
                        cnt[3]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("thursday")){
                        sum[4] += event.getAttendance().getTotal();
                        cnt[4]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("friday")){
                        sum[5] += event.getAttendance().getTotal();
                        cnt[5]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("saturday")){
                        sum[6] += event.getAttendance().getTotal();
                        cnt[6]++;
                    }
                    if (event.getDate().getDayOfWeek().toLowerCase().equals("sunday")){
                        sum[7] += event.getAttendance().getTotal();
                        cnt[7]++;
                    }
                }
                System.out.println("Average attendance by days:");
                System.out.println("Monday - " + (sum[1] / Math.max(1, cnt[1])) + " people.");
                System.out.println("Tuesday - " + (sum[2] / Math.max(1, cnt[2])) + " people.");
                System.out.println("Wednesday - " + (sum[3] / Math.max(1, cnt[3])) + " people.");
                System.out.println("Thursday - " + (sum[4] / Math.max(1, cnt[4])) + " people.");
                System.out.println("Friday - " + (sum[5] / Math.max(1, cnt[5])) + " people.");
                System.out.println("Saturday - " + (sum[6] / Math.max(1, cnt[6])) + " people.");
                System.out.println("Sunday - " + (sum[7] / Math.max(1, cnt[7])) + " people.");
            }
            else if (op == 4){
                System.out.println("Enter the path to the file.");
                in = new Scanner(System.in);
                String path = in.nextLine();
                Dao<SportEvent> outputDao = null;
                if (Pattern.matches("[-/_:\\\\\\w]+.xml", path)){
                    outputDao = XMLDao.create(path, SportEvent.class, Demo.class);
                }
                else if (Pattern.matches("[-/_:\\\\\\w]+.json", path)){
                    outputDao = JsonDao.create(path, Demo.class);
                }
                else if (Pattern.matches("[-/_:\\\\\\w]+.csv", path)){
                    outputDao = CsvDao.create(path, Demo.class);
                }
                else {
                    System.out.println("Filename is incorrect or this type of file is not supported");
                    continue;
                }
                try
                {
                    outputDao.write(list.getList());
                }
                catch (Exception ex)
                {
                    System.out.println("Error while writing to the file: incorrect filename" +
                            " or incorrect data in the list");
                }
            }
            else if (op == 5){
                break;
            }
            else {
                System.out.println("Incorrect input: such operation doesn't exist.");
            }

        }

    }
}
