import 'dart:io';

class Employee {
  int id;
  String fullName;
  DateTime birthday;
  String address;
  String phoneNumber;

  Employee(this.id, this.fullName, this.birthday, this.address, this.phoneNumber);
}

class Company {
  List<Employee> employees = [];

  void addNewEmployee() {
    stdout.write('Enter employee ID: ');
    int id = int.parse(stdin.readLineSync()!);

    stdout.write('Enter employee full name: ');
    String fullName = stdin.readLineSync()!;

    stdout.write('Enter employee birthday (YYYY-MM-DD): ');
    DateTime birthday = DateTime.parse(stdin.readLineSync()!);

    stdout.write('Enter employee address: ');
    String address = stdin.readLineSync()!;

    stdout.write('Enter employee phone number: ');
    String phoneNumber = stdin.readLineSync()!;

    Employee employee = Employee(id, fullName, birthday, address, phoneNumber);
    employees.add(employee);

    print('Employee added successfully!');
  }

  void getAllEmployees() {
    if (employees.isEmpty) {
      print('No employees found.');
      return;
    }

    for (var employee in employees) {
      print('Id: ${employee.id}');
      print('Full Name: ${employee.fullName}');
      print('Birthday: ${employee.birthday}');
      print('Address: ${employee.address}');
      print('Phone Number: ${employee.phoneNumber}');
      print('----------------------');
    }
  }

  void updateEmployee() {
    if (employees.isEmpty) {
      print('No employees found.');
      return;
    }

    stdout.write('Enter the ID of the employee to update: ');
    int id = int.parse(stdin.readLineSync()!);

    int employeeIndex = employees.indexWhere((employee) => employee.id == id);
    if (employeeIndex == -1) {
      print('Employee not found.');
      return;
    }

    Employee employeeToUpdate = employees[employeeIndex];

    stdout.write('Enter new full name: ');
    String fullName = stdin.readLineSync()!;

    stdout.write('Enter new birthday (YYYY-MM-DD): ');
    DateTime birthday = DateTime.parse(stdin.readLineSync()!);

    stdout.write('Enter new address: ');
    String address = stdin.readLineSync()!;

    stdout.write('Enter new phone number: ');
    String phoneNumber = stdin.readLineSync()!;

    Employee updatedEmployee = Employee(id, fullName, birthday, address, phoneNumber);
    employees[employeeIndex] = updatedEmployee;

    print('Employee updated successfully!');
  }

  void showAllEmployees() {
    if (employees.isEmpty) {
      print('No employees found.');
      return;
    }

    for (var employee in employees) {
      print('Id: ${employee.id}');
      print('Full Name: ${employee.fullName}');
      print('Birthday: ${employee.birthday}');
      print('Address: ${employee.address}');
      print('Phone Number: ${employee.phoneNumber}');
      print('----------------------');
    }
  }
}

void main() {
  Company company = Company();
  bool exit = false;

  while (!exit) {
    print('----------------------');
    print('1. Add new employee');
    print('2. Get all employees');
    print('3. Update an employee');
    print('4. Show all employees');
    print('5. Exit');
    print('----------------------');
    stdout.write('Enter your choice: ');

    String? choice = stdin.readLineSync();
    switch (choice) {
      case '1':
        company.addNewEmployee();
        break;
      case '2':
        company.getAllEmployees();
        break;
      case '3':
        company.updateEmployee();
        break;
      case '4':
        company.showAllEmployees();
        break;
      case '5':
        exit = true;
        break;
      default:
        print('Invalid choice. Please try again.');
    }
  }
}