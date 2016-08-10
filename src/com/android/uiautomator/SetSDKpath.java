package com.android.uiautomator;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.android.uiautomator.actions.ImageHelper;

public class SetSDKpath extends Action{

    private UiAutomatorViewer mViewer;

    public SetSDKpath(UiAutomatorViewer viewer) {

        super("&Open");
        mViewer = viewer;
    }
    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageHelper.loadImageDescriptorFromResource("images/open-folder.png");
    }

    @Override
    public void run() {
        OpenDialog d = new OpenDialog(Display.getDefault().getActiveShell());
        if (d.open() != OpenDialog.OK) {
            return;
        }

        UiAutomatorModel model;
        try {
            model = new UiAutomatorModel(d.getXmlDumpFile());
        } catch (Exception e) {
            // FIXME: show error
            return;
        }

        Image img = null;
        File screenshot = d.getScreenshotFile();
        if (screenshot != null) {
            try {
                ImageData[] data = new ImageLoader().load(screenshot.getAbsolutePath());

                // "data" is an array, probably used to handle images that has multiple frames
                // i.e. gifs or icons, we just care if it has at least one here
                if (data.length < 1) {
                    throw new RuntimeException("Unable to load image: "
                            + screenshot.getAbsolutePath());
                }

                img = new Image(Display.getDefault(), data[0]);
            } catch (Exception e) {
                // FIXME: show error
                return;
            }
        }

        mViewer.setModel(model, d.getXmlDumpFile(), img);
    }
}
