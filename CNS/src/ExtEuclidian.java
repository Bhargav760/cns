import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtEuclidian {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int tmp = 0;
        if(a<b)
        {
            tmp = a;
            a = b;
            b = tmp;
        }

        int t1 = 0;
        int t2 = 1;

        int t = 0;

        int q = 0;
        while(true)
        {
            q = a/b;
            t = t1-q*t2;
            a = b;
            b = q;

            t1 = t2;
            t2 = t;

            if(b == 0)
                break;
        }
        System.out.println("The multiplicative inverse is "+ t1);
    }
}
