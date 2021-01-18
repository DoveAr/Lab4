public class Fight implements DamageCount, FightOutput{

    public boolean status;  /**Статус драки(true = происходит в данный момент)*/
    Fight.Attack currentattack = Fight.Attack.REST;     /**Устанавоиваем текущую атаку как "Отдых"*/

    Fight(AgressiveBoy ally, AgressiveBoy foe, boolean status){
        this.status = status;

        double hp1, hp2;            /**hp1 - Жизни первого мальчика, hp2 - Жизни второго мальчика*/
        hp1 = ally.age * 10;        /**hp - возраст умноженный на 10*/
        hp2 = foe.age * 10;

        System.out.println("\nДа начнется битва!\n");
        do{
            currentattack = getcurrentattack(getrandomnumber());            /** Текущая атака выбирается случайно вызовом метода
                                                                               getcurrentattack с помощью рандомайзера getrandomnumber */
            DamageCount damage;
            damage = (attack, power) -> attack * power / 10;
            hp1 = hp1 - damage.damagecount(getcurrentattack(getrandomnumber()).power, ally.power);        /**Просчитываем изменение хп первого мальчика*/

              /** damagecount получает мощь текущей атаки, которую выбирает рандомно с помощью
               метода getcurrentatack, который в свою очередь получает рандомное число
               из метода getrandomnumber, и силу атакующего*/

            fightoutput(foe, ally, currentattack);  /**Выводим атаку второго мальчика*/

            currentattack = getcurrentattack(getrandomnumber());            /**Получаем вторую атаку для атаки другого мальчика*/
            hp2 = hp2 - damagecount(getcurrentattack(getrandomnumber()).power, ally.power);
            fightoutput(ally, foe, currentattack);  /**Выводим атаку первого мальчика*/

        }while(hp1 > 0 && hp2 > 0);     /**Драка происходит пока жизни одного из мальчиков не упадут до 0*/

        fightoutput(ally, foe, hp1, hp2);   /**Перегрузкой вызываем метод вывода исхода боя*/
    } 


    public void setstatus(boolean status){
        this.status = status;
    }

    public boolean getstatus(){
        return this.status;
    }

    public int getrandomnumber(){               /**Получаем рандомное число от 0 до 4*/
        return (int)(Math.random() * 5);
    }

    public Fight.Attack getcurrentattack (int one_to_five_var){         /**Получить рандомную атаку, на вход берется int от 0 до 4*/
        switch(one_to_five_var){
            case 0:
                return Attack.HAND_LEFT;    /**Вариация удара рукой слева*/
            case 1:
                return Attack.HAND_MIDDLE;  /**Вариация удара рукой по центру*/
            case 2:
                return Attack.HAND_RIGHT;   /**Вариация удара рукой справа*/
            case 3:
                return Attack.LEG_HEAD;     /**Вариация удара ногой в голову*/
            case 4:
                return Attack.LEG_SPIN;     /**Вариация удара ногой в голову с разворота*/
            default:
                return Attack.REST;         /**Отдых, пропуск атаки*/
        }
    }

    @Override
    public void fightoutput(AgressiveBoy ally, AgressiveBoy foe, Attack currentattack) {        /**Метод вывода последней атаки, получает соперников и эту атаку*/
        System.out.println(ally.getName() + " наносит противнику " + foe.getName() + " " + currentattack.power / 10 * ally.getPower() + " урона, используя прием: " + currentattack.name);
    }

    @Override
    public void fightoutput(AgressiveBoy ally, AgressiveBoy foe, double hp1, double hp2) {      /**Метод вывода исхода боя, получает соперников и их жизни*/
        if(hp1 < 0){
            if(hp2 < 0) {
                System.out.println(ally.getName() + "и" + foe.getName() + " устали, решив отдохнуть и вскоре продолжить\n Ничья!\n");
            }
            else{
                System.out.println(ally.getName() + " израненный и уставший, решил отдохнуть и вскоре продолжить\n" + foe.getName() + " победил!\n");
            }
        }
        else {
            System.out.println(foe.getName() + " израненный и уставший, решил отдохнуть и вскоре продолжить\n" + ally.getName() + " победил!\n");
        }
    }


    public enum Attack {
        HAND_LEFT("Хук слева", 20), /**Вариация удара рукой слева*/
        HAND_RIGHT("Хук справа", 30), /**Вариация удара рукой справа*/
        HAND_MIDDLE("Апперкот", 45), /**Вариация удара рукой по центру*/
        LEG_HEAD("Лоу кик в голову", 50), /**Вариация удара ногой в голову*/
        LEG_SPIN("Вертушка в голову", 100), /**Вариация удара ногой в голову с разворота*/
        REST("Отдых", 0); /**Отдых, пропуск атаки*/
        private String name;
        private int power;

        Attack(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    public double damagecount(int attackpower, int boypower) {
        return attackpower / 10 * boypower;
    }
}
