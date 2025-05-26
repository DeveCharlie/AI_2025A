
public class Neurona {

    private double weight[];
    private double bias;
    private double learningRate;
    private int salidaObtenida;

    public Neurona(int dataLength){
        this.weight = generateWeight(dataLength);
        this.bias = (Math.random() *2) -1;
        this.learningRate = 0.1;
    }

    public double[] generateWeight(int dataLength){
        double weight[] = new double[dataLength];
        for (int i = 0; i<dataLength; i++) {
            weight[i] = (Math.random() * 2) - 1;
        }
        return weight;
    }

    public void printWeight(){
        for (double w: this.weight) {
            System.out.println("Weight: " + w);
        }
    }

    public int predecir(int[] entradas) {
        double suma = this.bias;
        for (int i = 0; i < entradas.length; i++) {
            suma += entradas[i] * this.weight[i];
        }

        if (suma >= 0)
            return 1;
        else
            return 0;
    }

    public void training(int[] entradas, int salidaEsperada) {
        this.salidaObtenida = predecir(entradas); // retorna valor de la funcion de activacion
        int error = salidaEsperada - this.salidaObtenida;

        // Ajustar pesos y bias
        for (int i = 0; i < this.weight.length; i++) {
            this.weight[i] += this.learningRate * error * entradas[i];
        }
        this.bias += this.learningRate * error;
    }

    public void printResults(Data datos){
        System.out.println("Entrada: " + datos.entradas[0] + ", " + datos.entradas[1]
                + " => Salida esperada: " + datos.salida + " | Salida obtenida: " + this.salidaObtenida);
    }
}
