public class Balloon extends AirBalloon implements AirLoss{
    public boolean status;  /** Статус завязки шара (true = шар завязан, воздух не выходит)*/

    Balloon(String name, int length, int width, int height, boolean status) {        /** Создание воздушного шара с Именем, Размерами*/
        super(name, length, width, height);
        this.status = status;
        System.out.println("\nСоздан воздушный шар '" + this.getName() + "'");
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void airloss() throws BalloonCannotLoseAirException {          /**Метод постепенной потери шаром воздуха*/
        if(this.status){        /**Если шар завязан*/
            throw new BalloonCannotLoseAirException(this.getName() + " завязан, воздух не выходит");
        }
        else{
            double v;
            v = this.height * this.length * this.width;             /**Вычисление объема шара*/

            if(v==0) throw new BalloonCannotLoseAirException(this.getName() + " уже сдулся!");      /**Исключение если шарик уже сдулся*/

            System.out.println(this.getName() + " развязан, воздух выходит") ;
            System.out.println("Объем равен: " + (int)v);
            while(v>0){

                this.height = (int) (this.height * 0.9 - 1);
                this.width = (int) (this.width * 0.9 - 1);
                this.length = (int) (this.length * 0.9 - 1);

                v = this.height * this.length * this.width;           /**Уменьшение объема*/

                System.out.println("Объем равен: " + (int)(v));
            }
            System.out.println("Весь воздух вышел");
        }
    }

    public void airPush(int pushes){
        System.out.println("Знайка приказал качать насос " + pushes + " раз");
        this.height = (int)Math.pow((double)(Pot.temperatureRise(pushes)*10), 0.33);
        this.width = this.height;
        this.length = this.height;
    }

    @Override
    public String toString() {
        return "Воздушный шар '" + this.getName() + "' , его размеры: " + this.getHeight() + " x " + this.getWidth() + " x " + this.getLength();
    }

    static class Pot{
        private static int temperature = 0;

        static int temperatureRise(int time){
            for(int i=0; i<time; i++){
                temperature+=50;
                System.out.println("Текущая температура котла: " + temperature);
            }
            return temperature;
        }
    }

}
