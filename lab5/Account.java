
public class Account{
    private int balance;

    public Account(int saldoInicial){
        this.balance = saldoInicial;
    }


    public int getBalance(){
        return balance;
    }

    public void deposit(int saldoADepositar){
        balance += saldoADepositar;
        System.out.printf("Saldo atualizado %d%n",balance);
    }

    public boolean withdraw(int saldoASacar){
        if(balance >= saldoASacar){
            balance -= saldoASacar;
            System.out.printf("Valor sacado: %d%n",saldoASacar);
            System.out.printf("Salto restante %d%n", balance);
            return true;
        }
        else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
}