/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;


 
 //@author Alejandro Dávila
import java.util.Scanner;
public class login {

        Scanner lea = new Scanner(System.in);
        char opcion_ini;
        private static String usuarioArray[] = new String[5];
        public static String contraseñaArray[] = new String[5];
        static String usuario,contraseña,continuar;
        public static boolean usuarios_ocupados[] = new boolean[usuarioArray.length]; 
        public static jugadores listaj[] = new jugadores[usuarioArray.length];
        public static String ult10[] = new String[10];
    public login(){
        do{
            System.out.print("\nBienvenido a Ghosts\n"+"\n"+"a. Crear usuario\nb. Login\nc. Salir\nIngrese opcion: ");
            opcion_ini = lea.next().charAt(0);
            while(opcion_ini != 'a' && opcion_ini != 'b' && opcion_ini != 'c'){
                System.out.print("Ingrese la letra de la opcion de su preferencia: ");
                opcion_ini = lea.next().charAt(0);
            }
            switch(opcion_ini){
                case 'a':
                    System.out.println("-------Registro-------");
                                    
                    for (int c_reg=0; c_reg<5; c_reg++){
                        
                        if (usuarios_ocupados[c_reg]==true){
                            continue;
                        }
                        System.out.print("Usuario: ");
                        usuario=lea.next();
                        while(usuario.length() <= 0){
                        	System.out.print("Porfavor ingrese un usuario valido: ");
                            usuario = lea.next();
                        }
                        for (String user: usuarioArray){
                            while (usuario.equalsIgnoreCase(user)){
                                System.out.print("Usuario ya existente. Ingrese otro nombre: ");
                                usuario = lea.next();
                                while(usuario.length() <= 0){
                                    System.out.print("Porfavor ingrese un usuario valido: ");
                                    usuario = lea.next();
                                }
                            }
                        }
                        usuarioArray[c_reg]=usuario;
                        System.out.print("Contraseña: ");
                        contraseña= lea.next();
                        while(contraseña.length() <= 0){
                        System.out.print("Porfavor ingrese contraseña valida: ");
                                contraseña = lea.next();
                        }
                        contraseñaArray[c_reg] = contraseña;
                        if(usuarioArray[c_reg].length() > 0 && contraseñaArray[c_reg].length() > 0){                            
                            System.out.println("Registro exitoso");
                            usuarios_ocupados[c_reg] = true;
                        }
                        System.out.print("Desea registrar otro usuario: ");
                        continuar = lea.next();
                        if (!continuar.equalsIgnoreCase("si")){
                            break;
                        }
                    }
                    break;
                    
                case 'b':
                    boolean condicionante = true;
                    while (condicionante==true) {
                        String conti;
                        System.out.print("\nNombre usuario: ");
                        usuario = lea.next();
                        System.out.print("Contraseña: ");
                        contraseña= lea.next();
                        for (int contaNom=0;contaNom<5;contaNom++){
                            /*
                            con este for, se va detectando si el usuario y la password son congruentes.
                            En caso de que no sean iguales, repetira el ciclo
                            */
                            if (usuario.equalsIgnoreCase(usuarioArray[contaNom])&&contraseña.equalsIgnoreCase(contraseñaArray[contaNom])){
                                System.out.println("Bienvenido "+usuario);
                                jugadores jugador = new jugadores(usuario,contraseña,0);
                                condicionante = false;
                                new menu();
                                break;
                            }
                        }
                        if (condicionante==true){
                            System.out.print("Usuario o contraseña no valido. Intentar de nuevo?: ");
                            conti = lea.next();
                            if (!conti.equalsIgnoreCase("si")){
                                break;
                            }
                        }                    
                    }
                        
                case 'c':
                    break;
                default:
                    System.out.print("Opcion no valida.\nIngrese opcion: ");
                    opcion_ini = lea.next().charAt(0);
            }
        }while(opcion_ini!='c');
    
    }
    public static String[] usuarios() {
        return(usuarioArray);
    }
    public static String[] contraseñas(){
        return(contraseñaArray);
    }
    public static void main(String[] args){
        
    }
}
