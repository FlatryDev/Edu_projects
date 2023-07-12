package SearchFiles;

import java.io.File;

public class ChecksArgs {
    private final String[] args;
    private String checkResult = null;
    private File findPath;
    private long findSize;

    public ChecksArgs(String[] args) {
        this.args = args;
        check();
    }

    private void check() {
        if (args.length < 2) {
            checkResult = "Search parameters are not set";
            return;
        }
        findPath = new File(args[0]);
        if (!findPath.exists()) {
            checkResult = "Directory for search is not valid";
            return;
        }
        try {
            findSize = Long.parseLong(args[1])*1024*1024;
        }
        catch (NumberFormatException e) {
            checkResult = "Size for search file is set incorrectly";
            return;
        }
    }

    public String getCheckResult() {
        return checkResult;
    }

    public File getFindPath() {
        return findPath;
    }

    public long getFindSize() {
        return findSize;
    }
}
