package Nhn;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // input
    String input[] = br.readLine().split(" ");
    int size = toInteger(input[0]);
    int turnCnt = toInteger(input[1]);
    String map[][] = new String[size][size];

    for (int i = 0; i < size; i++) {
      map[i] = br.readLine().split(" ");
    }

    // logic
    if (size % 2 == 1) {
      // 홀수
      Point p = new Point(size / 2, size / 2); // 기준

      for (int n = size / 2 + 1; 2 * n - 1 >= 3; n--) {
        Deque<String> queue = new ArrayDeque<>();
        // 큐에 넣기

        // 위
        for (int j = p.y - (n - 1); j <= p.y + (n - 1); j++) {
          queue.add(map[p.x - (n - 1)][j]);
        }

        // 오
        for (int i = p.x - (n - 1) + 1; i <= p.x + (n - 1) - 1; i++) {
          queue.add(map[i][p.y + (n - 1)]);
        }

        // 아래
        for (int j = p.y + (n - 1); j >= p.y - (n - 1); j--) {
          queue.add(map[p.x + (n - 1)][j]);
        }

        // 왼
        for (int i = p.x + (n - 1) - 1; i >= p.x - (n - 1) + 1; i--) {
          queue.add(map[i][p.y - (n - 1)]);
        }

        // 회전
        turn(queue, turnCnt);
        turnCnt *= -1;

        // 다시 배열로

        // 위
        for (int j = p.y - (n - 1); j <= p.y + (n - 1); j++) {
          map[p.x - (n - 1)][j] = queue.removeFirst();
        }

        // 오
        for (int i = p.x - (n - 1) + 1; i <= p.x + (n - 1) - 1; i++) {
          map[i][p.y + (n - 1)] = queue.removeFirst();
        }

        // 아래
        for (int j = p.y + (n - 1); j >= p.y - (n - 1); j--) {
          map[p.x + (n - 1)][j] = queue.removeFirst();
        }

        // 왼
        for (int i = p.x + (n - 1) - 1; i >= p.x - (n - 1) + 1; i--) {
          map[i][p.y - (n - 1)] = queue.removeFirst();
        }

      }
    } else {
      // 짝수
      Point p = new Point(size / 2 - 1, size / 2 - 1); // 기준

      for (int n = size / 2; 2 * n >= 2; n--) {
        Deque<String> queue = new ArrayDeque<>();
        // 큐에 넣기

        // 위
        for (int j = p.y - (n - 1); j <= p.y + n; j++) {
          queue.add(map[p.x - (n - 1)][j]);
        }

        // 오
        for (int i = p.x - (n - 1) + 1; i <= p.x + (n - 1); i++) {
          queue.add(map[i][p.y + n]);
        }

        // 아래
        for (int j = p.y + n; j >= p.y - (n - 1); j--) {
          queue.add(map[p.x + n][j]);
        }

        // 왼
        for (int i = p.x + (n - 1); i >= p.x - (n - 1) + 1; i--) {
          queue.add(map[i][p.y - (n - 1)]);
        }

        // 회전
        turn(queue, turnCnt);
        turnCnt *= -1;

        // 다시 배열로
        // 위
        for (int j = p.y - (n - 1); j <= p.y + n; j++) {
          map[p.x - (n - 1)][j] = queue.removeFirst();
        }

        // 오
        for (int i = p.x - (n - 1) + 1; i <= p.x + (n - 1); i++) {
          map[i][p.y + n] = queue.removeFirst();
        }

        // 아래
        for (int j = p.y + n; j >= p.y - (n - 1); j--) {
          map[p.x + n][j] = queue.removeFirst();
        }

        // 왼
        for (int i = p.x + (n - 1); i >= p.x - (n - 1) + 1; i--) {
          map[i][p.y - (n - 1)] = queue.removeFirst();
        }
      }
    }

    // output
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(map[i][j]);
        if (j != size - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  private static void turn(Deque<String> queue, int turnCnt) {
    for (int i = 0; i < Math.abs(turnCnt); i++) {
      if (turnCnt >= 0) {
        queue.addFirst(queue.removeLast());
      } else {
        queue.addLast(queue.removeFirst());
      }
    }
  }

  public static int toInteger(String input) {
    return Integer.parseInt(input);
  }
}