package kr.sanchez.mtg;

import io.grpc.StatusRuntimeException;
import kr.sanchez.mtg.grpc.Card;
import kr.sanchez.mtg.grpc.CardServiceGrpc;
import io.grpc.Channel;
import kr.sanchez.mtg.grpc.Card_Request;
import kr.sanchez.mtg.grpc.Card_Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardServiceClient {

    private static final Logger logger = Logger.getLogger(CardServiceClient.class.getName());

    private final CardServiceGrpc.CardServiceBlockingStub blockingStub;

    public CardServiceClient(Channel channel) {
        blockingStub = CardServiceGrpc.newBlockingStub(channel);
    }

    public List<kr.sanchez.mtg.data.Card> getCards(String name) {
        Card_Request request = Card_Request.newBuilder().setName(name).build();
        List<kr.sanchez.mtg.data.Card> ret = new ArrayList<>();
        Iterator<Card_Response> response;
        try {
             response = blockingStub.getCardStock(request);
             while(response.hasNext()) {
                 Card_Response resp = response.next();
                 for (Card c : resp.getCardsList()) {
                     ret.add(new kr.sanchez.mtg.data.Card(c));
                 }
             }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING,"RPC failed: {0}", e.getStatus());
        }
        return ret;
    }
}
