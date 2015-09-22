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
import com.cristiano.domain.CorpoEspacial;
import com.cristiano.domain.Malha;
import com.cristiano.domain.Posicao;
import com.cristiano.domain.Sonda;
import com.cristiano.vo.SondaVO;
import com.cristiano.vo.handler.SondaVOWapper;

@Path("/deploy/{malhaH}/{malhaV}/{sonda}")
public class SondaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sonda(
			@PathParam("malhaH") int h,
			@PathParam("malhaV") int v,
			@PathParam("sonda") SondaVOWapper sondaParam){
		List<CorpoEspacial> resultList = new ArrayList<>();
		
		Posicao posicao = Posicao.fixPosition(h, v);
		Malha malha = Malha.build(posicao);
		for(SondaVO s : sondaParam.getValue()){
			Posicao pos = Posicao.fixPosition(s.getHorizontal(), s.getVertical());
			Sonda sonda = Sonda.land(malha, pos, s.getDirection());
			for(Command command : s.getCommands()){
				command.execute(sonda);
			}
			resultList.add(sonda);
		}
		return Response.ok().entity(resultList).build();
	}
}
