package dz_lesson1.Marafon;


/**
 * 3. Добавить класс Course (полоса препятствий), в котором будут находиться:
 * массив препятствий, метод который будет просить команду пройти всю полосу;
 */

public class Course {

    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}


