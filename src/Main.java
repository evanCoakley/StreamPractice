
import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);   //
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        //Print out tuesday entries
        System.out.println("For TUES Loop:");
        // write for loop
        for(Entry entry : entries){
            if(entry.getDay().equals(Day.TUESDAY)) {
                System.out.println(entry);
            }
        }
        System.out.println("\nTUES Stream, filter, forEach:");
        List<Entry> tueEntry = entries.stream()
                .filter(entry -> entry.getDay() == Day.TUESDAY)
                .collect(Collectors.toList());
        // write stream
        System.out.println(tueEntry);
    }

    public static void countTueWedThur(List<Entry> entries) {
        //Count the number of Tuesday, Wednesday, and Thursday entries
        System.out.println("For Loop:");
        int count = 0;
        // write for loop
        for(Entry entry : entries){
            if(entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY) {
                count++;
            }
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        long count1 = entries.stream()
                .filter(entry -> entry.getDay() == Day.TUESDAY || entry.getDay() == Day.WEDNESDAY || entry.getDay() == Day.THURSDAY)
                .count();


        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        //Create a list of weekend (Saturday and Sunday) entries
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        for(Entry entry : entries) {
            if(entry.getDay() == Day.SATURDAY || entry.getDay() == Day.SUNDAY){
                weekends.add(entry);
            }
        }

        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream()
                .filter(entry -> entry.getDay().equals(Day.SATURDAY) || entry.getDay().equals(Day.SUNDAY))
                .collect(Collectors.toList());
                System.out.println(weekends);
        System.out.println();
    }

    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("weekdaySet: For Loop:");
        Set<String> weekdays = new HashSet<>();
        for(Entry entry : entries){
            if (!entry.getDay().equals(Day.SUNDAY) && !entry.getDay().equals(Day.SATURDAY)) {
                weekdays.add(entry.toString());
            }

        }
        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries.stream()
                .filter(entry ->
                        (!entry.getDay().equals(Day.SATURDAY) && !entry.getDay().equals(Day.SUNDAY))
                )
                .map(entry -> entry.toString())
                .collect(Collectors.toSet());
//                .
        System.out.println(weekdays);
        System.out.println();
    }
}

/*
.filter(entry -> entry.getDay().equals(Day.TUESDAY) || entry.getDay().equals(Day.FRIDAY) ||
                entry.getDay().equals(Day.MONDAY) || entry.getDay().equals(Day.THURSDAY) || entry.getDay().equals(Day.WEDNESDAY))
 */