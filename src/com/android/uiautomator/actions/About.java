package com.android.uiautomator.actions;

import javax.swing.JOptionPane;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

import com.android.uiautomator.UiAutomatorViewer;

import MyStrings.ComStrings;

public class About extends Action {
    private UiAutomatorViewer mViewer;

    public About(UiAutomatorViewer viewer) {
        super("&About");

        mViewer = viewer;
    }
    
    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageHelper.loadImageDescriptorFromResource("images/about_16px.png");
    }
    @Override
    public void run() {
    	About();
    }
    
    
    public void About(){
    	Object[] options = { ComStrings.Confirm_button }; 
    	JOptionPane.showOptionDialog(null, ComStrings.About, ComStrings.About_button, 
    			
    	JOptionPane.DEFAULT_OPTION, 
//    	JOptionPane.WARNING_MESSAGE, 
    	JOptionPane.WARNING_MESSAGE,
    	null, options, options[0]); 
    }
}
