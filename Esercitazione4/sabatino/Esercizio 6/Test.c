/*
 * Test.c
 *
 *  Created on: 14/dic/2013
 *      Author: Mauro
 */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

#include "SortingAlgorithm.h"

#define N 2000001
#define STEP 100000

int ar[N];
int arCopia[N];


void fillArray(int a[], int n, int max) {
    srand(time(NULL));
    int i;
    for(i = 0; i < n; i++) a[i] = rand()%max;
  }

void copiaArray(int a[], int b[], int n) {
	int i;
	for(i=0; i<n; i++) b[i] = a[i];
  }

int sorted(int a[], int n) {
 	int i;
	for(i = 1; i < n; i++) if(a[i-1] > a[i]) return 0;
	return 1;
 }

main(){
	int n;
	for(n = STEP; n < N; n += STEP) {
		fillArray(ar, n, 9*n/10);
		copiaArray(ar, arCopia, n);
		printf("%s\n", sorted(arCopia, n) ? "ordinato" : "non ordinato");
		QSort(arCopia,n);
		printf("%s\n", sorted(arCopia, n) ? "ordinato" : "non ordinato");
	}
	return 0;
}

