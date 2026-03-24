import java.util.Random;

public class Client extends Thread{

    private String name;
    private Account account;

    public Client(String name, Account account){
        this.name = name;
        this.account = account;
    }

    private void execute() throws InterruptedException{
        Random random = new Random();
        int[] VALUES = {10,20,50,100};
        int valor = VALUES[random.nextInt(VALUES.length)];
        Boolean depositar = random.nextBoolean();
        Semaphores.mutex.acquire();
        if(depositar){
            System.out.printf("O Cliente %s depoistou %d%n",name,valor);
            account.deposit(valor);
        }
        else{
            System.out.printf("O Cliente %s tentou retirar %d%n",name,valor);
            if(!account.withdraw(valor)){
                System.out.printf("Clente: %s tentou retirar %d mas não havia dineiro.",name, valor);
                if(account.getBalance() == 0){
                    System.out.printf("O saldo está em zero e estão tentado retirar");
                    System.exit(0);
                }
            }
            
        }
        Semaphores.mutex.release();

    }

    
    @Override
    public void run(){
        try {
            while (true) { 
                execute();
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}