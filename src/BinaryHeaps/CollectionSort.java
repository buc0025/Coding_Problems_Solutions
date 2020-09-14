package BinaryHeaps;
/*
https://www.hackerrank.com/challenges/java-sort/problem
You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their
CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in
alphabetical order. If those two students also have the same first name, then order them according to their ID. No two
students have the same ID.
 */

public class CollectionSort {

    class SortName implements Comparator<Student> {

        public int compare(Student a, Student b) {

            if (a.getCgpa() == b.getCgpa()) {
                if (a.getFname().compareTo(b.getFname()) < 0) {
                    return -1;
                } else {
                    return 1;
                }
            }

            if (a.getCgpa() > b.getCgpa()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
