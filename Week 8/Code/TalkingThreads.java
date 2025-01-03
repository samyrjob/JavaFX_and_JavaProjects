
//runnable is a particular interface for working with threads
// we need it if a class is going to create and manipulate threads
class TalkingThreads implements Runnable 
{
   // this is the usual main method that we've seen before
   // it has been equipped to throw an Interrupted Exception
   // it is usually a requirement to deal with this exception
   // when manipulating threads 
   public static void main(String args[]) throws InterruptedException {
		
		// create a new Thread object
		// we create an on-the-fly instance of the thread 
		// using the 'main' thread itself
		Thread myThread = new Thread(new TalkingThreads());
		// normal program output - the default 'main' thread
		System.out.println("Hello from the main thread!");

        Thread.sleep(3000);
        System.out.println("I am the main thread again !");
		// start running myThread
		myThread.start();
    }
		
	// the run method is the default action to be executed 
	// when a thread starts
	public void run() {
	   System.out.println("Hello, I'm part of another thread!");
       System.out.println("It’s nice to be a new thread in the world");
   }
}
