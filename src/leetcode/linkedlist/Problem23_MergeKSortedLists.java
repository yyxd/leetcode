package leetcode.linkedlist;

/**
 * Created by Diane on 2019/2/5.
 * Goal:
 */
public class Problem23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode ans = lists[0];
        for(int i = 1;i<lists.length;i++){
            ans = merge2Lists(ans,lists[i]);
        }
        return ans;
    }

    public ListNode merge2Lists(ListNode list1,ListNode list2){
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                res.next = list1;
                list1 = list1.next;
            }else{
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        res.next = list1!=null?list1:list2;
        return ans.next;
    }


}
