import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Deque<String> queue = new Deque<>();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()) {
            String item = (String) scanner.next();
            if (!item.equals("-"))
                queue.addFirst(item);
            else if (!queue.isEmpty())
                System.out.print(queue.removeFirst() + " ");
        }
        System.out.println("(" + queue.size() + " left on queue)");
    }
}
