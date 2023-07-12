package SearchFiles;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class FilesForkJoinTask extends RecursiveTask<File[]> {
    private final File[] findPaths;
    private final long findSize;

    public FilesForkJoinTask(File[] findPath, long findSize) {
        this.findPaths = findPath;
        this.findSize = findSize;
    }

    public FilesForkJoinTask(File findPath, long findSize) {
        this(new File[]{findPath}, findSize);
    }

    private File[] mergeArrays(File[] first, File[] second) {
        File[] result = null;
        if (first == null || first.length == 0) result = second;
        else if (second == null || second.length == 0) result = first;
        else {
            result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
        }
        return (result==null)? new File[0] : result;
    }

    private File[] loopDir(File[] dirs) {
        File[] result = null;
        if (dirs != null && dirs.length > 0) {
            int cntNew = dirs.length/2;
            FilesForkJoinTask taskCompute = new FilesForkJoinTask((cntNew == 0)?dirs:Arrays.copyOfRange(dirs,cntNew,dirs.length), findSize);
            FilesForkJoinTask taskFork = null;
            if (cntNew > 0) {
                taskFork = new FilesForkJoinTask(Arrays.copyOfRange(dirs, 0, cntNew), findSize);
                taskFork.fork();
            }

            File[] resultCompute = taskCompute.compute();
            if (cntNew > 0) {
                File[] resultFork = taskFork.join();
                result = mergeArrays(resultFork, resultCompute);
            } else {
                result = resultCompute;
            }
        } else {
            result = new File[0];
        }

        return result;
    }

    @Override
    protected File[] compute() {
        //SearchFiles.log.info("Thread.currentThread().getName() - " + Thread.currentThread().getName());
        if (findPaths.length == 1) {
            ListFiles files = new ListFiles(findPaths[0]);
            return mergeArrays(
                    files.getFilesByParams(findSize),
                    loopDir(files.getPaths())
            );
        } else {
            return loopDir(findPaths);
        }
    }
}
