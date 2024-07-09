import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<Endereco>();

        String busca = "";
        ConsultarCep consultarCep = new ConsultarCep();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um cep: ");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            try {
                Endereco endereco = consultarCep.consultaEndereco(busca);
                System.out.println(endereco);
                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.salvaArquivo(endereco);

                enderecos.add(endereco);


            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicação");
            }
        }

    }
}
