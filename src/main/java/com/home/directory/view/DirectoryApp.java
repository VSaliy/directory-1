package com.home.directory.view;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class DirectoryApp{

	public static void main(String[] args) {
	    new MainWindow();
	  }
}

class MainWindow extends ApplicationWindow {
	public MainWindow() {
		super(null);
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

	protected Control createContents(Composite parent) {
	    // Create a Hello, World label
	    Label label = new Label(parent, SWT.CENTER);
	    label.setText("DirectoryApp");
	    return label;
	  }
}