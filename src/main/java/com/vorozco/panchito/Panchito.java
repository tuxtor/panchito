package com.vorozco.panchito;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class Panchito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var panchito = new Panchito();
        var bayes = new BayesClassifier<String, String>();

        out.println("test");
        System.out.println("Soy panchito el bot presidencial");


        while(true) {
            System.out.println("\n\n Ingresa una frase");
            var frase = panchito.readFromConsole();



            if(frase.equalsIgnoreCase("inferir")) break;

            System.out.println("Ingresa una etiqueta");
            var etiqueta = panchito.readFromConsole();

            //Insertar a cerebro
            bayes.learn(etiqueta, Arrays.asList(frase.split("\\s")));
            System.out.println(etiqueta + "-" + frase);

        }

        System.out.println("Pasemos a inferir . . . ");

        while(true) {
            System.out.println("\n\n Ingresa una frase a inferir");

            var fraseTest = panchito.readFromConsole();
            if(fraseTest.equalsIgnoreCase("exito")) break;

            System.out.println("Mi inferencia es: " + bayes.classify(
                    Arrays.asList(fraseTest.split("\\s"))));


        }


        System.out.println("Adios");
    }


    public String readFromConsole() {
        var scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
