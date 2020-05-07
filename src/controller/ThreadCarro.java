package controller;
 
import java.util.concurrent.Semaphore;
 
public class ThreadCarro extends Thread {
 
    private int idCarro;
    private static int passando;
    private Semaphore semaforo;
 
    public ThreadCarro(int idCarro, Semaphore semaforo) {
        this.idCarro = idCarro;
        this.semaforo = semaforo;
    }
 

    public void run() {
    	
        try {
            semaforo.acquire();
            carroPassando();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();

        }
    }
 

 
    private void carroPassando() {
    	passando ++;
        System.out.println("Carro #" + idCarro +" foi o "+passando+"° a passar");
        try {
			sleep (100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
