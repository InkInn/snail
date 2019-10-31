package patterns.command.pipeline;

import org.apache.commons.pipeline.Pipeline;
import org.apache.commons.pipeline.Stage;
import org.apache.commons.pipeline.StageDriverFactory;
import org.apache.commons.pipeline.driver.SynchronousStageDriverFactory;

/**
 * @author rcli
 * Created on 2019/9/1.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Pipeline pipeline = new Pipeline();

        Stage stage1 = new Stage1();
        Stage stage2 = new Stage2();
        Stage stage3 = new Stage3();
        StageDriverFactory sdf = new SynchronousStageDriverFactory();
        pipeline.addStage(stage1,sdf);
        pipeline.addStage(stage2,sdf);
        pipeline.addStage(stage3,sdf);
//        stage1.init(pipeline);
//        stage2.init(pipeline);
//        stage3.init(pipeline);
        pipeline.getSourceFeeder().feed("Hello world!");
        pipeline.run();
    }
}
