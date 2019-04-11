package class3_Queue_Stack_And_LinkedList;

import java.util.LinkedList;

/**
 *
 * Java: Implement a queue by using two stacks. The queue should provide size(),
 * isEmpty(), offer(), poll() and peek() operations. When the queue is empty,
 * poll() and peek() should return null.
 *
 * Assumptions
 *    The elements in the queue are all Integers.
 *    size() should return the number of elements buffered in the queue.
 *    isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 *
 **/

public class laicode_Queue_By_Two_Stacks {

  // Using Two stacks to implement one queue

  // in stack is for offer operations
  private LinkedList<Integer> in;
  // out stack is for peek and poll operations
  private LinkedList<Integer> out;

  // Initialize in and out stacks
  public laicode_Queue_By_Two_Stacks() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }

  public Integer poll() {
    // if out stack is empty, move all elements from in stack to out stack
    inToOut();
    // Poll element from out stack and return, if out stack is empty, return null
    return out.pollLast();//pollLast()获取并删除最后一个元素
  }


  public void offer(int element) {
    // offer element into in stack
    in.offerLast(element);//offerLast()将元素添加到最后的位置
  }

  public Integer peek() {
    // if out stack is empty, move all elements from in stack to out stack
    inToOut();
    // return out stack's peek, if empty, return null
    return out.peekLast();//peekLast()获取最后一个元素，不删除
  }

  public int size() {
    return in.size() + out.size();
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }

  // Move all elements from in stack to out stack if needed
  private void inToOut() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerLast(in.pollLast());
      }
    }
  }

}