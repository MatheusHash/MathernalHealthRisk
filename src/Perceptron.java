import java.util.Random;

public class Perceptron {


//    Constante da taxa de aprendizado
    private static double n = 0.5;
//    Valor de saida produzida pelo Perceptron
    private double y;
    
    private double u;
//    Matriz de pesos
    private double pesos[] = new double[6];
    private int qtdPesos = this.pesos.length;
    private Random rand = new Random();

    private double Entradas[] = new double[6];

    public void preenchePesos(){
        for (int i = 0; i < this.pesos.length; i++) {
            this.pesos[i] = this.rand.nextDouble();
        }
    }

    public double[] getPesos() {
        return pesos;
    }

    public void showPesos(){
        for (int i = 0; i < this.pesos.length; i++) {
            System.out.println("Peso : " + i +"  "+ this.pesos[i]);
        }
    }

    public double treinamento(double w, double d, double x){
        double result; result = w + n *( d - this.y ) * x ;
        return result;
    }

    public void novosPesos(){
        for (int i = 0; i < this.qtdPesos; i++) {
            this.pesos[i] = treinamento(this.pesos[i], this.pesos[qtdPesos - 1], 1);
        }
    }

    public double novoPeso(double w, double dk, double xk){
        double result=0;
        for (int i = 0; i < this.Entradas.length; i++) {
            result = w + this.n * (dk - this.y) * this.Entradas[i];
        }
        return result;
    }
    public void setEntrada(){
        for(int i=0;i<6;i++){
            this.Entradas[i]=i+1;
        }
    }

    public void treinamento(){
        System.out.println("Opa");
        preenchePesos();
        int epocas = 0;
        boolean erro = false;
        int k = Entradas.length-1;
        while(!erro){
            for (int i = 0; i < Entradas.length; i++) {
                u = pesos[i] * Entradas[k];
                y = u;
                System.out.println("Opa1");
                if(y != this.pesos[i]){
                    this.pesos[i] = novoPeso(this.pesos[i], -1, this.Entradas[k]);
                    erro = !erro;
                    System.out.println("Opa2");
                    break;
                }

            }
            System.out.println("Opa3");
            epocas++;
        }
    }

    public String operacao(){
        double aux=0;
        for (int i = 0; i < this.pesos.length; i++) {
            aux = aux + (this.pesos[i] * this.Entradas[i]);
        }
        u = aux;
        y = u;

        System.out.println("Valor de Y:"+y);
        if(y <  0){
            return "O elemento pertence a classe de ALTO risco!";
        }else if((y > (-1)) || (y < 1) ){
            return "O elemento pertence a classe de MÉDIO risco!";
        }else if(y > 0){
            return "O elemento pertence a classe de BAIXO risco!";
        }else{
            return "erro: falta de precisão!";
        }


    }

}
