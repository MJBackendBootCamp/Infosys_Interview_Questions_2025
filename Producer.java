package codes;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	
	private BlockingQueue<Integer> queue;
	
	private int limit;
	
	public Producer(BlockingQueue<Integer> queue , int limit)
	{
		this.queue = queue;
		this.limit = limit;
	}
	
	@Override
	public void run()
	{
		try {
			for(int i=0 ; i<limit ; i++)
			{
				System.out.println("Produced : " + i);
				queue.put(i);
				Thread.sleep(300);
				
			}
			queue.put(-1);
		}
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

}
