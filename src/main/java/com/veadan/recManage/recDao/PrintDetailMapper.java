package com.veadan.recManage.recDao;

import com.veadan.recManage.recModel.PrintDetail;

import java.util.List;

/**
 * Created by Veadan on 2017/6/19.
 */
public interface PrintDetailMapper {
    public List<PrintDetail> findPrintDetail(PrintDetail printDetail);
}
