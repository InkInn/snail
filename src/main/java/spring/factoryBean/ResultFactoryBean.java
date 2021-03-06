package spring.factoryBean;

import bean.ResultInfo;
import org.springframework.beans.factory.FactoryBean;

public class ResultFactoryBean implements FactoryBean<ResultInfo> {

    @Override
    public ResultInfo getObject() throws Exception {
        ResultInfo resultInfo = new ResultInfo();
        return resultInfo;
    }

    @Override
    public Class<ResultInfo> getObjectType() {
        return ResultInfo.class;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2147483647));
    }
}
