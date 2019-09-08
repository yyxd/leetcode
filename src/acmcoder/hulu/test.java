//package acmcoder.hulu;
//
///**
// * Created by Diane on 2019-09-05.
// * Goal:
// */
//public class test {
//    #include<iostream>
//#include<stdlib.h>
//#include<vector>
//    using namespace
//    std;
//
//    class Solution {
//        public:
//
//        int splitArray(vector<int>&nums, int m) {
//            int size = nums.size();
//            long long *arr = ( long long*)malloc(sizeof( long long) *m * size);
//            long long sum = 0;
//
//            for (int i = 0; i < size; i++) {
//                sum += nums[i];
//                arr[i] = sum;
//            }
//
//            for (int i = 1; i < m; i++) {
//                for (int j = size - 1; j >= i; j--) {
//                    sum = 0;
//                    arr[i * size + j] = 2147483999;
//                    for (int k = j; k >= i; k--) {
//                        sum += nums[k];
//                        long long temp = (sum < arr[(i - 1) * size + k - 1]) ? arr[(i - 1) * size + k - 1] : sum;
//                        if (arr[i * size + j] > temp) arr[i * size + j] = temp;
//                    }
//                }
//            }
//
//            int result = arr[size * m - 1];
//            free(arr);
//            return result;
//        }
//    }
//}
