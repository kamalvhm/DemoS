package com.take;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;



class BirthdayReminder {
    private Person root;

    public BirthdayReminder(Person root) {
        this.root = root;
    }

    public Person alarmNextBirthday() {
        LocalDate today = LocalDate.now();
        return findNextBirthday(root, today);
    }

    private Person findNextBirthday(Person root, LocalDate today) {
        PriorityQueue<Person> minHeap = new PriorityQueue<>(Comparator.comparing(p -> getNextBirthdayDate(p.birthday, today)));
        java.util.Queue<Person> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            minHeap.offer(current);
            for (Person ancestor : current.ancestors) {
                queue.offer(ancestor);
            }
        }

        return minHeap.poll();
    }

    public LocalDate getNextBirthdayDate(MonthDay birthday, LocalDate today) {
        LocalDate thisYearBirthday = birthday.atYear(today.getYear());
        if (thisYearBirthday.isBefore(today) || thisYearBirthday.isEqual(today)) {
            // birthday has passed this year, so return next year's birthday
            return birthday.atYear(today.getYear() + 1);
        } else {
            return thisYearBirthday;
        }
    }
}