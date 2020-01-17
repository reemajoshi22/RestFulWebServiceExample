package domain;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

//@Data
@ToString
@XmlRootElement(name="Employee")
public class Employee {
    int emp_id;

    int emp_age;

    String emp_first_name;

    String emp_last_name;

    String employee_dept;

    Float employee_salary;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_first_name() {
        return emp_first_name;
    }

    public void setEmp_first_name(String emp_first_name) {
        this.emp_first_name = emp_first_name;
    }

    public String getEmp_last_name() {
        return emp_last_name;
    }

    public void setEmp_last_name(String emp_last_name) {
        this.emp_last_name = emp_last_name;
    }

    public String getEmployee_dept() {
        return employee_dept;
    }

    public void setEmployee_dept(String employee_dept) {
        this.employee_dept = employee_dept;
    }

    public Float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Float employee_salary) {
        this.employee_salary = employee_salary;
    }
}
