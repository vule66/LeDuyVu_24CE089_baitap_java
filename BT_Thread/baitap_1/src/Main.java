public class Main {
    public static void main(String[] args) {
    threadChan soChan = new threadChan();
    threadLe soLe= new threadLe();
    soLe.start();
    soChan.start();
    }
}