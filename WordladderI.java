import java.util.*;
class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class WordladderI{
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st = new HashSet<>();
        int len = wordList.length;
        for(int i = 0; i < len; i++){
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(targetWord) == true){
                return steps;
            }
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startWord = sc.nextLine();
        String targetWord = sc.nextLine();
        int n = sc.nextInt();
        String[] wordList = new String[n];
        for(int i = 0; i < n; i++){
            wordList[i] = sc.nextLine();
        }
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }
}