package kr.sanchez.mtg;

import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannelBuilder;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import kr.sanchez.mtg.data.Card;

import java.util.List;

@Controller("/")
public class HelloController {

    private static CardServiceClient grpc = new CardServiceClient(ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build());

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> index(@QueryValue String cardName) {
        return grpc.getCards(cardName);
    }
}
