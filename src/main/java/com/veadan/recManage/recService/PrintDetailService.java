package com.veadan.recManage.recService;

import com.veadan.config.resultFormat.EnumCode;
import com.veadan.config.resultFormat.JsonResult;
import com.veadan.recManage.recDao.PrintDetailMapper;
import com.veadan.recManage.recModel.PrintDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Veadan on 2017/6/19.
 */

@Service
public class PrintDetailService {

    @Autowired
    private PrintDetailMapper printDetailMapper;


    public JsonResult printDetailFindBy(PrintDetail printDetail){

        List list=printDetailMapper.findPrintDetail(printDetail);

        if(list.isEmpty()){

            return new JsonResult(EnumCode.PARAMS_ERROR,"参数错误没查到");
        }else {

            return new JsonResult(list.size(),EnumCode.SUCCESS,"查找成功",list);
        }

    }
}
