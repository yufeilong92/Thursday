package com.xuechuan.xcedu.event;

import com.xuechuan.xcedu.vo.DayHomeBeanVo;
import com.xuechuan.xcedu.vo.DayHomeVo;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: xcedu
 * @Package com.xuechuan.xcedu.event
 * @Description: 每日一练首页
 * @author: L-BackPacker
 * @date: 2018.12.26 下午 4:57
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class DayHomeEvent {
    private List<DayHomeBeanVo> data;

    public DayHomeEvent( List<DayHomeBeanVo> data) {
        this.data = data;
    }

    public  List<DayHomeBeanVo> getData() {
        return data;
    }
}
