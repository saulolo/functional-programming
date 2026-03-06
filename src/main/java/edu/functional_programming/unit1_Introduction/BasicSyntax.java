package edu.functional_programming.unit1_Introduction;

public class BasicSyntax {

    public static void main(String[] args) {

        System.out.println("Sintaxis de una Expresión Lamnda");
        /*
        * Sin paramtros:  () -> sentencia
        * Con un parámetros: Parámetro -> sentencia
        * Con mas de un parámetro: (parametro1, parametro2) -> sentencia
        * Con mas de una sentencia: (Parámetro) -> {sentencia1;
        *                                           sentencia2;}
        * */

        //Instanciar una inretfaz con lamnda
        Ficticia f = parametro -> System.out.println(parametro);

        //Invocar méthod myMethod con instancia
        MyClase myClase = new MyClase();

        //Invocar méthod myMethod con Lamnda
        myClase.myMethod(parametro2 -> System.out.println(parametro2));


    }

    public interface Ficticia {
        public void aceptar(int valor);
    }

    //Sin Expresión Lambda
    Ficticia f = new Ficticia() {
        @Override
        public void aceptar(int valor) {

        }

    };

    //Con Expresión Lambda
    Ficticia funtion = (valor) -> System.out.println("Hello World" + valor);
    //Si la expresió lambda solo tiene una sentencia adentro podemos presindier de los corchetes.
    //No se declaran los tipos de variables en una expresión lamnda.

    public static class MyClase {

        public void myMethod(Ficticia parameter) {

        }
    }


}
