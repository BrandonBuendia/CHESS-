import java.util.Collections;
import java.util.Stack;

public class chess {
    public static Stack<Character> chess = new Stack<Character>();
    public static String orden, tipo, color;

    public chess(String[] args) {
    }

    public void opciones(String[] args){
            if (args.length == 4){
                if(Tipos(args[0])){
                    orden = args[0];
                }
                else {
                    orden = "Invalido";
                }
                if(Tipos(args[1])){
                    tipo = args[1];
                }else {
                    tipo = "Invalido";
                }
                if(Tipos(args[2])){
                    color = args[2];
                }else {
                    color = "Invalido";
                }
                boolean prueba;
                prueba = Verificar(args);

                if (tipo.equals("c") || tipo.equals("C")){
                    System.out.println("Color = " + color);
                    System.out.println("Orden = " + orden);
                    System.out.println("tipo = " + tipo);
                    if (prueba){
                        asignar(args[3]);
                        System.out.println("Valores" + chess);
                        ordenarStack();
                        System.out.println("Orden" + chess);
                    } else {
                        System.out.println("Valores = Invalidos");
                    }
                } else if (tipo.equals("n") || tipo.equals("N")) {
                    prueba = Numero(args);
                    System.out.println("Color = " + color);
                    System.out.println("Orden = " + orden);
                    System.out.println("tipo = " + tipo);
                    if (prueba){
                        asignar(args[3]);
                        System.out.println("Valores" + chess);
                        ordenarStack();
                        System.out.println("Orden" + chess);
                    } else {
                        System.out.println("Valores" + chess);
                        System.out.println("Orden = Invalidos");
                    }
                } else {
                    System.out.println("Orden = " + orden);
                    System.out.println("tipo = " + tipo);
                    System.out.println("Color = " + color);
                    System.out.println("Valores" + chess);
                }
            }else{
                System.out.println("argumentos insuficientes");
            }
        }
        public static void asignar(String valor){
            for (int i = 0; i < valor.length(); i++){
                chess.push(valor.charAt(i));
            }
        }
        public static void ordenarStack() {
            Collections.sort(chess);
        }
        public static boolean Verificar(String[] arg){
            boolean verificado = true;
            for (int e = 0; e < arg.length; e++){
                for (int i = 0; i < arg[e].length(); i++) {
                    if (Character.isDigit(arg[e].charAt(i))) {
                        verificado = false;
                        break;
                    }
                }
            }
            return verificado;
        }
        public static boolean Numero(String[] arg){
            boolean verificado = true;
            for (int e = 0; e < arg.length-1; e++){
                for (int i = 0; i < arg[e].length(); i++) {
                    if (Character.isDigit(arg[e].charAt(i))) {
                        verificado = false;
                        break;
                    }
                }
            }
            for (int i = 0; i < arg[3].length(); i++) {
                if (Character.isAlphabetic(arg[3].charAt(i))) {
                    verificado = false;
                    break;
                }
            }
            return verificado;
        }
        public static boolean Tipos(String args){
            boolean verififcado = false;
            String valores = "qQiIcCnNbBwW";
            if (args.length() == 1){
                for (int i = 0; i < valores.length(); i++){
                    if (valores.charAt(i) == args.charAt(0)){
                        verififcado = true;
                        break;
                    }
                }
            }
            return verififcado;
        
    }
}
