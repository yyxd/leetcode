package acmcoder.xiecheng;

/**
 * Created by Diane on 2019-09-04.
 * Goal:
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        ListNode soldier = new ListNode(-1);
        ListNode lowSoldier = new ListNode(-1);
        ListNode low = lowSoldier;
        soldier.next = head;
        ListNode pre = soldier;
        while (head!=null){
            if(head.val<=m){
                low.next = head;
                low = low.next;
                pre.next = head.next;
            }else {
                pre = head;
            }
            head = head.next;
        }
        low.next = soldier.next;
        return lowSoldier.next;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}

