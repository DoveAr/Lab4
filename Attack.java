public enum Attack {
    HAND_LEFT("Хук слева", 20), /**Вариация удара рукой слева*/
    HAND_RIGHT("Хук справа", 30), /**Вариация удара рукой справа*/
    HAND_MIDDLE("Апперкот", 45), /**Вариация удара рукой по центру*/
    LEG_HEAD("Лоу кик в голову", 50), /**Вариация удара ногой в голову*/
    LEG_SPIN("Вертушка в голову", 100), /**Вариация удара ногой в голову с разворота*/
    REST("Отдых", 0);   /**Отдых, пропуск атаки*/

    private String name;
    private int power;

    private Attack(String name, int power) {
        this.name = name;
        this.power = power;
    }
}
