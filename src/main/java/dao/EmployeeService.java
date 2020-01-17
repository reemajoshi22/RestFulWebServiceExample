package dao;

import domain.Employee;
import response.Response;

public interface EmployeeService {

	public Response addEmployee(Employee p);

	public Response deleteEmployee(int id);

	public Employee getEmployee(int id);

	public Employee[] getAllEmployees();
}