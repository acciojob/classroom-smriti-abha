package com.driver;
public class Student {
    private String name;
    private int age;
    private double averageScore;



    //package com.driver;




        public Student(String name, int age, double averageScore) {
            setName(name);
            setAge(age);
            setAverageScore(averageScore);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getAverageScore() {
            return averageScore;
        }

        public void setAverageScore(double averageScore) {
            this.averageScore = averageScore;
        }
    }
