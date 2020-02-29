/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Random;

/**
 *
 * @author david
 */
public class AlgoritmosOrdenacion {

    int [] lista;
    
    public void shellSort(int[] numeros) {
        
        int salto, aux;
        
        boolean intercambio;
        
        for (salto = numeros.length / 2; salto != 0; salto /= 2) {
            intercambio = true;
           
            while (intercambio) {
                intercambio = false;
                
                for (int i = salto; i < numeros.length; i += salto) {               
                   
                    if (numeros[i - salto] > numeros[i]) {
                        aux = numeros[i];
                        numeros[i] = numeros[i - salto];
                        numeros[i - salto] = aux;
                        intercambio = true;
                    }
                }
            }
        }
    }
    
    public int[] numerosRandom(int dimension){
        int[] numeros=new int[dimension];
        Random r=new Random();
        for (int i = 0; i < dimension; i++) {
            numeros[i]=r.nextInt();
        }
        return numeros;
    }

    public static void main(String[] args) {
        AlgoritmosOrdenacion ordenacion =new AlgoritmosOrdenacion();
        
        int rango=100000;//numero de numeros con los que probamos
        int[] numeros=ordenacion.numerosRandom(rango);//generamos los numeros
        
        ordenacion.lista=new int[rango];
        
        for (int i = 0; i < rango; i++) {
            ordenacion.lista[i]=numeros[i];
        }
        System.out.println("Empieza:");
        long tiempoInicio=System.currentTimeMillis();
        ordenacion.shellSort(ordenacion.lista);
        long tiempoFinal=System.currentTimeMillis();
        
        System.out.println("Ha tardado: "+(tiempoFinal-tiempoInicio));
    }
    
}
