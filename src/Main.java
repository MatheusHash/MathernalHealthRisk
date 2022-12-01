import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Mathernal Health Risk - Perceptron");

        Perceptron perceptron = new Perceptron();

        for(int i=0;i<750;i++){
            perceptron.setEntrada();
            perceptron.treinamento();
        }
       String result = perceptron.operacao();
        System.out.println("Resultado do Perceptron:"+result);
        //File file = new File();
        //file.lerArquivo();


        System.out.println("Fim da execução do programa!");
    }
}