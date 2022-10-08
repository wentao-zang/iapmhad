package com.iapmhad.ame_hdym.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iapmhad.ame_hdym.dao.HoleMeasuretDao;
import com.iapmhad.ame_hdym.entity.HoleMeasureEntity;
import com.iapmhad.ame_hdym.service.HoleMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service("holeMeasureService")
public class HoleMeasureServiceImpl extends ServiceImpl<HoleMeasuretDao, HoleMeasureEntity> implements HoleMeasureService {


    @Autowired
    HoleMeasuretDao holeMeasuretDao;

    @Override
    public List<HoleMeasureEntity> getLi(int id) {
        List<HoleMeasureEntity> li = holeMeasuretDao.getLi(id);
        return li;
    }

    @Override
    public List<HoleMeasureEntity> getChongJi(String strtime) {
        List<HoleMeasureEntity> chongJi = holeMeasuretDao.getChongJi(strtime);
        return chongJi;
    }

    @Override
    public HoleMeasureEntity getLast() {
        HoleMeasureEntity last = holeMeasuretDao.getLast();
        return last;
    }

    @Override
    public List<HoleMeasureEntity> getHoleMeasure(String aircraftid, String flightid,String productnum, Double holedia) {
        return null;
    }

    @Override
    public List<HoleMeasureEntity> getHoleMea(Double holedia, String time) {
        return null;
    }

    @Override
    public Object[] strrefine(String args) {
//        String str="[[0,[\"zhinan\",\"daohang\",\"cexiangdaohang\"]],[1,[\"zhinan\",\"daohang\",\"dingbudaohang\"]]]";
        Pattern p1= Pattern.compile("\"(.*?)\"");
        Matcher m = p1.matcher(args);
        List<String> params = new ArrayList<>();
//        String arr[] = new String[500];
        while (m.find()) {
//            System.out.println((m.group().trim().replace("\"","")));
            params.add((m.group().trim().replace("\"","")));
        }
        Object[] objects = params.toArray();
        return objects;
    }
}