package com.example.datn_motel_project.repository.impl;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.repository.MotelInfoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class MotelInfoRepositoryImpl implements MotelInfoRepository {
    @PersistenceContext
    private EntityManager em;
    public PageCustomer<Long> getListIdMotelForSearch(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults){
        String query = "select distinct m.id from motel as m left join Location as l on m.location_id = l.id  left join project_motel as pm on m.project_id = pm.id " +
                "left join (motel_pay_info_detail as mpid inner join time_pay as tp on (mpid.time_pay_id = tp.id and tp.type_time = :timePay)) on m.id = mpid.motel_id " +
                "left join (motel_limit_gender as mlg inner join gender as g on mlg.gender_id = g.id)  on m.id = mlg.motel_id   " +
                "left join (motel_amenities_detail as mad inner join amenities as am on mad.amenties_id = am.id) on mad.motel_id = m.id " +
                "left join (motel_type_detail as mtd inner join motel_type as mt on mtd.type_id = mt.id) on mtd.motel_id = m.id  "
                +" where 1 = 1 and m.title like :inputTitle and pm.name like :inputProject and l.name like '%:location%' ";

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
            query += "and ( 1 = 2 ";
            for(String a: listAmenities){
                query += " or am.name = '"+a+"' ";
            }
            query += " ) ";
        }
        if(size > 0){
            query += " and m.area > "+size.toString()+" ";
        }
        PageCustomer<Long> pageCustomer = new PageCustomer<>();
        pageCustomer.setListObject(em.createQuery(query).setParameter("inputTitle","%"+inputTitle+"%").setParameter("inputProject","%"+inputProject+"%").setParameter("timePay",timePay).setParameter("location",location).setFirstResult(offset).setMaxResults(maxResults).getResultList());
        pageCustomer.setTotalRecord(em.createQuery(query).setParameter("inputTitle","%"+inputTitle+"%").setParameter("inputProject","%"+inputProject+"%").setParameter("timePay",timePay).setParameter("location",location).getResultList().size());
        pageCustomer.setPage(offset);
        pageCustomer.setLimitRecordInPage(maxResults);
        pageCustomer.setTotalPage(1 + pageCustomer.getTotalRecord() % maxResults);
        return pageCustomer;
    }
}
