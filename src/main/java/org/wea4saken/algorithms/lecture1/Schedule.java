// НЕ РАБОТАЕТ
package org.wea4saken.algorithms.lecture1;

import java.util.*;

public class Schedule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int year = scanner.nextInt();
        List<String[]> weekends = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            weekends.add(scanner.nextLine().split(" "));
        }
        weekends.remove(0); // костыль из-за того как работает Scanner в Java

        String firstDayOfYear = scanner.next();

        Map<String, List<Integer>> yearDays = daysOfYear(firstDayOfYear, year);

        for (String[] weekend : weekends) {
            for (String day : yearDays.keySet()) {
                int dayOfYear = dayOfYear(year, weekend[1], Integer.parseInt(weekend[0]));
                if (yearDays.get(day).contains(dayOfYear)) {
                    yearDays.get(day).remove(Integer.valueOf(dayOfYear));
                }
            }
        }

        Map<Integer, List<String>> countJob = new HashMap<>();
        for (String day : yearDays.keySet()) {
            int dayListSize = yearDays.get(day).size();
            if (countJob.containsKey(dayListSize)) {
                countJob.get(dayListSize).add(day);
            } else {
                List<String> dayList = new ArrayList<>();
                dayList.add(day);
                countJob.put(dayListSize, dayList);
            }
        }

        int maxJobCount = Collections.max(countJob.keySet());
        int minJobCount = Collections.min(countJob.keySet());

        System.out.println(countJob.get(minJobCount).get(0) + " " + countJob.get(maxJobCount).get(0));
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static Map<String, List<Integer>> daysOfYear(String firstDayOfWeek, int year) {
        String[] daysOfWeek = new String[7];
        daysOfWeek[0] = "Monday";
        daysOfWeek[1] = "Tuesday";
        daysOfWeek[2] = "Wednesday";
        daysOfWeek[3] = "Thursday";
        daysOfWeek[4] = "Friday";
        daysOfWeek[5] = "Saturday";
        daysOfWeek[6] = "Sunday";

        Map<String, List<Integer>> daysInYear = new HashMap<>();

        for (String day : daysOfWeek) {
            daysInYear.put(day, new ArrayList<>());
        }

        int currentDay = Arrays.asList(daysOfWeek).indexOf(firstDayOfWeek);

        for (int day = 1; day <= (isLeapYear(year) ? 366 : 365); day++) {
            daysInYear.get(daysOfWeek[currentDay]).add(day);
            currentDay = (currentDay + 1) % 7;
        }

        return daysInYear;
    }

    public static int dayOfYear(int year, String monthName, int day) {
        Map<String, Integer> daysInMonth = new HashMap<>();
        daysInMonth.put("January", 31);
        daysInMonth.put("February", isLeapYear(year) ? 29 : 28);
        daysInMonth.put("March", 31);
        daysInMonth.put("April", 30);
        daysInMonth.put("May", 31);
        daysInMonth.put("June", 30);
        daysInMonth.put("July", 31);
        daysInMonth.put("August", 31);
        daysInMonth.put("September", 30);
        daysInMonth.put("October", 31);
        daysInMonth.put("November", 30);
        daysInMonth.put("December", 31);

        int dayCount = day;

        for (String month : daysInMonth.keySet()) {
            if (!month.equals(monthName)) {
                dayCount += daysInMonth.get(month);
            } else {
                break;
            }
        }

        return dayCount;
    }
}