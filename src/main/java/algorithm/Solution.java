package algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        remove(head,val);
        return head;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      @Override
        public String toString(){
          return String.valueOf(val);
      }
    }
    private void remove(ListNode pre,int val){
        if(pre == null){
            return;
        }
        if(pre.next == null){
            if(pre.val == val )pre = null;
            return;
        }

        if(pre.next.val == val){
            pre.next = pre.next.next;
            remove(pre,val);
        }else{
            remove(pre.next,val);
        }
    }

    public void setNull(ListNode node){
        node = null;
    }

    public void setDefault(ListNode node){
        node = new ListNode(100);
    }

    public void setNext(ListNode node){
        node.next = new ListNode(100);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1);
        //s.removeElements(node,1);
        System.out.println(node);
        s.setNull(node);
        System.out.println(node);
        s.setDefault(node);
        System.out.println(node);
        System.out.println(node.next);
        s.setNext(node);
        System.out.println(node.next);
    }
}