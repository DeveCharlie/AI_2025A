public class Main {
    public static void main(String[] args) {
        /*
        Data[] datosAND = {
                new Data(0, 0, 0),
                new Data(0, 1, 0),
                new Data(1, 0, 0),
                new Data(1, 1, 1)
        };
        */

        Data[] datosOR = {
                new Data(0, 0, 0),
                new Data(0, 1, 1),
                new Data(1, 0, 1),
                new Data(1, 1, 1)
        };

        Neurona perceptron = new Neurona(2);
        int cycles = 20;
            for (int i = 0; i<cycles; i++) {
                perceptron.printWeight();
                for (Data datos : datosOR) {
                    perceptron.training(datos.entradas, datos.salida);
                    perceptron.printResults(datos);

                }
            }



    }
}