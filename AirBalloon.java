import java.util.Objects;

public abstract class AirBalloon {
    private String name;
    int length;
    int width;
    int height;


    AirBalloon(String name, int length, int width, int height) {        /**Создание части воздушного шара*/
        this.width = width;
        this.length = length;
        this.height = height;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getWidth(){
        return this.width;
    }

    public int getLength(){
        return this.length;
    }

    public int getHeight(){
        return this.height;
    }

    public boolean equals(Object obj) {                 /**Проверка на равенство объектов*/
        if (this == obj) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            AirBalloon thing = (AirBalloon) obj;
            return Objects.equals(this.name, thing.name);
        } else {
            return false;
        }
    }

    public abstract String toString();

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }
}
