import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Num = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] list = new int[Num];

        for(int i = 0; i < Num; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(StackSort(list));
    }

    public static String StackSort(int[] list) {

        Stack<Integer> stack = new Stack<>();

        int count = 1;

        for(int i = 0 ; i < list.length; i++) {

            if(count == list[i]) {
                count++;
            }
            else if (!stack.empty() && stack.peek() == count) {
                i--;
                stack.pop();
                count ++;
            }
            else{
                stack.push(list[i]);
            }
        }
        while(!stack.empty()) {
            if(stack.peek() == count) {
                stack.pop();
                count++;
            }
            else {
                stack.pop();
            }
        }
        if(count -1 == list.length) {
            return "Nice";
        }
        else return "Sad";
    }
}