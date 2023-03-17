import java.util.Scanner;
// todo: Create a Linked List and check if the Linked List is a Palindrome or Not...
//! Linked List Data Structure Class created...
public class Palindrome
{
    //! Node Structure Class created...
    public class Node
    {
        //* Data members... */
        public int data;
        public Node next;
        public Node prev;
        public Node(int val)       // Parametrized Constructor...
        {
            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }
    //! Head Pointer created...
    Node head;

    //? function  to Insert Node in Linked List... O(n) time...
    public void InsertNode(int value)
    {
        Node n = new Node(value);
        if (head == null)
        {
            head = n;
            n.next = null;
            n.prev = null;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = n;
        n.prev = temp;
        n.next = null;
        return;
    }

    //? function to Print the Linked List... O(n) time...
    public void PrintList()
    {
        Node temp = head;
        System.out.print(" null <- ");
        while(temp.next != null)
        {
            System.out.print(temp.data+" -><- ");
            temp = temp.next;
        }
        System.out.println(temp.data+" -> null");
        return;
    }

    //? function to check if the Linked List is a Palindrome or Not... O(n) time...
    public boolean PalindromeList()
    {
        Node temp = head;       // Two Temporary pointers created...
        Node temp1 = head;
        //* We move one of the pointer to the other end of the Linked List by Traversal...*/
        while(temp1.next != null)    
            temp1 = temp1.next;
        //* Now we move one pointer forward and other pointer backward, simultaneously checking the data... If in entire sequence the data of the two pointers is same the Linked List is a Palindrome... */
        while(temp.next != null)
        {
            if (temp.data != temp1.data)     // If the two pointers have different data...
                return false;    // Linked List is not a Palindrome...
            temp = temp.next;
            temp1 = temp1.prev;
        }
        return true;          // Linked List is a Palindrome...
    }

    //! Main function begins...
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);                   // Scanner class object defined...
        Palindrome linkedlist = new Palindrome();              // Palindrome class object defined...
        int x, a;
        System.out.print("Enter the number of Nodes to Insert : ");
        a = sc.nextInt();
        for(int i = 0; i < a; i++)
        {
            System.out.print("Enter the Node data : ");
            x = sc.nextInt();
            linkedlist.InsertNode(x);
        }
        linkedlist.PrintList();
        boolean ans = linkedlist.PalindromeList();     // Function call to check if Palindrome...
        if (ans == true)
            System.out.println("The Linked List is a Palindrome !!");
        else
            System.out.println("The Linked List is not a Palindrome !!");
        sc.close();        // Scanner class closed...
    }
}