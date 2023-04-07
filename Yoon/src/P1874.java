/**
 *  Baekjoon 1874 : 스택 수열
 *  https://www.acmicpc.net/problem/1874
 */


import java.io.*;
import java.lang.StringBuilder;

public class P1874 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] stack = new int[n]; // 스택
		int top = -1; // 스택의 top을 가리키는 값
		int num = 1; // 스택에 넣을 수
		
		StringBuilder sb = new StringBuilder(); // answer
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			
			if(top == -1) { // 스택에 아무 값도 들어 있지 않을 때
				stack[++top] = num++; // push 
				sb.append("+\n"); // + 출력
			}
			
			while(k > stack[top]) { // 스택의 top 값이 k 값과 같아질 때까지 반복
				stack[++top] = num++; // push
				sb.append("+\n"); // + 출력
			}
			
			if(k == stack[top]) { // top값이 k 값과 같다면
				stack[top--] = 0; // pop
				sb.append("-\n"); // - 출력
			} else { // 같지 않다면 -> 불가능
				System.out.println("NO"); // NO 출력
				return; // 시스템 종료
			}
		}
		
		bw.write(sb.toString()); // result 출력
		
		br.close();
		bw.flush();
		bw.close();
	}
}
