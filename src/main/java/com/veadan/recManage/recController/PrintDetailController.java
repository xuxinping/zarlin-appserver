package com.veadan.recManage.recController;

import com.veadan.config.resultFormat.JsonResult;
import com.veadan.recManage.recModel.PrintDetail;
import com.veadan.recManage.recService.PrintDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Veadan on 2017/6/19.
 */

@RestController
@RequestMapping("/api/v1/rec")
@Api(value ="打印详细",description = "打印详情或列表")
public class PrintDetailController {


    @Autowired
    private PrintDetailService printDetailService;

    @ApiOperation(value = "打印详细/列表", notes = "跟踪物资是列表，非跟踪物资是详细,recId;barcode")
    @PostMapping(value = "/PrintDetail",produces = "application/json")
    public JsonResult PrintDetailByBarcodeOrRecId(PrintDetail printDetail) {
        return printDetailService.printDetailFindBy(printDetail);
    }

}
