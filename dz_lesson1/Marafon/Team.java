package dz_lesson1.Marafon;


/**
 * 2. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников
 * (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о
 * членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
 */

public class Team {

    private String teamName;
    private Competitor[] competitors;

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults() {
        System.out.printf("%s info:\n", teamName);
        for (Competitor competitor : competitors) {
            competitor.result();
        }
    }

    public void info() {
        System.out.printf("%s positive info:\n", teamName);
        for (Competitor competitor : competitors) {
            if (competitor.isOnDistance()) competitor.result();
        }
    }
}
