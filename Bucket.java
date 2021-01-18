public class Bucket extends AirBalloon{

    Bucket(String name, int length, int width, int height) {        /**Создание корзины для шара*/
        super(name, length, width, height);
        System.out.println("Создана корзина для воздушного шара '" + this.getName() + "'");
    }

    @Override
    public String toString() {
        return "Корзина '" + this.getName() + "' , ее размеры: " + this.getHeight() + " x " + this.getWidth() + " x " + this.getLength();
    }


}
