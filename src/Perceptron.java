import java.text.DecimalFormat;
import java.util.Random;

public class Perceptron {

    private int qtdEntradas =0;
    private int qtdAcertos =0;

    private int epocas = 0;

    private double e = 2.718;
    public int getEpocas() {
        return epocas;
    }

    private double teta = 0;

//    Constante da taxa de aprendizado
    private static double n = 0.5;
//    Valor de saida produzida pelo Perceptron
    private double y;
    
    private double u;
//    Matriz de pesos
    private double pesos[] = new double[6];
    private int qtdPesos = this.pesos.length;
    private Random rand = new Random();

    private double dk;

    public void setDk(double dk) {
        this.dk = dk;
    }

    private double Entradas[] = new double[7];

    public void preenchePesos(){
        for (int i = 0; i < this.pesos.length; i++) {
            this.pesos[i] = this.rand.nextDouble();
        }
    }

    public void setTeta(){
        double soma = 0;
        for (int i = 0; i < this.pesos.length; i++) {
            soma += (this.pesos[i] * this.Entradas[i]);
        }
        this.teta = (soma / this.pesos.length -1);
    }

    public void setPesos(){
        for (int i = 0; i < this.pesos.length; i++) {
            this.pesos[i] = this.rand.nextDouble();
        }
    }
    public double novoPeso(double w, double xk){
        double result=0;
        for (int i = 0; i < this.Entradas.length-1; i++) {
            result = w + this.n * (this.dk - this.y) * this.Entradas[i];
        }
        return result;
    }
    public void setEntrada(String entrada){
        String[] valores = entrada.split("\\s+");
        int i=0;
        for (i = 0; i < valores.length - 1; i++) {
            this.Entradas[i] = Double.valueOf(valores[i]).doubleValue();
//            System.out.println("Entrada "+ i + this.Entradas[i]);
        }
        setDk( Double.valueOf(valores[6]).doubleValue() );

        this.qtdEntradas++;
    }

    public void sigmoid( double entrada, double epoca, double peso ){
        this.y = 1 /( 1 + (1/this.e) * entrada * epoca * peso * - this.teta );
    }

    public void treinamento(){
        boolean erro = true;
        int count = 0;
        int k = Entradas.length-1;
        double aux=0;
        DecimalFormat formatter = new DecimalFormat("0.0000");

//        System.out.println("TAMANHO DAS ENTRADA: " + this.Entradas.length );
        while(erro){
            aux = 0;
            for (int i = 0; i < this.Entradas.length - 1; i++) {

//                System.out.println("Epocas : " + count + 1);

//                for (int j = 0; j <this.pesos.length; j++) {
//                    this.pesos[j] += (this.y - this.dk) * this.Entradas[i];
//                    this.u = this.pesos[i] * Entradas[i] - this.teta;
//                }
                for (int l = 0; l < this.pesos.length; l++) {
//                    System.out.println(aux +"="+ aux +"+"+ this.pesos[l] +"*"+ this.Entradas[l] );
                    aux = Math.round(aux / 12) + (this.pesos[l] * this.Entradas[l]);
                }

                this.u = aux;
                this.y = this.u/100;

                if(this.y != this.dk){
                    this.pesos[i] = novoPeso(this.pesos[i], this.Entradas[i]);
                    erro = !erro;
                    break;
                }

            }
            count++;
            this.epocas++;
        }
    }

    public void acuracia(){
        System.out.println("Porcentagem final da acuracia");
        int ac = this.qtdAcertos ;
        int et = this.qtdEntradas;
        double resultado = ac / et;
        System.out.println(" "+this.qtdAcertos+"/"+this.qtdEntradas   );
        System.out.println("Resultado: "+ resultado);
    }

    public int porcentagem =0;
    public double ativacao(){
        double aux=0;
        this.teta += (this.y - this.dk);

        for (int i = 0; i < this.pesos.length; i++) {
            aux = Math.round(aux / 12) + (this.pesos[i] * this.Entradas[i]) - (this.teta);
        }
        this.u = aux;
        this.y = Math.floor(u/100);
        int count=0;
        double soma=0;
        //função ativação pega o valor de y e conpara com o intervalo para saber se a amostra é de ALTO risco, MÉDIO risco, BAIXO risco.

        if(this.u <= this.dk){ // -1
            this.qtdAcertos++;
            return this.y;
        }else if(this.u < this.dk && this.u > this.dk ){ // 0
            this.qtdAcertos++;
            return this.y;
        }else if(this.u >= this.dk){ // 1
            this.qtdAcertos++;
            return this.y;
        }
        return this.y;
    }

}
