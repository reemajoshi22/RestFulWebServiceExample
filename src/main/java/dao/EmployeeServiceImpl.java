package dao;

import domain.Employee;
import response.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Path("/employee")
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    @Path("/add")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addEmployee(Employee employee) {
       /* try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print JSON String to Console
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(employee, sw);
            System.out.println(sw.toString());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }*/
        Response response = new Response();
        if (employees.get(employee.getEmp_id()) != null) {
            response.setStatus(false);
            response.setMessage("Employee Already Exists");
            return response;
        }
        employees.put(employee.getEmp_id(), employee);
        response.setStatus(true);
        response.setMessage("Person created successfully");
        return response;
    }

    @Path("/{id}/delete")
    @DELETE
    public Response deleteEmployee(int id) {
        Response response = new Response();
        if (employees.get(id) == null) {
            response.setMessage("Employee does not exists ");
            response.setStatus(false);
        }
        employees.remove(id);
        response.setMessage("Employee deleted : " + id);
        response.setStatus(true);
        return response;
    }

    @GET
    @Path("/{id}/get")
    public Employee getEmployee(@PathParam("id") int id) {
        return employees.get(id);
    }

    @Path("/{id}/getAll")
    public Employee[] getAllEmployees() {
        Set<Integer> ids = employees.keySet();
        Employee[] p = new Employee[ids.size()];
        int i = 0;
        for (Integer id : ids) {
            p[i] = employees.get(id);
            i++;
        }
        return p;
    }

}
