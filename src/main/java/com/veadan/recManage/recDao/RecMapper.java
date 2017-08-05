package com.veadan.recManage.recDao;

import com.veadan.recManage.recModel.RecList;
import com.veadan.recManage.recModel.RecSuppList;

import java.util.List;

/**
 * Created by Veadan on 2017/6/18.
 */
public interface RecMapper {

    public List<RecList> findRecListBy(RecList recList);

    public List<RecSuppList> findRecSuppList(String invPhysic);
}
