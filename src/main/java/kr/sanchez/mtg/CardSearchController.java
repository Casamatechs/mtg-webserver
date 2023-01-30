package kr.sanchez.mtg;

import io.grpc.ManagedChannelBuilder;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import kr.sanchez.mtg.data.Card;
import kr.sanchez.mtg.data.DetailedCard;

import java.util.Comparator;
import java.util.List;

@Controller("/searchCard")
public class CardSearchController {

    private static CardServiceClient grpc = new CardServiceClient(ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build());

    @Get("/{cardName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> index(@PathVariable String cardName) {
        return grpc.getCards(cardName);
    }

    @Get("/detailed/{cardName}")
    public DetailedCard detailedResults(@PathVariable String cardName) {
        List<Card> cardList = grpc.getCards(cardName);
        Card bestValue = cardList.stream()
                .min(Comparator.comparing(Card::getPrice))
                .orElse(null);
        return new DetailedCard(bestValue, cardList);
    }
}
