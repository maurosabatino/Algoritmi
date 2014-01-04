/*
 * InsertionSort.c
 *
 *  Created on: 14/dic/2013
 *      Author: Mauro
 */
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

#include "SortingAlgorithm.h"

 void ISort(int a[],int n){
		int i;
		for(i=1;i<n;i++){
			int x = a[i];
			int j=i;
			while(j>0 && x<a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = x;
		}
 }
