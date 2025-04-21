import java.util.Scanner;

/*
 * Problema:
 * 
 * "Dado um array de skills de jogadores de futebol, determinar o 
 * maior time balanceado possível em que a diferença de skills
 * entre quaisquer pares de jogadores no mesmo time não seja
 * maior que 5."
 * 
 * Exemplos de input/output: tests/
 * 
 * Não é permitido o uso da biblioteca Arrays.
 * É permitido o uso de códigos próprios
 * desenvolvidas em aulas anteriores.
 * 
 * Ver especificação em pdf para mais detalhes.
*/
public class Futebol {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Leitura do número de jogadores
        int n = leitor.nextInt();
        int[] skills = new int[n];
        
        // Leitura das skills
        for (int i = 0; i < n; i++) {
            skills[i] = leitor.nextInt();
        }
        leitor.close();
        
        // Cálculo do maior time possível
        int maxTeamSize = maiorTimePossivel(skills);

        System.out.println(maxTeamSize);
    }

    private static int maiorTimePossivel(int[] skills) {
        bubbleSort(skills);
        
        int n = skills.length;
        int maxTeamSize = 1;
        
        for (int i = 0; i < n; i++) {
            int j = i;
            
            while (j < n && skills[j] - skills[i] <= 5) {
                j++;
            }
            
            int currentSize = j - i;
            
            if (currentSize > maxTeamSize) {
                maxTeamSize = currentSize;
            }
        }
        
        return maxTeamSize;
    }
    
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
