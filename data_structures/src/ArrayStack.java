public class ArrayStack<T> {
    private Object[] stackData;
    private int length, capacity;

    public ArrayStack() {
        this.length = 0;
        this.capacity = 1;
        this.stackData = new Object[1];
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.length + 1) >= this.capacity) {
            // Make a new array double the capacity of the previous.
            Object[] tempArray = new Object[this.stackData.length * 2];

            // Copy over elements to the new array.
            for (int i = 0; i < this.stackData.length; i++) {
                tempArray[i] = this.stackData[i];
            }

            // Overwrite the old array with the temporary array.
            this.stackData = tempArray;
            this.capacity = this.stackData.length;
        }
    }

    // Inserts a value to the top of the stack.
    public void push(T value) {
        if (this.length != 0) {
            this.resize();

            for (int i = this.length - 1; i >= 0; i--) {
                this.stackData[i + 1] = this.stackData[i];
            }
            this.stackData[0] = value;
            this.length++;
        } else {
            this.stackData[0] = value;
            this.length++;
        }
    }

    // Get the top value from the stack.
    public T pop() {
        T out = (T) this.stackData[0];

        for (int i = 1; i < this.length; i++) {
            this.stackData[i - 1] = this.stackData[i];
        }
        this.length --;
        return out;
    }

    // View the top element in the stack.
    public T top() {
        return (T) this.stackData[0];
    }

    // Check to see if the stack is empty.
    public boolean isEmpty() {
        if (this.stackData[0] == null) {
            return true;
        } else {
            return false;
        }
    }

    // Getter for the stack size.
    public int getSize() {
        return this.length;
    }

    // Stack toString() for output.
    public String toString() {
        String out = "[";

        for (int i = 0; i < this.length; i++) {
            if (this.stackData[i] == null) {
                break;
            }
            out += " " + this.stackData[i].toString();
        }
        return out + " ]";
    }
}
