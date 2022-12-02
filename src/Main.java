import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Mathernal Health Risk - Perceptron");

        Perceptron perceptron = new Perceptron();
        String caminhoArquivo = "C:\\Users\\mathe\\Documents\\Projects\\MathernalHealthRiskHash\\MathernalHealthRisk\\src\\teste.txt";
        ReadFile file = new ReadFile();
        file.setCaminhoArquivo(caminhoArquivo);
        String path = file.getCaminhoArquivo();
        ArrayList<String> dados = file.getDados(path);

        perceptron.setPesos();
        double result=0;

        /**
         * Fase de treinamento
         * */
        for(String linha : dados) {
            perceptron.setEntrada(linha);
            perceptron.treinamento();
//            System.out.println(linha);
        }



        caminhoArquivo = "C:\\Users\\mathe\\Documents\\Projects\\MathernalHealthRiskHash\\MathernalHealthRisk\\src\\dados2.txt";
        file.setCaminhoArquivo(caminhoArquivo);
        path = file.getCaminhoArquivo();
        dados = file.getDados(path);

        /**
         * Fase de execução
         * */

        for(String linha : dados) {
            perceptron.setEntrada(linha);
            result = perceptron.ativacao();
//            System.out.println(linha);
        }

        System.out.println("Quantidade de Épocas:  "+  perceptron.getEpocas());
        System.out.println("RESULT:  "+ result);
        System.out.println("Fim da execução do programa!");
        perceptron.acuracia();
    }

}