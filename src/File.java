import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class File {

    public void lerArquivo() throws IOException{

        System.out.println("Informe o nome de arquivo texto:\n");

        String nomeArquivo = "C:\\Users\\mathe\\Documents\\Projects\\MathernalHealthRiskHash\\MathernalHealthRisk\\src\\dados.txt";

        char[] linha = new char[22401];
        System.out.println("dados do arquivo\n\n");

        try {
            FileReader arq = new FileReader(nomeArquivo);
            arq.read(linha);
            System.out.println(linha);

            arq.close();

            System.out.println("\nConteúdo do arquivo texto:\n");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

}
