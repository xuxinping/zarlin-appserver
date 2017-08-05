package com.veadan.recManage.recController;

import com.veadan.config.resultFormat.EnumCode;
import com.veadan.config.resultFormat.JsonResult;
import com.veadan.recManage.recModel.RecList;
import com.veadan.recManage.recService.RecService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;

/**
 * Created by Veadan on 2017/6/18.
 */


@RestController
@RequestMapping("/api/v1/rec")
@Api(value ="入库单信息",description = "入库单列表查询，详细查询，拍照接收，条码打印")
public class RecController {


    @Autowired
    private RecService recService;

    @ApiOperation(value = "入库单列表查询", notes = "参数：RecList 对象;该API提供通过" +
            "rec_main_id;item_id;rec_create_time等条件进行查询状态为00，也就是待入库的单子")
    @PostMapping(value = "/findRecList/{page}/{size}",produces = "application/json")
    public JsonResult findRecList(@PathVariable("page") int page, @PathVariable("size") int size,
                                  RecList recList, HttpServletRequest request) throws MalformedURLException {


        PageInfo<RecList> list= recService.findRecListByWhere(page,size,recList,request);
        if(list.getList().isEmpty()){

            return new JsonResult(EnumCode.FAILED,"查询失败");
        }else {

            return new JsonResult((int) list.getTotal(),EnumCode.SUCCESS,"成功",list.getList());
        }

    }



    @ApiOperation(value = "供应商未入库的统计",notes = "无参数，获取当前登录用户所在仓库的未入库的供应商名称，和条数")
    @GetMapping(value = "/findSuppRecList",produces = "application/json")
    public JsonResult findSuppRecList(HttpServletRequest request) throws MalformedURLException {

        return recService.findRecSuppList(request);
    }



}
