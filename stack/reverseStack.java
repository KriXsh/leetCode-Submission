import java.util.Stack;

public class ReverseStack {
    // Function to reverse a stack
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // Base case: If stack is empty, return
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively reverse the remaining stack
        reverseStack(stack);

        // Step 3: Insert the popped element at the bottom of the reversed stack
        insertAtBottom(stack, top);
    }

    // Function to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x); // Base case: If stack is empty, push the element
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively insert the element at the bottom
        insertAtBottom(stack, x);

        // Step 3: Push the top element back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        // Reverse the stack
        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
