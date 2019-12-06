package com.ds.algorithms;


public class GetNumOfKInArray {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length==0)
            return 0;
        if (k<array[0] || k>array[array.length-1])
            return 0;
        int first = binary_left(array, 0, array.length-1, k);
        System.out.println("first index: "+first);
        if (first == -1)
            return 0;
        int last = binary_right(array, 0, array.length-1, k);
        System.out.println("last index: "+last);
        return last-first+1;

    }


    public int binary_left(int[] a, int l, int r, int k){
        if (l > r)
            return -1;
        else if (l == r){
            if (a[l] == k && l==0)
                return l;
            else if (a[l] == k && l-1>=0 && a[l-1]!=k)
                return l;
            else
                return -1;
        }
        else{
            // l<r
            int mid = l + (r-l)/2;

            if (a[mid] > k)
                return binary_left(a, l, mid-1, k);

            else if (a[mid] < k)
                return binary_left(a, mid+1, r, k);
            else{
                // a[mid] == k
                if ((mid-1>=0 && a[mid-1]!=k) || mid==0)
                    return mid;
                else
                    return binary_left(a, l, mid-1, k);
            }
        }
    }

    public int binary_right(int[] a, int l, int r, int k){
        if (l > r)
            return -1;
        else if (l == r){
            if (a[l] == k && l+1<=a.length-1 && a[l+1]!=k)
                return l;
            else if (a[l]==k && l==a.length-1)
                return l;
            else
                return -1;
        }
        else{
            // l<r
            int mid = l + (r-l)/2;

            if (a[mid] > k)
                return binary_right(a, l, mid-1, k);

            else if (a[mid] < k)
                return binary_right(a, mid+1, r, k);
            else{
                // a[mid] == k
                if ((mid+1<a.length && a[mid+1]!=k) || mid==a.length-1)
                    return mid;
                else
                    return binary_right(a, mid+1, r, k);
            }
        }
    }

    public static void main(String[] args) {
        GetNumOfKInArray g = new GetNumOfKInArray();
        int[] a = {1,2,3,3,3,4};
        int res = g.GetNumberOfK(a, 3);
        System.out.println(res);
    }

}