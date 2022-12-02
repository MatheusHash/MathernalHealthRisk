import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Mathernal Health Risk - Perceptron");

        Perceptron perceptron = new Perceptron();

        ReadFile file = new ReadFile();
        file.setCaminhoArquivo();
        String path = file.getCaminhoArquivo();
        ArrayList<String> dados = file.getDados(path);

        perceptron.setPesos();

        for(String linha : dados) {
            perceptron.setEntrada(linha);
            perceptron.treinamento();
//            System.out.println(linha);
        }

       int result = perceptron.ativacao();
        System.out.println("Quantidade de Épocas:  "+  perceptron.getEpocas());
        System.out.println("RESULT:  "+ result);
        System.out.println("Fim da execução do programa!");
    }

}