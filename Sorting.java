package lab04;

import java.util.*;

public class Sorting {


    public void mergeSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (lo+hi)/2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public void merge(int[] a,int lo, int mid, int hi){
        int [] aux = a.clone();
        int count = lo;
        int i = lo;
        int j = mid+1;
        while(i<=mid && j<=hi){
            if(aux[i]<aux[j]) {
                a[count] = aux[i];
                i++;
            } else {
                a[count] = aux[j];
                j++;
            }
            count++;
        }
        if(i<=mid) for(;i<=mid;i++,count++) a[count] = aux[i];
        else if(j<=hi) for(;j<=hi;j++,count++) a[count] = aux[j];
    }

    public void quickSort(int [] a, int lo, int pivot) {
        if(pivot<=lo) return;
        int j=lo;
        for(int i=lo;i<=pivot;i++) {
            if(a[i]<=a[pivot]) {
                swap(a,j,i);
                j++;
            }
        }
        quickSort(a,lo,j-2);
        quickSort(a,j,pivot);
    }

    public void swap(int [] a,int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}


