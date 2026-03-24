public class Main {
    // capacidade do buffer do problema
    public static final int CAPACITY = 10; // Mantive, mas como só utilzamos o mutex não foi necessário

    
    public static void main(String[] args) {
       Account conta = new Account(1000);
       Client c1 = new Client("Gustavo", conta);
       Client c2 = new Client("João", conta);
       Client c3 = new Client("Gabriel", conta);
       Client c4 = new Client("Leo", conta);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

    }

}
