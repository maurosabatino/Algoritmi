/*
 * MergeSort.c
 *
 *  Created on: 14/dic/2013
 *      Author: Mauro
 */
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

#include "SortingAlgorithm.h"

	 void MSsort(int a[],int n) {
		 int aux [n];
		 mergeSort(a,0,n-1,aux);
	 }

	 void mergeSort(int a[],int first,int last,int b[]){
		if(first<last){
			int m =(first+last)/2;
			mergeSort(a,first,m,b);
			mergeSort(a,m+1,last,b);
			merge(a,first,m,last,b);
		}
	}

	 void merge(int a[],int fst,int mid,int lst,int c[]){
		int i=fst,j=mid+1,k=fst,h,r,l;
		while(i<=mid && j<=lst){
			if(a[i]<=a[j]) c[k++]=a[i++];
			else c[k++]=a[j++];
		}
		for(h= mid,l=lst;h>=i;) a[l--]=a[h--];
		for(r = fst;r<k;r++) a[r]=c[r];
	}
