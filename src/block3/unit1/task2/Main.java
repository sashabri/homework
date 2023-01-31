package block3.unit1.task2;

public class Main {
    public static void main(String[] args) {
        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener erListener = System.out::println;

        Worker worker = new Worker(listener,erListener);
        worker.start();
    }
}
