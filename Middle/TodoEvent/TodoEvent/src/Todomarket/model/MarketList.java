package Todomarket.model;

import java.util.ArrayList;

public class MarketList {
    public ArrayList<Iteminfo> marketList = new ArrayList<>();

    public void addmarketList (Iteminfo info){

        marketList.add(info);
    }

    public String getEls(int i){
        return this.marketList.get(i).toString();
    }
}
