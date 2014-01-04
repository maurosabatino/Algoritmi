/*
 * quickSort.c
 *
 *  Created on: 14/dic/2013
 *      Author: Mauro
 */
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

#include "SortingAlgorithm.h"

	void QSort(int a[],int n){
		QuickSortMidToExamine(a,0,n-1);
	}

	void QuickSortMidToExamine(int a[],int inf, int sup){
		if(inf>=sup) return;
		int p = QuickSortMidToExaminePartition(a,inf,sup);
		QuickSortMidToExamine(a,inf,p-1);
		QuickSortMidToExamine(a,p+1,sup);
	}
	int QuickSortMidToExaminePartition(int a[],int inf, int sup){
		int pivot = a[inf];
		int i = inf+1;
		int j = sup;
		while(i<=j){
			if(a[i]<pivot)	i++;
			else scambia(a,i,j--);
		}
		scambia(a,inf,j);
		return j ;
	}

	 void scambia(int a[],int i,int j){
			int x=a[i];
			a[i]=a[j];
			a[j]=x;
		}
