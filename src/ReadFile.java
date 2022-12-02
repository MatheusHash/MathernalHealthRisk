import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

public class ReadFile {
        private String caminho;

        public String getCaminhoArquivo(){
            return this.caminho;
        }

        public String setCaminhoArquivo(){
            System.out.println("Digite o caminho para o arquivo:  \n");
            this.caminho = "C:\\Users\\mathe\\Documents\\Projects\\MathernalHealthRiskHash\\MathernalHealthRisk\\src\\teste.txt";
            return this.caminho;
        }

        private int i=0;

        public ArrayList<String> getDados(String arquivo) throws FileNotFoundException, IOException{

            ArrayList<String> dados= new ArrayList<String>();
            java.io.FileReader fr = new java.io.FileReader( arquivo );
            BufferedReader br = new BufferedReader( fr );
            //enquanto houver mais linhas
            while( br.ready() ){
                //lê a proxima linha
                String linha = br.readLine();
                dados.add(linha);
            }

            br.close();
            fr.close();
//            System.out.println( dados );
            return dados;
        }





}
