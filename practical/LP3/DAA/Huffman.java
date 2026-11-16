import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class Huffman {
    // Generate Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;
        // Leaf node contains a character
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.freq, b.freq));
        System.out.println("Enter character and frequency:");
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();
            pq.add(new Node(ch, freq));
        }
        // Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(
                    '\0',
                    left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        Node root = pq.poll();
        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
        sc.close();
    }
}

// Sample Input
// Enter number of characters: 6
// Enter character and frequency:
// A 5
// B 9
// C 12
// D 13
// E 16
// F 45
