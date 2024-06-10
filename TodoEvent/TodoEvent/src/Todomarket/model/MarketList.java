package Todomarket.model;

import java.util.ArrayList;

public class MarketList {
    public ArrayList<Iteminfo> marketList = new ArrayList<>();

    public void addmarketList (Iteminfo info){

        marketList.add(info);
    }

}
