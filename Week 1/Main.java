public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Loading...");

        // Simulate a loading effect
        for (int i = 0; i <= 100; i += 10) {
            Thread.sleep(500); // Pause for half a second
            System.out.print("Loading... " + i + "%");
        }

        System.out.println("\nDone!");
    }
}
