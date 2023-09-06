int binarySearch(List<int> sortedList, int target) {
  int left = 0;
  int right = sortedList.length - 1;

  while (left <= right) {
    int mid = (left + right) ~/ 2; // Tìm giữa của dãy

    if (sortedList[mid] == target) {
      return mid; // Trả về vị trí của giá trị nếu tìm thấy
    } else if (sortedList[mid] < target) {
      left = mid + 1; // Di chuyển left nếu giá trị ở giữa nhỏ hơn giá trị cần tìm
    } else {
      right = mid - 1; // Di chuyển right nếu giá trị ở giữa lớn hơn giá trị cần tìm
    }
  }

  return -1; // Trả về -1 nếu không tìm thấy giá trị trong danh sách
}

void main() {
  List<int> sortedList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  int target = 6;
  
  int result = binarySearch(sortedList, target);
  
  if (result != -1) {
    print("Giá trị $target được tìm thấy tại vị trí $result trong danh sách.");
  } else {
    print("Không tìm thấy giá trị $target trong danh sách.");
  }
}