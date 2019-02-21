package myWebRest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import myWebRest.utils.OrderVO;
import myWebRest.utils.OrdersMap;

@Path("/order")
public class OrderResource {

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Response getOrder(@QueryParam("ordId") String orderNo) {
         System.out.println("LLLL"+orderNo);
	  OrderVO order = new OrderVO();
	  OrdersMap map = new OrdersMap();
	  int ordNo = Integer.parseInt(orderNo);
	  order = map.getOrder(ordNo); 
		 if(order == null) {
			 throw new OrderNotFoundException("Given id matching order not present");
		 }else {
			 return Response.status(200).entity(order).build();
	     }
  }
  
  @GET
  @Path("/all")
  public List<OrderVO> getAllOrder() {
      OrdersMap map = new OrdersMap();
	  List<OrderVO> list = map.getAll(); 
	  return list;
		
   }
  
  
}

