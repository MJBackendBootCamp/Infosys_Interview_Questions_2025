package codes;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	
private BlockingQueue<Integer> queue;
	
	
	public Consumer(BlockingQueue<Integer> queue )
	{
		this.queue = queue;
	}
	
	@Override
	public void run()
	{
		try {
			while(true)
			{
				Integer value = queue.take();
				
				if(value == -1)
				{
					System.out.println("Consumer Stopping.....");
					break;
				}
				System.out.println("Consumed : " + value);
				Thread.sleep(500);
				
			}
		}
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

}
