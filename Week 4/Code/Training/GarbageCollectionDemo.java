package Training;

class GarbageCollectionDemo {
    // This is a simple class with a constructor and a finalize method
    private int id;

    GarbageCollectionDemo(int id) {
        this.id = id;
        System.out.println("Object " + id + " created");
    }

    // This method is called just before the object is garbage collected
    protected void finalize() {
        System.out.println("Object " + id + " is being garbage collected");
    }

    public static void main(String[] args) {
        // Create two objects
        GarbageCollectionDemo obj1 = new GarbageCollectionDemo(1);
        GarbageCollectionDemo obj2 = new GarbageCollectionDemo(2);

        // Make obj1 and obj2 eligible for garbage collection by setting them to null
        obj1 = null;
        obj2 = null;

        // Suggest garbage collection (it may or may not happen immediately)
        System.gc();

        // Wait a little to see the garbage collection messages
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of program");
    }
}
