package StructuralDesignPattern.CompositeDesignPattern

// leaf
class Developer : Employee {

    private var name: String? = null
    private var empId: Long? = null
    private var position: String? = null

    constructor(name: String, empId: Long, position: String) {
        this.name = name
        this.empId = empId
        this.position = position
    }

    override fun showEmployeeDetails() {
        println("$empId  -  $name")
    }
}