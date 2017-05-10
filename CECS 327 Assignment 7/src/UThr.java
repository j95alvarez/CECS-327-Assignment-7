import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.*;

public class UThr implements Runnable {
	public int id;
	public ConcurrentLinkedQueue<Node> requestQue;
	public ConcurrentLinkedQueue<Node> resultQue;

	public UThr(int i, ConcurrentLinkedQueue<Node> request, ConcurrentLinkedQueue<Node> result){
		this.id = i;
		this.requestQue = request;
		this.resultQue = result;
	}
	public void run() {
		//Creates random object
		Random ran = new Random();						
		
		for(int i = 0; i < 20; i++){
			int x = ran.nextInt(5);

			String request = "";

			//Chooses random number from 0 - 4
			if (x == 0){
				//If x = 0, go to nextEven thread
				request = "NEXTEVEN";
			}
			if (x == 1){
				//If x = 1, go to nextOdd thread
				request = "NEXTODD";
			}
			if (x == 2){
				//If x = 2, go to nextEvenFib thread
				request = "NEXTEVENFIB";
			}	
			if (x == 3){
				//If x = 3, go to nextLargerRand thread
				request = "NEXTLARGERRAND";
			}
			if (x == 4){
				//If x = 4, go to nextPrime thread
				request = "NEXTPRIME";

			}
			
			Node temp = new Node(id, i, request);

			requestQue.add(temp);
		}
	}
}