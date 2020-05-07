package main;
 
import java.util.concurrent.Semaphore;
 
import controller.ThreadCarro;
 
public class Main {
 
    public static void main(String[] args) {
 
        int permissao = 1;
        Semaphore semaforo = new Semaphore(permissao);
       
        for (int idCarro = 0; idCarro < 4 ; idCarro++) {
            Thread tCarro = new ThreadCarro(idCarro, semaforo);
            tCarro.start();
        }
       
    }
   
}