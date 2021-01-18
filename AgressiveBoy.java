public class AgressiveBoy extends People{
    int age;
    int power;

    AgressiveBoy(String name, int age, int power) {     /**Создание агрессивного мальчика,с Именем, Возрастом и Мощностью*/
        super(name);
        this.age = age;
        this.power = power;
        System.out.println("Создан агрессивный " + this.getName());
    }

    public int getAge(){ return this.age; }
    public int getPower() { return this.power; }

    @Override
    public String toString() {
        return "Имя мальчика: " + this.getName() + ", Возраст мальчика: " + this.age + ", Сила мальчика: " + this.power;
    }
}
