import java.util.ArrayList; //리스트를 동적으로 한몸같은 친구!
import java.util.List;  //리스트
import java.util.Scanner; //스캐너!

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>(); // 위 ArrayList 객체와 연동
        int index = 0; // 연산결과를 추척,저장

        while (true) { //반복문 while을 통해 무한 루프~~!
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0); //한줄 가져오기

            int result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요.");
                    continue;
            }

            results.add(result); //add로 추가기능
            index++; // 인덱스의 양을 늘려 반복문 종료

            if (index > 10) {   //연산결과 > 10 까지
                results.remove(0);

                System.out.println("결과: " + result);
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
                String input = sc.nextLine();

                if (input.equals("exit")) {
                    break;
                } else if (input.equals("remove")) {
                    if (results.isEmpty()) {
                        System.out.println("저장된 연산 결과가 없습니다.");
                    } else {
                        System.out.println("가장 먼저 저장된 연산 결과 " + results.remove(0) + "가 삭제되었습니다.");
                    }
                } else if (input.equals("inquiry")) {
                    System.out.println("저장된 연산 결과:");
                    for (int res : results) {
                        System.out.println(res);
                    }
                }
            }
        }
    }
}