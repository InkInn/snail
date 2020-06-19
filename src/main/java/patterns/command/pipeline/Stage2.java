//package patterns.command.pipeline;
//
//import org.apache.commons.pipeline.StageContext;
//import org.apache.commons.pipeline.StageException;
//import org.apache.commons.pipeline.stage.BaseStage;
//
///**
// * @author rcli
// * Created on 2019/9/1.
// */
//
//public class Stage2 extends BaseStage {
//    @Override
//    public void init(StageContext stageContext) {
//        context = stageContext;
//        System.out.println("PreProcessing in " + Stage2.class.getSimpleName());
//    }
//
//    @Override
//    public void preprocess() throws StageException {
//
//    }
//
//    @Override
//    public void process(Object o) throws StageException {
//        System.out.println("Stage2 ----> : " + o);
//        this.emit(o);
//    }
//
//    @Override
//    public void postprocess() throws StageException {
//
//    }
//
//    @Override
//    public void release() {
//
//    }
//}
