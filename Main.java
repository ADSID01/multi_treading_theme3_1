public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        Thread user = new Thread(null, box::check, "Пользователь");
        Thread toy = new Thread(null, box::unCheck, "Игрушка");
        toy.setDaemon(true);
        user.start();
        toy.start();
    }
}
