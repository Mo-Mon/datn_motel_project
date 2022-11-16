package com.example.datn_motel_project.Constant.listmotel;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum PriceRange {
    PRICE_RANGE_0(0,0,1500000),
    PRICE_RANGE_1(1,1500000,2500000),
    PRICE_RANGE_2(2,2500000,3500000),
    PRICE_RANGE_3(3,3500000,4000000),
    PRICE_RANGE_4(4,4000000,6000000),
    PRICE_RANGE_5(5,6000000,8500000),
    PRICE_RANGE_6(6,8500000,2147483647);

    Integer id;
    Integer min;
    Integer max;

    PriceRange(int id, int min, int max) {
        this.id = id;
        this.min = min;
        this.max = max;
    }

    public List<PriceRange> getListPriceRangeById(List<Integer> listId){
        List<PriceRange> priceRanges = new ArrayList<>();
        for(Integer id: listId){
            PriceRange priceRange = getPriceRangeByid(id);
            if(priceRange != null){
                priceRanges.add(priceRange);
            }
        }
        return priceRanges;
    }

    public PriceRange getPriceRangeByid(Integer id){
        for(PriceRange priceRange: PriceRange.values()){
            if(priceRange.getId() == id){
                return priceRange;
            }
        }
        return null;
    }
}
