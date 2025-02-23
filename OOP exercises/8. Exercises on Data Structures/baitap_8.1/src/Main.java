public class Main {
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(5);

        System.out.println("Stack is empty: " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek top element: " + stack.peek());

        System.out.println("Pop element: " + stack.pop());
        System.out.println("Peek top element after pop: " + stack.peek());

        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Stack is full: " + stack.isFull());

        while (!stack.isEmpty()) {
            System.out.println("Pop element: " + stack.pop());
        }

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}

