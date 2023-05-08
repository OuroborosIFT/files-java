package model;

public class User {

        private final int id;
        private String name;
        private String lastname;
        private int age;
        private boolean isJob;

        public User(int id, String name, String lastname, int age, boolean isJob) {
            this.id = id;
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.isJob = isJob;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isJob() {
            return isJob;
        }

        public void setJob(boolean job) {
            isJob = job;
        }

        public String writeToFile() {
            return id + "|" + name + "|" + lastname + "|" + age + "|" + isJob;
        }

        @Override
        public String toString() {
            String job = isJob ? " имеет работу " : " безработный ";

            if (age % 10 == 1) {
                return name + " " + lastname + " " + age + " год " + job;
            } else if (age % 10 == 2 || age % 10 == 3 || age % 10 == 4) {
                return name + " " + lastname + " " + age + " года " + job;
            }

            return name + " " + lastname + " " + age + " лет " + job;
        }

}
