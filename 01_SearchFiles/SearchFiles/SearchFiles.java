package SearchFiles;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class SearchFiles {
    static final private int COUNT_THREADS = Runtime.getRuntime().availableProcessors();
    public static Logger log = Logger.getLogger(SearchFiles.class.getName());
    public static void main(String[] args) {
        ChecksArgs argsCh = new ChecksArgs(args);
        if (!argsCh.getCheckResult().isEmpty()) {
            System.out.println(argsCh.getCheckResult());
            return;
        }

        ForkJoinPool fJoinPool = new ForkJoinPool(COUNT_THREADS);
        File[] resultSearch = fJoinPool.invoke(new FilesForkJoinTask(argsCh.getFindPath(), argsCh.getFindSize()));
        Arrays.stream(resultSearch)
                .sorted((f1, f2) -> {if(f1.length() < f2.length()) return 1; else if(f1.length() > f2.length()) return -1; else return 0; })
                .forEach(f -> System.out.format("%s - %.2f Mb \n",f.getPath(), (double)f.length()/1024/1024));
    }
}
