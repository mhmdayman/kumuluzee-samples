package com.kumuluz.ee.samples.swagger.v1;

import com.kumuluz.ee.samples.swagger.v1.Customer;
import com.kumuluz.ee.security.annotations.Secure;
import io.swagger.annotations.*;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerResource class with openAPI
 *
 * @author Zvone Gazvoda
 * @since 2.5.0
 */
@Path("customer")
@Api
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
//@Secure
public class CustomerResource {

    @GET
    @ApiOperation(value = "Get customers list", tags = {"customers"}, notes = "Returns a list of customers.", authorizations = {
            @Authorization(value = "application")})
    @ApiResponses(value = {@ApiResponse(message = "List of customers", code = 200, response = Customer.class)})
    public Response getCustomers() {

        List<Customer> customers = new ArrayList<>();
        Customer c = new Customer("1", "John", "Doe");

        customers.add(c);

        return Response.status(Response.Status.OK).entity(customers).build();
    }
}
