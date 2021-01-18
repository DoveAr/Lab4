import java.io.PrintStream;

public class Znayka extends People implements MoveTo {
    int age;
    String gender;
    String position;

    Znayka(String name, int age, String gender, String position) {  /**Создание объекта класса Знайка с любым именем, полом, возрастом и текущей позицией*/
        super(name);
        this.age = age;
        this.gender = gender;
        this.position = position;
        System.out.println("Создан персонаж " + this.getName());
    }

    public String getPosition() {
        return this.position;
    }

    public void moveto(String position) {           /**Метод перемещения, получает строку с позицией и проверяет не находился ли объект в этой позиции ранее*/
        if (position == this.getPosition()) {
            System.out.println(this.getName() + " уже был около: " + position);
        }
        else {
            this.position = position;
            System.out.println(this.getName() + " пришел к: " + this.getPosition());
        }
    }

    public void stopfight(Fight fight){                                      /**Метод попытки остановить драку двух мальчиков, получает на вход саму битву*/

        if(fight.getstatus()) {                                              /**Проверяет происходит ли в данный момент драка*/
            System.out.println(this.getName() + " пробует разнять драку");
            if (this.position == "Драка") {                                  /**Проверяет находится ли Знайка около битвы*/

                if (Math.random() > 0.75) {                                  /**Если Знайка находится около драки у него есть 25% шанс ее разнять*/
                    System.out.println(this.getName() + " разнял драку\nДрака прекращена");
                    fight.setstatus(false);
                } else {
                    System.out.println(this.getName() + " оказался слишком слаб\nПопытка провалилась");
                }
            } else {
                System.out.println(this.getName() + " находится не около драки\nПопытка провалилась");
            }
        }
        else{
            System.out.println("Драки не происходит, знайке ничего делать не надо");
        }
    }

    @Override
    public String toString() {
        return "Имя персонажа: " + this.getName() + ", Возраст персонажа: " + this.age + ", Пол персонажа: " + this.gender + ", Позиция персонажа: " + this.position;
    }


    public void untie(Balloon ball) {               /**Метод по развязыванию шара, на вход получает Шар который нужно развязать*/

        if(this.getPosition() == "Шар"){            /**Проверяет находится ли Знайка у Шара*/
            if(ball.getStatus()){                   /**Проверяет завязан ли шар*/
                ball.setStatus(false);
                System.out.println(this.getName() + " развязал " + ball.getName());
            }
            else{
                System.out.println(ball.getName() + " уже был развязан");
            }
            try{
                ball.airloss();
            }
            catch(BalloonCannotLoseAirException ex){
                System.out.println(ex);
            }
        }
        else{
            System.out.println(this.getName() + " находится не у Шара");
        }

    }


}
