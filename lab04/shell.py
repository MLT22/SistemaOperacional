import os
import sys

def main():
    while True:
        # Exibe o prompt
        comando = input("shell> ").strip()

        # Comando de saída
        if comando in ["exit", "quit"]:
            print("Saindo do shell...")
            break

        # Ignora entradas vazias
        if not comando:
            continue

        # Divide comando e argumentos
        args = comando.split()

        try:
            pid = os.fork()  # Cria processo filho
        except OSError as e:
            print(f"Erro ao criar processo: {e}")
            continue

        if pid == 0:
            # Processo filho
            try:
                os.execvp(args[0], args)  # Executa comando
            except FileNotFoundError:
                print(f"Comando não encontrado: {args[0]}")
                os._exit(1)  # Encerra filho com erro
        else:
            # Processo pai aguarda filho
            _, status = os.wait()
            if os.WIFEXITED(status):
                exit_code = os.WEXITSTATUS(status)
                if exit_code != 0:
                    print(f"Comando terminou com código de saída {exit_code}")
            else:
                print("Processo filho terminou de forma anormal.")

if __name__ == "__main__":
    main()