class TextNode {
    String text;
    TextNode prev;
    TextNode next;

    TextNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {

    static TextNode head = null;
    static TextNode tail = null;
    static TextNode current = null;
    static int size = 0;
    static final int MAX_HISTORY = 10;

    // ================= ADD NEW STATE =================
    static void addState(String text) {

        TextNode newNode = new TextNode(text);

        // remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countSize();
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        // limit history
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // ================= UNDO =================
    static void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        displayCurrent();
    }

    // ================= REDO =================
    static void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        displayCurrent();
    }

    // ================= DISPLAY =================
    static void displayCurrent() {
        if (current == null) {
            System.out.println("Editor empty");
        } else {
            System.out.println("Current Text: \"" + current.text + "\"");
        }
    }

    // ================= HELPER =================
    static int countSize() {
        int count = 0;
        TextNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        addState("Hello");
        addState("Hello World");
        addState("Hello World!");
        addState("Hello World! Java");

        displayCurrent();

        System.out.println("\nUndo:");
        undo();

        System.out.println("\nUndo:");
        undo();

        System.out.println("\nRedo:");
        redo();

        System.out.println("\nNew typing (redo cleared):");
        addState("Hello Java Developer");
        displayCurrent();
        
        

        System.out.println("\nRedo:");
        redo();
    }
}
