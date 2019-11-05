package StructuralDesignPattern.CompositeDesignPattern



fun main() {
    var dev1 = Developer("Name 1", 100, "Pro Developer")
    var dev2 = Developer(empId = 101, position = "Jr Developer", name = "Name 2")

    var softDirectory = CompanyDirectory()

    softDirectory.addEmployee(dev1)
    softDirectory.addEmployee(dev2)


    var manager1 = Manager("Name 11", 200, "Business Manager")
    var manager2 = Manager(empId = 201, position = "Accounting Manager", name = "Name 22")

    var managerDirectory = CompanyDirectory()

    managerDirectory.addEmployee(manager1)
    managerDirectory.addEmployee(manager2)

    var directory = CompanyDirectory()
    directory.addEmployee(softDirectory)
    directory.addEmployee(managerDirectory)


    directory.showEmployeeDetails()
}