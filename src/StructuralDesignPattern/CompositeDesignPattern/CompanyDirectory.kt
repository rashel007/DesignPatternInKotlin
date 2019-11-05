package StructuralDesignPattern.CompositeDesignPattern

// Composite
class CompanyDirectory : Employee {

    private var employeeList = ArrayList<Employee>()

    override fun showEmployeeDetails() {
        for (emp in employeeList){
            emp.showEmployeeDetails()
        }
    }

    fun addEmployee(emp: Employee){
        employeeList.add(emp)
    }

    fun remveEmployee(emp: Employee){
        employeeList.remove(emp)
    }

}