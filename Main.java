public class Main {
    public static void main(String[] args) {
        Znayka znayka = new Znayka("Знайка", 14, "Боевой вертолет МИ-8", "Площадь");
        System.out.println(znayka.toString());
        Crowd crowd = new Crowd("Зеваки", 7);
        crowd.argue();
        AgressiveBoy boy1 = new AgressiveBoy("Руфик", 7, 5);
        AgressiveBoy boy2 = new AgressiveBoy("Алик", 35, 1);
        System.out.println(boy1.toString());
        System.out.println(boy2.toString());
        Fight fight = new Fight(boy1, boy2, true);
        znayka.moveto("Драка");
        znayka.moveto("Драка");
        znayka.stopfight(fight);
        Balloon ball = new Balloon("Шарик", 20, 15, 10, true);
        Bucket bucket = new Bucket("Корзинка", 10, 10, 10);
        znayka.moveto("Шар");
        znayka.untie(ball);

        ball.airPush(10);
    }
}
