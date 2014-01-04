/*
 * SelectionSort.c
 *
 *  Created on: 14/dic/2013
 *      Author: Mauro
 */
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

#include "SortingAlgorithm.h"

void SSort(int a[],int n){
		int i,j;
		for(i = 0;i<n-1;i++){
			int iMin = i;
			for(j=i+1;j<n;j++){
				if(a[j]<a[iMin])iMin=j;
				scambia(a,i,iMin);
			}
		}
	}
	 void scambia(int a[],int i,int j){
		int x=a[i];
		a[i]=a[j];
		a[j]=x;
	}

