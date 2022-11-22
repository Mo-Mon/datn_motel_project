package com.example.datn_motel_project.repository.impl;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.repository.MotelInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MotelInfoRepositoryImpl implements MotelInfoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Integer getTotalRecord(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag){
        String query = "select count(distinct m.id) as count from motel as m left join location as l on m.location_id = l.id  left join project_motel as pm on m.project_id = pm.id " +
                "left join (motel_pay_info_detail as mpid inner join time_pay as tp on (mpid.time_pay_id = tp.id and tp.type_time = ?)) on m.id = mpid.motel_id " +
                "left join (motel_limit_gender as mlg inner join gender as g on mlg.gender_id = g.id)  on m.id = mlg.motel_id   " +
                "left join (motel_amenities_detail as mad inner join amenities as am on mad.amenties_id = am.id) on mad.motel_id = m.id " +
                "left join (motel_type_detail as mtd inner join motel_type as mt on mtd.type_id = mt.id) on mtd.motel_id = m.id  "
                +" where 1 = 1 " ;
//                "and m.title like ? and pm.name like ? and l.name like ? ";

        if(flag){
            query += " and m.count_hired < m.count ";
        }
        if(listPriceRange != null && listPriceRange.size() > 0){
            query += "and ( 1 = 2 ";
            for(PriceRange p: listPriceRange){
                query += " or ( "+p.getMin().toString()+" < mpid.price and mpid.price < "+p.getMax().toString()+" ) ";
            }
            query += " ) ";
        }
        if(listMotelType != null && listMotelType.size() > 0){
            query += "and ( 1 = 2 ";
            for(String mt: listMotelType){
                query += " or mt.name = '"+mt+"' ";
            }
            query += " ) ";
        }
        if(listAmenities != null && listAmenities.size() > 0){
            query += " and ( 1 = 2 ";
            for(String a: listAmenities){
                query += " or am.name = '"+a+"' ";
            }
            query += " ) ";
        }
        if(size != null && size > 0){
            query += " and m.area > "+size.toString()+" ";
        }
        List<Object> listParam = new ArrayList<>();
        if(!BaseLogic.checkEmptyString(timePay)) {
            listParam.add(timePay);
        }
        if(!BaseLogic.checkEmptyString(inputTitle)) {
            query += " and m.title like ?";
            listParam.add("%"+inputTitle+"%");
        }
        if(!BaseLogic.checkEmptyString(inputProject)) {
            query += " and pm.name like ?";
            listParam.add("%"+inputProject+"%");
        }
        if(!BaseLogic.checkEmptyString(location)){
            query += " and l.name like ?";
            listParam.add(location);
        }
        return jdbcTemplate.query(query,listParam.toArray(),(rs, rowNum) ->
                new Integer(rs.getInt("count"))
        ).get(0);
    }
    public PageCustomer<Long> getListIdMotelForSearch(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults){
        String query = "select distinct m.id from motel as m " +
                "left join location as l on m.location_id = l.id  " +
                "left join project_motel as pm on m.project_id = pm.id " +
                "left join (motel_pay_info_detail as mpid inner join time_pay as tp on (mpid.time_pay_id = tp.id and tp.type_time = ?)) on m.id = mpid.motel_id " +
                "left join (motel_limit_gender as mlg inner join gender as g on mlg.gender_id = g.id)  on m.id = mlg.motel_id   " +
                "left join (motel_amenities_detail as mad inner join amenities as am on mad.amenties_id = am.id) on mad.motel_id = m.id " +
                "left join (motel_type_detail as mtd inner join motel_type as mt on mtd.type_id = mt.id) on mtd.motel_id = m.id  "
                +" where 1 = 1  ";

        if(flag){
            query += " and m.count_hired < m.count ";
        }
        if(listPriceRange != null && listPriceRange.size() > 0){
            query += "and ( 1 = 2 ";
            for(PriceRange p: listPriceRange){
                query += " or ( mpid.price > "+p.getMin().toString()+" and mpid.price < "+p.getMax().toString()+" ) ";
            }
            query += " ) ";
        }
        if(listMotelType != null && listMotelType.size() > 0){
            query += "and ( 1 = 2 ";
            for(String mt: listMotelType){
                query += " or mt.name = '"+mt+"' ";
            }
            query += " ) ";
        }
        if(listAmenities != null && listAmenities.size() > 0){
            query += "and ( 1 = 2 ";
            for(String a: listAmenities){
                query += " or am.name = '"+a+"' ";
            }
            query += " ) ";
        }
        if(size != null && size > 0){
            query += " and m.area > "+size.toString()+" ";
        }
        List<Object> listParam = new ArrayList<>();
        if(!BaseLogic.checkEmptyString(timePay)) {
            listParam.add(timePay);
        }
        if(!BaseLogic.checkEmptyString(inputTitle)) {
            query += " and m.title like ?";
            listParam.add("%"+inputTitle+"%");
        }
        if(!BaseLogic.checkEmptyString(inputProject)) {
            query += " and pm.name like ?";
            listParam.add("%"+inputProject+"%");
        }
        if(!BaseLogic.checkEmptyString(location)){
            query += " and l.name like ?";
            listParam.add(location);
        }
        query += " limit ? offset ? ";
        listParam.add(maxResults);
        listParam.add(offset);
        System.out.println(query);
        PageCustomer<Long> pageCustomer = new PageCustomer<>();
        pageCustomer.setListObject(jdbcTemplate.query(query,listParam.toArray(),(rs, rowNum) ->
                        new Long(rs.getLong("id"))
        ));
        pageCustomer.setTotalRecord(getTotalRecord(timePay,inputTitle, inputProject,location, listPriceRange, listMotelType, listAmenities ,size,flag));
        pageCustomer.setPage(offset);
        pageCustomer.setLimitRecordInPage(maxResults);
        pageCustomer.setTotalPage((pageCustomer.getTotalRecord()-1)/pageCustomer.getLimitRecordInPage() + 1);
        return pageCustomer;
    }
}
