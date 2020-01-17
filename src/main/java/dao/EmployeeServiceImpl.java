package dao;

import domain.Employee;
import response.Response;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Path("/employee")
public class EmployeeServiceImpl implements EmployeeService{
    private static Map<Integer, Employee> employees = new HashMap<Integer,Employee>();

    @Override
    @Path("/add")
    @POST
    public Response addEmployee(Employee employee) {
        Response response = new Response();
        if(employees.get(employee.getEmp_id()) != null){
            response.setStatus(false);
            response.setMessage("Employee Already Exists");
            return response;
        }
        employees.put(employee.getEmp_id(), employee);
        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }

    @Override @Path("/{id}/delete")
    @DELETE
    public Response deleteEmployee(int id) {
        Response response = new Response();
        if(employees.get(id)==null)
        {
            response.setMessage("Employee does not exists ");
            response.setStatus(false);
        }
        employees.remove(id);
        response.setMessage("Employee deleted : "+id);
        response.setStatus(true);
        return response;
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Employee getEmployee(@PathParam("id")int id) {
        return employees.get(id);
    }

    @Override
    @Path("/{id}/getAll")
    public Employee[] getAllEmployees() {
        Set<Integer> ids = employees.keySet();
        Employee[] p = new Employee[ids.size()];
        int i=0;
        for(Integer id : ids){
            p[i] = employees.get(id);
            i++;
        }
        return p;
    }

}
