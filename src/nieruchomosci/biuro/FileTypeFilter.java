
package nieruchomosci.biuro;

import java.io.File;
import javax.swing.filechooser.*;

public class FileTypeFilter extends FileFilter {
    private String extension;
    private String desc;

    public FileTypeFilter(String extension, String desc) {
        this.extension = extension;
        this.desc = desc;
    }
    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        return f.getName().endsWith(desc);
    }
    @Override
    public String getDescription() {
        return desc + String.format(" (*%s)", extension);
    }

}
