package algorithms.LinkedList;

/**
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
* 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
**/


public class DeleteDuplicate {

    public ListNode deleteDuplication(ListNode head)
    {
        if(head==null || head.next == null )
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode last = head;
        while (last != null){
            if((last.next == null) || last.next.val != last.val){
                pre = pre.next;
                last = last.next;
            }else{
                while(last.next != null && last.next.val == last.val)
                    last = last.next;
                pre.next = last.next;
                last = last.next;
            }
        }
        return h.next;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
