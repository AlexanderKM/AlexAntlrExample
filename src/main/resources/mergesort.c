
#include <stdio.h>
#include <stdlib.h>


void merge(int *A, int *L, int leftCount, int *R, int rightCount);
int* mergeSort(int list[], int size);

int main(void) {

  int size = 10;
  int list[] = {5,6,7,4,3,8,9,0,1,2};

  mergeSort(list, size);

  int i = 0;
  for(i = 0; i < size; i++) {
    printf("%d ", list[i]);
  }
  printf("\n");

  return 0;

}

int* mergeSort(int list[], int size) {
  if (size < 2) {
    return list;
  }

  int mid = size / 2;
  int* left;
  int* right;

  left = (int*)malloc(mid * sizeof(int));
  right = (int*)malloc((size - mid) * sizeof(int));

  int leftIndex = 0;
  int rightIndex = 0;
  int i = 0;
  while (leftIndex < mid) {
    left[leftIndex] = list[i];
    leftIndex++;
    i++;
  }
  while (i < size) {
    right[rightIndex] = list[i];
    rightIndex++;
    i++;
  }

  mergeSort(left, mid);
  mergeSort(right, size - mid);
  merge(list, left, mid, right, size - mid);
  free(left);
  free(right);


}

void merge(int *A, int *L, int leftCount, int *R, int rightCount) {
  int i = 0;
  int j = 0;
  int k = 0;

  while (i < leftCount && j < rightCount) {
    if (L[i] < R[j]) {
      A[k] = L[i];
      k++;
      i++;
    }
    else {
      A[k] = R[j];
      k++;
      j++;
    }
  }
  while (i < leftCount) {
    A[k] = L[i];
    k++;
    i++;
  }
  while (j < rightCount) {
    A[k] = R[j];
    k++;
    j++;
  }

}
