import java.io.*;

public class DES {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\91721\\IdeaProjects\\CNS\\src\\input.txt");

        BufferedReader brf = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        StringBuilder input = new StringBuilder(brf.readLine());

        System.out.println("Plain text: "+input);

        System.out.println("Enter key:");
        int key = Integer.parseInt(br.readLine());
        System.out.println("Key: "+key);

        //Encryption:
        StringBuilder encryption = new StringBuilder();

    }
}
