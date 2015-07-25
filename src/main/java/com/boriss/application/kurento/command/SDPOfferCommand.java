package com.boriss.application.kurento.command;

import org.kurento.client.EventListener;
import org.kurento.client.KurentoClient;
import org.kurento.client.MediaPipeline;
import org.kurento.client.OnIceCandidateEvent;
import org.kurento.client.WebRtcEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boriss.application.kurento.entity.CommandType;
import com.boriss.application.kurento.entity.Request;
import com.boriss.application.kurento.entity.Response;
import com.boriss.application.kurento.entity.Status;
import com.google.gson.Gson;

@Component
public class SDPOfferCommand implements Command {

	@Autowired
	Gson gson;

	@Autowired
	KurentoClient kurentoClient;

	@Override
	public Response execute(Request request) throws Exception {

		MediaPipeline pipeline = kurentoClient.createMediaPipeline();
		final WebRtcEndpoint webRtcEndpoint = new WebRtcEndpoint.Builder(pipeline).build();

		webRtcEndpoint.connect(webRtcEndpoint);

		String sdpOffer = request.getData();
		String sdpAnswer = webRtcEndpoint.processOffer(sdpOffer);

		webRtcEndpoint.addOnIceCandidateListener(new EventListener<OnIceCandidateEvent>() {
			@Override
			public void onEvent(OnIceCandidateEvent event) {
				webRtcEndpoint.addIceCandidate(event.getCandidate());
			}
		});

		webRtcEndpoint.gatherCandidates();

		Response response = new Response();

		response.setCommand(CommandType.SDP_OFFER);
		response.setStatus(Status.OK);
		response.setData(sdpAnswer);

		return response;
	}

	@Override
	public String toString() {
		return CommandType.SDP_OFFER.name();
	}

}
