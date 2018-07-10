package dz_lesson1.Marafon;

public class Main {

 public static void main(String[] args) {

     Course course1 = new Course(new Cross(300), new Wall(2), new Water(5));

     Team team1 = new Team("Team 1", new Human("Макс"), new Cat("Васька"), new Dog("Шарик"), new Dog("Бобик"));

     Team team2 = new Team("Team 2", new Human("Стив"), new Cat("Мурзик"), new Dog("Том"), new Dog("Плюшка"));


            course1.doIt(team1);
            course1.doIt(team2);

            System.out.println("\n===== РЕЗУЛЬТАТ: =====\n");
            team1.showResults();
            System.out.println();
            team2.showResults();
        }
}
