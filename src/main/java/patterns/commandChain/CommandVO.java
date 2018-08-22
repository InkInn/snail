package patterns.commandChain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;

public class CommandVO {
    public final static String DIVIDE_FLAG = " ";

    public final static String PREFIX = "-";

    private String commandName = "";

    private ArrayList<String> paramList = new ArrayList<>();

    private ArrayList<String> dataList = new ArrayList<>();

    public CommandVO(String commandStr){
        if(StringUtils.isNotBlank(commandStr)){
            String[] complexStr = commandStr.split(CommandVO.DIVIDE_FLAG);
            this.commandName = complexStr[0];
            for(int i = 1; i < complexStr.length; i++){
                String str = complexStr[i];
                if(str.indexOf(CommandVO.PREFIX) == 0){
                    this.paramList.add(str.replace(CommandVO.PREFIX,"").trim());
                }else {
                    this.dataList.add(str.trim());
                }
            }
        }else {
            System.out.println("命令解析失败，必须传递一个命令此岸鞥执行");
        }
    }


    public String getCommandName() {
        return commandName;
    }

    public ArrayList<String> getParamList() {
        if(this.paramList.size() == 0){
            this.paramList.add("");
        }
        return new ArrayList(new HashSet(this.paramList));
    }

    public ArrayList<String> getDataList() {
        return dataList;
    }
}
