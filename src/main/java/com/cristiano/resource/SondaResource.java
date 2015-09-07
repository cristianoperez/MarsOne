package com.cristiano.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cristiano.domain.Command;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Sonda;
import com.cristiano.vo.SondaVO;
import com.cristiano.vo.handler.SondaVOWapper;

@Path("/{malhaH}/{malhaV}/{sonda}")
public class SondaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sonda(
			@PathParam("malhaH") int h,
			@PathParam("malhaV") int v,
			@PathParam("sonda") SondaVOWapper sondaParam){
		List<Sonda> resultList = new ArrayList<>();
		
		Malha malha = Malha.build(h, v);
		for(SondaVO s : sondaParam.getValue()){
			Sonda sonda = Sonda.land(malha, s.getHorizontal(), s.getVertical(), s.getDirection());
			for(Command command : s.getCommands()){
				sonda = command.executar(sonda);
			}
			resultList.add(sonda);
		}
		return Response.ok().entity(resultList).build();
	}
}
