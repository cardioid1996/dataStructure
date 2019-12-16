package algorithms.recurse;

public class AllSubsequence {
    public static void AllSubsequence(String curr, String str, int pos){
        if(pos == str.length()){
            System.out.println(curr);
            return;
        }
        AllSubsequence(curr, str, pos+1);
        AllSubsequence(curr+ String.valueOf(str.charAt(pos)), str, pos+1);
    }

    public static void main(String[] args) {
        String str = "abc";
        AllSubsequence.AllSubsequence("", str, 0);
    }
}
