import 'dart:io';

void main() {
  print("Enter the number: ");
  int n = int.parse(stdin.readLineSync()!);

  print("Fibonaci sequence if $n numbers: ");
  for (int i = 0; i < n; i++) {
    print(fibonaci(i));
  }
  print("Fibonaci number at index n $n: ${fibonaci(n)}");
}

int fibonaci(int n) {
  if (n <= 0) return 0;
  if (n == 1) return 1;
  return fibonaci(n - 1) + fibonaci(n - 2);
}
