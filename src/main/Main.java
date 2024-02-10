package src.main;

import src.methods.ConsultaCep;
import src.methods.GeradorArquivo;
import src.models.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        String cep;
        int operacao = 1;

        do {
            try {
                System.out.println("Digite o CEP que deseja consultar: ");
                cep = leitor.nextLine();

                ConsultaCep consultaCep = new ConsultaCep();
                Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                System.out.println(novoEndereco);

                GeradorArquivo gerador = new GeradorArquivo();
                gerador.salvarJson(novoEndereco);

                System.out.println("Deseja consultar outro CEP? \n1- Sim \n0- Não/Sair");
                operacao = leitor.nextInt();
                leitor.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (operacao != 0);
    }
}