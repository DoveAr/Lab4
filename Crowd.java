public class Crowd extends People implements Argue{
    int count;          /**Колличество людей толпы*/

    Crowd(String name, int count){      /**Создание толпы с Именем и Колличеством*/
        super(name);
        this.count = count;
        System.out.println("Появилась толпа '" + this.getName() + "'");
    }


    @Override
    public String toString() {
        return "Название толпы: " + this.getName() + ", колличество людей: " + this.count;
    }

    public void argue() {       /**Метод по вычислению спора толпы*/
        int count = this.count;
        for(int i=0; i<count; i++){
            if(i%2==0){
                System.out.println("Кто-то из толпы кричит что шар полетит");
            }
            else {
                System.out.println("Кто-то из толпы кричит что шар не полетит");
            }
        }
        if(count%2==0){     /**Выведение решения спора*/
            System.out.println("Коротышки так и не решили, полетит ли шар");
        }
        else{
            System.out.println("Коротышки сошлись во мнении что шар полетит");
        }
    }
}
