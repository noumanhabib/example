
public class RandomGuess extends Thread {
	static Thread th;
	public static void main(String[] args) {
        System.out.println("This is main thread");
		th = new Thread(new RandomGuess());
        th.start();
        //Hello world
        System.out.println("This is new branch thread");

	}
	
	 @Override
    public void run(){
        System.out.println("This is peer thread");
    }
	
}
