package BigNumberTemplate;

import java.util.Scanner;
import java.util.Stack;

public class BigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] A = scanner.next().toCharArray();
        String operate = scanner.next();
        char[] B = scanner.next().toCharArray();
        switch (operate){
            case "+":{
                String res = Add(A,B);
                System.out.println(res);
                break;
            }
            case "-":{
                String res = Sub(A,B);
                System.out.println(res);
                break;
            }
            case "*":{
                String res = Mul(A,B);
                System.out.println(res);
                break;
            }
            case "/":{
                String res = Div(A,B);
                System.out.println(res);
                break;
            }
        }

    }

    private static Stack<Character> stackA = new Stack<Character>();
    private static Stack<Character> stackB = new Stack<Character>();

    /**
     * 高精度加法
     * 模拟加法，从低位相加
     * @param A
     * @param B
     * @return
     */
    public static String Add(char[] A,char[] B){
        if(A.length < B.length) return Add(B,A);
        for (char a:A) stackA.push(a);
        for (char b:B) stackB.push(b);
        int f = 0;
        String res = "";
        while(!stackA.isEmpty()){
            f += Integer.parseInt(String.valueOf(stackA.pop()));
            if(!stackB.isEmpty())   f += Integer.parseInt(String.valueOf(stackB.pop()));
            res =String.valueOf(f%10) + res;
            f /= 10;
        }
        if(f > 0)   res = f + res;
        return res;
    }

    /**
     * 高精度减法
     * @param A
     * @param B
     * @return
     */
    public static String Sub(char[] A,char[] B){
        if(A.length < B.length) return "-"+Add(B,A);
        int y = A.length-B.length;
        for(int i = 0;i < A.length && y==0;i++) {
            if (A[i] - B[i] < 0) return "-" + Add(B, A);
        }
        for (char a:A) stackA.push(a);
        for (char b:B) stackB.push(b);
        int f = 0;
        String res = "";
        while(!stackA.isEmpty()){
            f = Integer.parseInt(String.valueOf(stackA.pop())) - f;
            if(!stackB.isEmpty())   f -= Integer.parseInt(String.valueOf(stackB.pop()));
            res =String.valueOf((f+10)%10) + res;
            if(f<0) f = 1;
            else    f = 0;
        }
        while (res.startsWith("0") && res.length() > 1)  res = res.substring(1);
        return res;
    }

    /**
     * 高精度 乘 低精度
     * @param A
     * @param B
     * @return
     */
    public static String Mul(char[] A,char[] B){
        if(A.length < B.length) return Add(B,A);
        for (char a:A) stackA.push(a);
        int numB = Integer.parseInt(String.valueOf(B));
        int f = 0;
        String res = "";
        while(!stackA.isEmpty()){
            f += Integer.parseInt(String.valueOf(stackA.pop()))*numB;
            res =String.valueOf(f%10) + res;
            f /= 10;
        }
        if(f > 0)   res = f + res;
        while (res.startsWith("0") && res.length() > 1)  res = res.substring(1);
        return res;
    }

    /**
     * 高精度 除以 低精度
     * @param A
     * @param B
     * @return
     */
    public static String Div(char[] A,char[] B){
        if(A.length < B.length) return Add(B,A);
        int numB = Integer.parseInt(String.valueOf(B));
        int f = 0;
        String res = "";
        for(int i = 0;i<A.length;i++){
            f = f*10 + Integer.parseInt(String.valueOf(A[i]));
            res += f/numB;
            f %= numB;
        }
        while (res.startsWith("0") && res.length() > 1)  res = res.substring(1);
        return res;
    }
}
