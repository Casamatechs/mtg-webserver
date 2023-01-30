package kr.sanchez.mtg.data;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

@Introspected
public class Card {
    private String name;
    private String lang;
    private String cond;
    private String store;
    private int price;
    private int stock;
    private boolean foil;
    @Nullable
    private String set;

    private String imgUrl;

    public Card(kr.sanchez.mtg.grpc.Card card) {
        this.name = card.getName();
        this.lang = card.getLang();
        this.cond = card.getCond();
        this.store = card.getStore();
        this.price = card.getPrice();
        this.stock = card.getStock();
        this.foil = card.getFoil();
        this.set = card.getSet();
        this.imgUrl = card.getImgUrl();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
