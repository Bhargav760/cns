import java.io.*;

public class CNS1 {

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
        for(char c:input.toString().toCharArray())
        {
            if(c>='a'&&c<='z')
            {
                c-='a';
                c+=key;
                c%=25;
                c+='a';

            }
            if(c>='A'&&c<='Z')
            {
                c-='A';
                c+=key;
                c%=25;
                c+='A';
            }
            encryption.append(c);
        }
        System.out.println(encryption);

        StringBuilder decryption = new StringBuilder();
        //Decryption
        for(char c:encryption.toString().toCharArray())
        {
            if(c>='a'&&c<='z')
            {
                c-='a';
                c= (char) (c-key+25);
                c%=25;
                c+='a';

            }
            if(c>='A'&&c<='Z')
            {
                c-='A';
                c= (char) (c-key+25);
                c%=25;
                c+='A';
            }
            decryption.append(c);
        }

        System.out.println(decryption);

    }
}
