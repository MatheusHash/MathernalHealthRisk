import java.util.Random;

public class Perceptron {


    private int epocas = 0;

    private double e = 2.718;
    public int getEpocas() {
        return epocas;
    }

    private double teta = 0;

//    Constante da taxa de aprendizado
    private static double n = 0.1;
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
            System.out.println(valores[i]);
            this.Entradas[i] = Double.valueOf(valores[i]).doubleValue();
//            System.out.println("Entrada:  " + this.Entradas[i]);
        }
        setDk( Double.valueOf(valores[valores.length-1]).doubleValue() );
//        System.out.println("DK: " + this.dk);
    }

    public void sigmoid( double entrada, double epoca, double peso ){
        this.y = 1 /( 1 + (1/this.e) * entrada * epoca * peso * - this.teta );
    }

    public void treinamento(){
        boolean erro = true;
        int count = 0;
        int k = Entradas.length-1;
        double aux=0;

        while(erro){
            for (int i = 0; i < this.Entradas.length -1; i++) {

                System.out.println("Epocas : " + count + 1);

//                for (int j = 0; j <this.pesos.length; j++) {
//                    this.pesos[j] += (this.y - this.dk) * this.Entradas[i];
//                    this.u = this.pesos[i] * Entradas[i] - this.teta;
//                }
                for (int l = 0; l < this.pesos.length; l++) {
                    aux = aux + (this.pesos[l] * this.Entradas[l]);
                }
                this.u = aux;

                this.teta += (y - this.dk);

//                this.y = this.ativacao();

                if(this.y != this.dk){
                    this.pesos[i] = novoPeso(this.pesos[i], this.Entradas[i]);
                    erro = !erro;
                    return;
                }

                System.out.printf("y: %.10f -> desired: %.1f\n", this.y, this.dk);
            }
            count++;
            this.epocas++;
        }
    }


    public String operacao(){
        if(y <  (-0.3)){//função ativação pega o valor de y e conpara com o intervalo para saber se a amostra é de ALTO risco, MÉDIO risco, BAIXO risco.
            return "O elemento pertence a classe de ALTO risco!";
        }else if((y > (0.3)) || (y < (-0.3)) ){
            return "O elemento pertence a classe de MÉDIO risco!";
        }else if(y > 0.3){
            return "O elemento pertence a classe de BAIXO risco!";
        }else{
            return "erro: falta de precisão!";
        }
    }

    public int ativacao(){
        double aux=0;
        for (int i = 0; i < this.pesos.length; i++) {
            aux = aux + (this.pesos[i] * this.Entradas[i]) - (this.teta);
        }
        this.u = aux;
        this.y = u/100;

//        System.out.println("Valor de Y:"+y);
//        System.out.println("valor AQUI: "+ this.y);

        if(y <  (-0.3)){//função ativação pega o valor de y e conpara com o intervalo para saber se a amostra é de ALTO risco, MÉDIO risco, BAIXO risco.
            return -1;
        }else if((y > (0.3)) || (y < (-0.3)) ){
            return 0;
        }else{
            return 1;
        }
    }

}
