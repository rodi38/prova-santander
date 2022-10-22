package prova.santander;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

//Enunciado
//O programa deve:
//
//1-pedir que o usuário digite a quantidade de temperaturas a serem transformadas.V
//2-pedir que o usuário escolha duas unidades de temperatura. A unidade de origem da temperatura e V
// a unidade a ser transformada.
//3-conseguir transformar temperatura em Celsius, Kelvin e Fahrenheit a partir de
// qualquer uma dessas unidades para qualquer uma dessas unidades. V
//4-imprimir cada temperatura passada, e a unidade escolhida, e também a temperatura resultante, transformada, com sua respectiva unidade.
//5-calcular a média das temperaturas iniciais e transformadas.
//6-ser capaz de se recuperar e tratar qualquer erro que venha ocorrer em sua execução. Entrega via GITHUB durante
// a aula de segunda. Não precisa ser tudo na mesma classe.
public class Prova {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#,###.00");

    public static void main(String[] args) {
        int QuantidadeTemperaturas;
        double[] temperaturas;
        String temperaturaOrigem;
        String temperaturaTransformada;
        double[] conversao;
        double somaOriginal = 0;
        double somaConvertida = 0;
        double mediaOriginal;
        double mediaConvertida;

        menu();
        System.out.print("Digite a quantidade de temperaturas a serem transformadas: ");
        QuantidadeTemperaturas = scanner.nextInt();
        System.out.print("Digite a unidade de temperatura de origem: (ex: Celcius) ");
        temperaturaOrigem = scanner.next().toLowerCase();
        System.out.print("Digite a temperatura a ser transformada: (ex: Fahrenheit) ");
        temperaturaTransformada = scanner.next().toLowerCase();
        System.out.printf("Digite as temperaturas em %s a serem convertidas para %s",
                temperaturaOrigem, temperaturaTransformada);
        temperaturas = entradaDeTemperaturas(QuantidadeTemperaturas);
        System.out.println(Arrays.toString(temperaturas));
        conversao = new double[temperaturas.length];
        for (int i = 0; i < temperaturas.length ; i++) {
            somaOriginal+=temperaturas[i];
            if (temperaturaOrigem.equals("fahrenheit")){
                conversao[i] = conversorFahrenheit(temperaturas[i], temperaturaTransformada);
                somaConvertida +=conversao[i];
            }
            if (temperaturaOrigem.equals("celcius")){
                conversao[i] = conversorCelsius(temperaturas[i], temperaturaTransformada);
                somaConvertida +=conversao[i];
            }
            if(temperaturaOrigem.equals("kelvin")){
                conversao[i] = conversorKelvin(temperaturas[i], temperaturaTransformada);
                somaConvertida +=conversao[i];
            }
        }
        mediaOriginal = somaOriginal/temperaturas.length;
        mediaConvertida = somaConvertida/conversao.length;

        System.out.printf("Você escolheu converter de %s para %s \n",
                temperaturaOrigem, temperaturaTransformada);
        System.out.println("Temperaturas enviadas: "+Arrays.toString(temperaturas));
        System.out.println("-------------------------------------------------------------");
        System.out.print("Temperaturas convertidas: ");
        for (int i = 0; i < conversao.length; i++) {
            System.out.printf("%.1f",conversao[i]);
        }
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("A soma das temperaturas originais é: %.1f \n", somaOriginal);
        System.out.printf("A soma das temperaturas convertidas é: %.1f \n", somaConvertida);
        System.out.printf("A media das temperaturas convertidas é: %.1f \n", mediaOriginal);
        System.out.printf("A media das temperaturas convertidas é: %.1f \n", mediaConvertida);




    }
    private static void menu(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Seja bem vindo ao conversor de temperaturas.");
        System.out.println("Neste programa você consegue converter qualquer temperatura");
        System.out.println("-------------------------------------------------------------");
    }
    private static double[] entradaDeTemperaturas(int quantidade){
        double[] temperaturasArmazenadas = new double[quantidade];
        for (int i = 0; i < temperaturasArmazenadas.length; i++) {
            temperaturasArmazenadas[i] = scanner.nextDouble();
        }
        return temperaturasArmazenadas;
    }
    private static double conversorCelsius(double celsius, String temperaturaTransformada){
        try {
            if (temperaturaTransformada.equals("fahrenheit")){
                return (celsius * (double)9/5)+32;
            } else if(temperaturaTransformada.equals("kelvin")) {
                return celsius + 273.15;
            }
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        return celsius;
    }
    private static double conversorKelvin(double kelvin, String temperaturaTransformada){
        try{
            if (temperaturaTransformada.equals("celcius")){
               return kelvin - 273.15;
            } else if (temperaturaTransformada.equals("fahrenheit")) {
               return (kelvin - 273.15) * (double)9/5 + 32;
            }
        }catch ( ArithmeticException e){
            e.printStackTrace();

        }
        return kelvin;
    }
    private static double conversorFahrenheit(double fahrenheit, String  temperaturaTransformada){
        try{
            if (temperaturaTransformada.equals("celcius")){
                return (fahrenheit - 32) * (double)5/9;
            } else if (temperaturaTransformada.equals("kelvin")) {
                return (fahrenheit - 32) * (double)5/9 + 273.15;
            }
        }catch ( ArithmeticException e){
            e.printStackTrace();

        }
        return fahrenheit;
    }

}
