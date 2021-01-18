import java.util.Objects;

public abstract class People {
    private String name;

    People(String name) {
        this.name = name;
    }       /**Создание человека*/

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {     /**Проверка на равенство объектов*/
        if (this == obj) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            People man = (People)obj;
            return Objects.equals(this.name, man.name);
        } else {
            return false;
        }
    }

    public abstract String toString();

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }
}
