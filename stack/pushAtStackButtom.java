import java.util.Stack;

public class PushAtBottom {
    // Function to push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> stack, int x) {
        // Base case: If stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursive call to reach the bottom
        pushAtBottom(stack, x);

        // Step 3: Push the popped element back
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some elements into the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack);

        // Push an element at the bottom
        int elementToPush = 5;
        pushAtBottom(stack, elementToPush);

        System.out.println("Stack after pushing " + elementToPush + " at the bottom: " + stack);
    }
}
