
		import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//Datos
//Nombre: Ervin Enmanuel Molina Montoya
//Salon: 1M7-S 
//Numero de carnet:2024-1691U

public class MainClass {

    public static void main(String[] args) throws Exception {
        //Mando a llamar el metodo Pedirnumeros para pedirle al usuario los valores
        PedirNumeros();
    }

    public static void Operaciones(int num1, int num2, int num3) {
        //se valida si son iguales dos o mas valores
            if (num1 == num2 || num2 == num3 || num1 == num3) {
                System.out.println("No pueden haber numeros iguales...");
                PedirNumeros();
            } else{
                //si no son se realiza las operaciones
                //se llama el metodo ValidarNummayor para validar que numero es mayor
                ValidarNumMayor(num1, num2, num3);
                System.out.println("La suma de los numeros menores es: "+Sumanumeros(num1, num2, num3));
                System.out.println("La resta de los numeros mayores es: "+Restanumeros(num1, num2, num3));
                PedirNumeros();               
            }
    }

    public static void ValidarNumMayor(int num1,int num2, int num3){
        //se hace la comparacion para ver cual es mayor
        if (num1>num2 && num1>num3) {
            System.out.println("\nEl numero mayor es: "+num1);
        } else if(num2>num1 && num2>num3){
            System.out.println("\nEl numero mayor es: "+num2);
        } else if (num3>num1 && num3>num2) {
            System.out.println("\nEl numero mayor es: "+num3);
        }
    }

    public static void PedirNumeros() {
        //En este metodo se lee los tres valores, y valida que sean enteros
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nIngrese el primer numero: ");
            int num1 = sc.nextInt();
            System.out.print("Ingrese el segundo numero: ");
            int num2 = sc.nextInt();
            System.out.print("Ingrese el tercer numero: ");
            int num3 = sc.nextInt();
            /*Se llama al metodo para validar si los valores son iguales, si no lo son se realizan las operaciones
             * de suma y resta, y ver que valor es mayor
             */
            Operaciones(num1, num2, num3); 
        } catch (InputMismatchException e) {
            //se controla la excepcion si el usuario ingresa un valor que no sea de tipo entero
            System.out.println("Solo se aceptan valores enteros....Vuelva a ingresar los números");
            sc.nextLine();
            //se vuelve a llamar al metodo PedirNumeros
            PedirNumeros();
        } sc.close();
    }

    public static int Sumanumeros(int num1,int num2,int num3){
        //este metodo suma los dos valores menores de los 3, usando el metodo de ordenarNumeros para llamar a los valores 0 y 1
        int[] numerosOrdenados = ordenarNumeros(num1, num2, num3);
        int mayor1 = numerosOrdenados[0];
        int mayor2 = numerosOrdenados[1];

        int suma = mayor1 + mayor2;

        return suma;
    }

    public static int Restanumeros(int num1, int num2, int num3) {
        //este metodo resta los dos valores mayores de los 3, usando el metodo de ordenarNumeros para llamar a los valores 1 y 2
        int[] numerosOrdenados = ordenarNumeros(num1, num2, num3);
        int mayor1 = numerosOrdenados[2];
        int mayor2 = numerosOrdenados[1];

        int resta = mayor1 - mayor2;

        return resta;
    }

    public static int[] ordenarNumeros(int num1, int num2, int num3) {
        //este metodo se usa para ordenar los numeros de menor a mayor y guardarlo en un arreglo
        int[] numeros = {num1, num2, num3};
        Arrays.sort(numeros);
        return numeros;
    }

}