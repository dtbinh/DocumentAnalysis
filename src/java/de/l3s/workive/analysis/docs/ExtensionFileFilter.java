package de.l3s.workive.analysis.docs;


import java.io.File;
import java.io.FileFilter;

public class ExtensionFileFilter implements FileFilter {
	private String suffix;

	public ExtensionFileFilter(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().toString().endsWith(suffix);
	}
}
