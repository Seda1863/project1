/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author casper
 */
public class StackArray {

    String data[]; // array to hold items
    int top; // the top most item index

    public StackArray(int N) {
        data = new String[N];
        top = -1;
    }

    public void push(String element) {
        if (!isFull()) {
            top++;
            data[top] = element;
        }
    }

    public String pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            top--;
            return data[top + 1];
        }
    }

    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == - 1) {
            return true;
        }
        return false;
    }

    public void PrintStack() {
        if (isEmpty()) {
            return;
        }
        String x = pop();
        PrintStack();
        System.out.print(x + " ");
        push(x);
    }

    public boolean checkPal() {
        if ((top+1) % 2 != 0) {
            System.out.println("2 nin katı değil " +(top + 1));
            return false;
        }
        StackArray s1 = new StackArray(top / 2);
        StackArray s2 = new StackArray(top / 2);
        for (int i = 0; i <= top / 2; i++) {
            System.out.println("data: " + i + " " + data[i]);
            s1.push(data[i]);       
        }
        for (int i = top ; i <= (top/2); i--) {
            s2.push(data[i]);
        }
        
        s1.PrintStack();
        s2.PrintStack();
        
        boolean palindrome = true;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            String i1 = s1.pop();
            String i2 = s2.pop();
            if (i1 != i2) {
                palindrome = false;
                break;
            }

        }
        return palindrome;
    }

  public void deleteMiddle(){
      if(!isEmpty()){
         int size = top+1;
         if(size%2==0){
             System.out.println("There is no middle element as the size of stack is even.");
             return;
         }
         
         int middle = (int) size/2;
         StackArray tempList = new StackArray(top);
         for (int i = top; i > -1; i--) {
              if(data[i].equals(data[middle])){
                  this.pop();
                  break;
              }
              
              String name = this.pop();
              tempList.push(name);
         }
         
        for (int i = tempList.top; i > -1; i--) {
              this.push(tempList.pop());
        }
      }
  }
}

class main{
    public static void main(String[] args) {
        StackArray a = null;
        Scanner input = new Scanner(System.in);

        boolean quit = false;
            
        
        do{
            System.out.println("\n1- push\n"
                    + "2- pop\n"
                    + "3- Print\n"
                    + "4- Delete middle\n"
                    + "5- isPalindrome");
            System.out.println("Please enter a digit (1-5)");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("How many pushes you want to do?");
                    int m = input.nextInt();
                    System.out.println("Enter" + "  " + m + "  Strings");
                    a = new StackArray(m);

                    while (m != 0) {
                        String name = input.next();
                        a.push(name);
                        m--;
                    }
                    break;
                case 2:
                    String d = a.pop();
                    System.out.println(d + " removen");
                    break;
                case 3:
                    System.out.println("The content of stack is:");
                    a.PrintStack();
                    break;
                case 4:
                    a.deleteMiddle();
                    break;
                case 5:
                    if(a.checkPal()){
                        System.out.println("The stack is palindrome."); 
                    }else{
                        System.out.println("The stack is not palindrome.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;

            }

        }while(!quit);
    }
}
