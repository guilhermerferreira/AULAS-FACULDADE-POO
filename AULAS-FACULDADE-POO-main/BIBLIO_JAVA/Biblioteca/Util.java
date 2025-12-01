package Biblioteca;

import java.util.Scanner;

public class Util {
    
    
    public static boolean confirma(Scanner scan, String msg){

        while(true){
            System.out.print(msg+ "(S/N)? ");
            String input = scan.nextLine().trim();

            // Verifica se o usuário digitou algo e pega o primeiro caractere
            if (!input.isEmpty()) {
                char caractere = input.charAt(0);
                if (caractere == 'S' || caractere == 's'){
                    return true;
                } else if (caractere == 'N' || caractere == 'n'){
                    return false;
                } else 
                    System.out.println("Digite S ou N");
            } else {
                System.out.println("Você não digitou nada.");
            }
        }
        
    }//Fim confirma()

    

}
