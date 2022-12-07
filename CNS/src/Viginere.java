import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Viginere {

    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\91721\\IdeaProjects\\CNS\\src\\input.txt");

        BufferedReader brf = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        StringBuilder input = new StringBuilder(brf.readLine());

        System.out.println("Plain text: "+input);

        System.out.println("Enter key:");
        String key = br.readLine();
        System.out.println("Key: "+key);

        String encryptedMsg = encrypt(input.toString(), key);
        System.out.println("Encrypted message : "+encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
    }
}
