package com.cristiano.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.cristiano.domain.Command;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Sonda;
import com.cristiano.vo.SondaVO;
import com.cristiano.vo.handler.SondaVOWapper;

@Component
@Path("/{malhaH}/{malhaV}/{sonda}")
public class SondaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sonda(
			@PathParam("malhaH") int h,
			@PathParam("malhaV") int v,
			@PathParam("sonda") SondaVOWapper sondaParam){
		
		Malha malha = Malha.build(h, v);
		Sonda son = null;
		for(SondaVO s : sondaParam.getValue()){
			Sonda sonda = Sonda.land(malha, s.getHorizontal(), s.getVertical(), s.getDirection());
			for(Command command : s.getCommands()){
				sonda = command.executar(sonda);
			}
			son = sonda;
		}
		return Response.ok().entity(son).build();
	}
}
