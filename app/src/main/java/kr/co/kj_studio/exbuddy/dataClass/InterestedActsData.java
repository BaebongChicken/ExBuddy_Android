package kr.co.kj_studio.exbuddy.dataClass;

import java.io.Serializable;

/**
 * Created by JinHee on 2015-12-14.
 */
public class InterestedActsData implements Serializable {
    public String actsName;
    public String actsLevel;



    public InterestedActsData(String mActsName, String mActsLevel) {
        this.actsName = mActsName;
        this.actsLevel = mActsLevel;
    }
}
