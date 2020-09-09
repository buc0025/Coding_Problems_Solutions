package BinaryHeaps;
/*
https://www.hackerrank.com/challenges/java-priority-queue/problem
 */

public class PriorityQueue {

    class Student implements Comparable<Student>{
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student o) {
            if(this.getCgpa() == o.getCgpa()) {
                if(this.getName().equals(o.getName())) {
                    if(this.getId() == o.getId()) {
                        return 0;
                    } else if (this.getId() < o.getId()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                else {
                    return this.getName().compareTo(o.getName());
                }

            } else if (this.getCgpa() > o.getCgpa()) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }
    class Priorities {

        public List<Student> getStudents(List<String> events) {

            PriorityQueue<Student> pq = new PriorityQueue<Student>();

            List<Student> list = new ArrayList<>();

            for(String event : events){
                if (event.contains("ENTER")){
                    String str[] = event.split(" ");
                    pq.add(new Student(Integer.valueOf(str[3]), str[1], Double.valueOf(str[2])));
                }else if (event.contains("SERVED")){
                    pq.poll();
                }
            }

            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }

            return list;

        }
    }
}
