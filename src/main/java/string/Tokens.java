package string;

import java.util.StringTokenizer;

public class Tokens {

    public static String[] tokens(String s, String t){
        StringTokenizer st = new StringTokenizer(s,t);
        int count = st.countTokens();
        String[] tokens = new String[count];

        for(int i = 0; st.hasMoreTokens(); i++){
            tokens[i] = st.nextToken();
        }

        return tokens;


    }

}
