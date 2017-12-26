/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */

    static public void main(String []args){

        Solution s = new Solution();
        String a = "1->2";
        String [] values = a.split("->");
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode cur = head;
        for(int i = 1 ; i < values.length; i++){
            ListNode node = new ListNode(Integer.parseInt(values[i]));
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        s.printNode(head);
        ListNode newList = s.sortList(head);
        s.printNode(newList);
    }


    public void printNode(ListNode node){

        System.out.print(node.val);
        node = node.next;
        while(node != null){
            System.out.print("->"+node.val);
            node = node.next;
        }
        System.out.println();
    }


    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode head2 = sortList(mid.next);

        mid.next = null;

        ListNode head1 = sortList(head);

        return merge(head1,head2);

    }


    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2){

        ListNode tail = new ListNode(0);
        ListNode dummy = tail;

        while(head1 != null && head2 != null){

            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if(head1 == null){
            tail.next = head2;
        }
        if(head2 == null){
            tail.next = head1;
        }
        return dummy.next;
    }

}